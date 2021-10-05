package com.example.springboot.project.onlineshopping.entity;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="dealler_details")
public class Dealler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Integer product_id;
	
	@Column(name="prod_name")
	private String product_name;
	@Column(name="prod_desc")
	private String product_description;
	@Column(name="prod_price")
	private Integer price;
	/*@Lob
	@Column(name="prod_image", length=64)
	private byte[] image;*/
	public Dealler() {
		
	}
	public Dealler(Integer product_id, String product_name, String product_description, Integer price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.price = price;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, product_description, product_id, product_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dealler other = (Dealler) obj;
		return Objects.equals(price, other.price) && Objects.equals(product_description, other.product_description)
				&& Objects.equals(product_id, other.product_id) && Objects.equals(product_name, other.product_name);
	}
	@Override
	public String toString() {
		return "Dealler [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", price=" + price + "]";
	}
	
}
