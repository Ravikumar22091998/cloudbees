package com.ravi.Cloud_bees_test;


public class product_entity {
	
	private Integer id;
	private String Name;
	private String Description;
	private Integer price;
	private Integer quantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "product_entity [id=" + id + ", Name=" + Name + ", Description=" + Description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	public product_entity(Integer id, String name, String description, Integer price, Integer quantity) {
		super();
		this.id = id;
		this.Name = name;
		this.Description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
}