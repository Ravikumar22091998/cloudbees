package com.ravi.Cloud_bees_test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class service {

	private static List<product_entity> Products = new ArrayList<>();
	private static int counter=0;
	static 
	{
		Products.add(new product_entity(++counter, "Apple", "friut", 20, 20));
	}
	public List<product_entity> findall()
	{
		return Products;
	}
	
	public product_entity findsingle(int id)
	{
		
		product_entity temp_pr=null;
		for (product_entity pr : Products)
		{
			if (pr.getId()==id)
			{   System.out.print(pr);
				temp_pr=pr;
			}
			
		}
		System.out.println(temp_pr);
		return temp_pr;
	}

	public static product_entity createproduct(product_entity product) {
		// TODO Auto-generated method stub
		product.setId(++counter);
		Products.add(product);
		return product;
		
	}

	public static Boolean deleteproduct(int id) {
		// TODO Auto-generated method stub
		Boolean temp_pr=false;
		for (product_entity pr : Products)
		{
			if (pr.getId()==id)
			{
				return Products.remove(pr);
			}
			
		}
		
		return temp_pr;
	}
	
	public static product_entity updateproduct(product_entity product,product_entity newproduct) {
		if (newproduct.getName()!=null)
		{
			product.setName(newproduct.getName());
		}
		if (newproduct.getDescription()!=null)
		{
			product.setDescription(newproduct.getDescription());
		}
		if (newproduct.getPrice()!=null)
		{
			product.setPrice(newproduct.getPrice());
		}
		if (newproduct.getQuantity()!=null)
		{
			product.setQuantity(newproduct.getQuantity());
		}
			
		return product;
		
	}

	public static product_entity updateproduct_price(product_entity temp_pr, String opr, int value) {
		if (opr.equalsIgnoreCase("Discount"))
			
		{
			if (value <= 100)
			{   int ext_price=temp_pr.getPrice();
				int new_price=ext_price-(ext_price*value/100);
				temp_pr.setPrice(new_price);
			}
	
		}
		if (opr.equalsIgnoreCase("tax"))
		{
			if (value >= 0)
			{   int ext_price=temp_pr.getPrice();
				int new_price=ext_price+(ext_price*value/100);
				temp_pr.setPrice(new_price);
			}
	
		}
	
		return temp_pr;
	}
	
	
}
