package com.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dao.ItemDaoImpl;
import com.model.Filename;
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
		
		Map<Filename, Image> images = new HashMap<Filename, Image>();
		Filename fileName1 = new Filename("foo", ".jpg");
		Filename fileName2 = new Filename("bar", ".jpg");
		images.put(fileName1 ,new Image("Foo", 40, 20));
		images.put(fileName2 ,new Image("Boo", 70, 30));
		
		Item item = new Item("BAR2", images);
		
		System.out.println(itemDao.insert(item) != -1 ? "Record inserted" : "Record Not Inserted");
		
		// Select All Item 
		
		List<Item> listItem = itemDao.getAllItem();
		System.out.println("listItem :" + listItem);
	}
}
