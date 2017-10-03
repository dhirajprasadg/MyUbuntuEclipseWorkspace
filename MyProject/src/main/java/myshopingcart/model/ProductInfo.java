package myshopingcart.model;

import java.io.Serializable;

import myshopingcart.entity.Product;

import org.springframework.web.multipart.MultipartFile;

public class ProductInfo implements Serializable {
	private static final long serialVersionUID = -1000119078147252957L;
	private String code;
	private String name;
	private double price;
	private boolean newProduct = false;
	private MultipartFile fileData;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "ProductInfo [code=" + code + ", name=" + name + ", price=" + price + ", newProduct=" + newProduct + ", fileData=" + fileData + "]";
	}

	public ProductInfo() {
	}

	public ProductInfo(Product product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	// constructor ,
	// Hibernate query.
	public ProductInfo(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

}
