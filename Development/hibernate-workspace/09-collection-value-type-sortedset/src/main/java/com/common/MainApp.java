package com.common;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.dao.ItemDaoImpl;
import com.model.Item;


public class MainApp {
	
	public static void main(String[] args) {
		testItem();
	}
	
	static void testItem() 
	{
		ItemDaoImpl itemDao = new ItemDaoImpl();
		
		// Insert Item
		
		SortedSet<String> images = new TreeSet<String>();
		images.add("foo.jpg");
		images.add("bar.jpg");
		
		Item item = new Item("AAR2", images);
		
		System.out.println(itemDao.insert(item) != -1 ? "Record inserted" : "Record Not Inserted");
		
		// Select All Item 
		
		List<Item> listItem = itemDao.getAllItem();
		System.out.println("listItem :" + listItem);
	}
}
