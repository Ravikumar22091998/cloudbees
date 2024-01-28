package com.ravi.Cloud_bees_test;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {
	
	private service services;
	
	
	
	public controller(service services) {
		
		this.services=services;
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/products")
	public List<product_entity> getproducts()
	{
		return services.findall();
	}

	 
	@GetMapping("/products/{id}")
	public product_entity finduser(@PathVariable int id)
	{
		product_entity product= services.findsingle(id);
		if (product==null)
		{
			throw new UserNotFoundException("id:"+id);
		}
		else
		{
		return product;
		}
	}
	
	@PostMapping("/add_product")
	public product_entity add_product(@RequestBody product_entity product)
	{
		return service.createproduct(product);
	}
	
	@DeleteMapping("/remove_product/{id}")
	public Boolean remove_product(@PathVariable int id)
	{
		Boolean status=service.deleteproduct(id);
		if (status==false)
		{
			throw new UserNotFoundException("id:"+id);
		}
		return status;
	}
	
	@PatchMapping("/update_product/{id}")
	public product_entity update_product(@PathVariable int id,@RequestBody product_entity product)
	{
		product_entity temp_pr=services.findsingle(id);
		if (temp_pr==null)
		{
			throw new UserNotFoundException("id:"+id);
		}
		else
		{
		return service.updateproduct(temp_pr, product);
		
		}
	}
	
	@PatchMapping("/update_product_misc/{id}/{opr}/{value}")
	public product_entity update_product_disc(@PathVariable int id,@PathVariable String opr,@PathVariable int value)
	{
		product_entity temp_pr=services.findsingle(id);
		if (temp_pr==null)
		{
			throw new UserNotFoundException("id:"+id);
		}
		else
		{
			
		if (opr!=null && (opr.equalsIgnoreCase("tax") || opr.equalsIgnoreCase("discount")) && value > 0)
		{
			 return service.updateproduct_price(temp_pr,opr,value);
		}
		
		}
		return temp_pr;
	}
}
