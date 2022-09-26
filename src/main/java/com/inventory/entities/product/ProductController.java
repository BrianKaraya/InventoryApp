package com.inventory.entities.product;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.FileUploadUtil;
import com.inventory.entities.category.Category;
import com.inventory.entities.category.CategoryRepository;
import com.inventory.entities.user.User;
import com.inventory.entities.user.UserService;

import net.bytebuddy.implementation.bytecode.Throw;

@Controller
@Validated
public class ProductController {
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private UserService service;

	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		java.util.List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);

		return "product_form";
	}

	@PostMapping("/products/save")
	public String saveProduct(@ModelAttribute(name = "product") Product product, RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		product.setProduct_photo(fileName);
		// product.set(fileName);
		product.setSize(multipartFile.getSize());
		// byte[] bytes = Files.readAllBytes(fileName.to)
		product.setContent(multipartFile.getBytes());
		Product savedProduct = productRepo.save(product);

		String uploadDir = "product-photos/" + savedProduct.getId();
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + fileName);
		}

		ra.addFlashAttribute("message", "The product has been saved succesfully.");
		return "redirect:/products";

	}

	@GetMapping("/products")
	public String listProducts(Model model) {

		List<Product> listProducts = (List<Product>) productRepo.findAll();
		model.addAttribute("listProducts", listProducts);

		return "products";
	}

	@GetMapping("/products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);

		java.util.List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("listCategories", listCategories);

		return "product_form";
	}

	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		productRepo.deleteById(id);

		return "redirect:/products";

	}

	@GetMapping("/download")
	public void downloadFile(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<Product> result = productRepo.findById(id);
		if (!result.isPresent()) {
			throw new Exception("Could not find document/image with ID: " + id);
		}

		Product product = result.get();

		response.setContentType("application/octet-stream");
		String headerKey = "Content-disposition";
		String headerValue = "attachment; filename=" + product.getName();

		response.setHeader(headerKey, headerValue);

		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(product.getContent());
		outputStream.close();
	}

}
