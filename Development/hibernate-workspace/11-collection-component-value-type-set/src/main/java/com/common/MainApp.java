package com.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dao.ItemDaoImpl;
import com.model.Image;
import com.model.Item;


public class MainApp {
	
	public static void main(String[] args) {
		testItem();
	}
	
	static void testItem() 
	{
		ItemDaoImpl itemDao = new ItemDaoImpl();
		
		// Insert Item
		
		Set<Image> images = new HashSet<Image>();
		images.add(new Image("Foo", "foo.jpg", 40, 20));
		images.add(new Image("Boo", "boo.jpg", 70, 30));
		
		Item item = new Item("BAR2", images);
		
		System.out.println(itemDao.insert(item) != -1 ? "Record inserted" : "Record Not Inserted");
		
		// Select All Item 
		
		List<Item> listItem = itemDao.getAllItem();
		System.out.println("listItem :" + listItem);
	}
}
