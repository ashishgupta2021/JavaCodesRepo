package com.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		
		Map<String, String> images = new HashMap<String, String>();
		images.put("foo", "foo.jpg");
		images.put("bar", "bar.jpg");
		
		Item item = new Item("Foo", images);
		
		System.out.println(itemDao.insert(item) != -1 ? "Record inserted" : "Record Not Inserted");
		
		// Select All Item 
		
		List<Item> listItem =  itemDao.getAllItem();
		System.out.println("listItem : " + listItem);
	}
}
