package com.inventory.entities.product;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.FileUploadUtil;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;

	

}
