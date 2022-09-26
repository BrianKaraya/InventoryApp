package com.inventory.entities.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.inventory.entities.category.Category;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 512, nullable = false, unique = true)
	private String name;

	private float price;
	
	@Column(length = 512, nullable = false, unique = true)
	private Integer quantity;

	private byte[] content;

	@Column(length = 45, nullable = false)
	private String product_photo;

	
	private Long size;

	public Product(Integer id, String name, float price, Integer quantity,byte[] content,String product_photo, Long size) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
		this.content = content;
		this.product_photo = product_photo;
		this.size = size;
	}

	public Product() {

	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	@Transient
	public String getProductImagePath() {
		if (id == null || product_photo == null)
			return "/images/products/blank_photo.jpg";

		return "/product-photos/" + id + "/" + product_photo;

	}

}
