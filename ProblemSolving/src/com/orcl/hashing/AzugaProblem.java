package com.orcl.hashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AzugaProblem {

	public static void main(String[] args) {

		List<List<String>> products = new ArrayList<List<String>>();
		List<List<String>> discounts = new ArrayList<List<String>>();
		List<String> p1 = new ArrayList<String>();
		p1.add("10"); p1.add("sales");p1.add("EMPTY");
		List<String> p2 = new ArrayList<String>();
		p2.add("200"); p2.add("dhamaka");p2.add("sales");
		List<String> d1 = new ArrayList<String>();
		d1.add("sales");d1.add("1");d1.add("10"); 
		List<String> d2 = new ArrayList<String>();
		d2.add("dhamaka");d2.add("0");d2.add("10"); 
		products.add(p1);
		products.add(p2);
		discounts.add(d1);
		discounts.add(d2);
		System.out.println(getMinimumAmount(products, discounts));
		
		
		
	}

	private static int getMinimumAmount(List<List<String>> products, List<List<String>> discounts) {
		Map<String, Discount> discountMap = getDiscountMap(discounts);
		int sum =0;		
		for(List<String> product : products) {
		   int price = Integer.parseInt(product.get(0));
		   int calculatedPrice = price;
		   for(int i =1; i< product.size();i++) {
			   String tag = product.get(i);
			   Discount discount = discountMap.get(tag);
			   if(tag.equals("EMPTY")) {
				   calculatedPrice = Math.min(calculatedPrice, price);
			   }else {
				   calculatedPrice = Math.min(calculatedPrice, calculatePrice(price, discount));
			   }
		   }
		   sum += calculatedPrice;
		}
		return sum;
	}
	static class Discount {
		int type;
		int discount;
		public Discount(String t, String d) {
			type = Integer.parseInt(t);
			discount = Integer.parseInt(d);
		}
	}
	static Map<String, Discount> getDiscountMap(List<List<String>> discounts){
		
		Map<String, Discount> discountMap = new HashMap<String,Discount>();
		for(List<String> d : discounts) {
			discountMap.put(d.get(0), new Discount(d.get(1), d.get(2)));
		}
		return discountMap;
	}
	static int calculatePrice(int price, Discount discount) {
		double c = 0.0;
		switch(discount.type) {
		case 0 :
			c = discount.discount;
			break;
		case 1 :
			c = price - (price*discount.discount/100);
			break;
		case 2 :
			c = price - discount.discount;
			break;
		default :
			c = price;
		}
		return (int)c;
	}

}
