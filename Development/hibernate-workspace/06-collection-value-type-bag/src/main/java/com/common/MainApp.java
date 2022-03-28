package com.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
		
//		Collection<String> images = new ArrayList<String>();
//		images.add("foo.jpg");
//		images.add("bar.jpg");
//		
//		Item item = new Item("BAR2", images);
//		
//		System.out.println(itemDao.insert(item) != -1 ? "Record inserted" : "Record Not Inserted");
		
		// Select All Item 
		
		Collection<Item> listItem = (Collection<Item>) itemDao.getAllItem();
		Iterator<Item> itemIter = listItem.iterator();
		while(itemIter.hasNext()) {
			Item item2 = itemIter.next();
			
			System.out.println("item : " + item2);
		}
	}
}
