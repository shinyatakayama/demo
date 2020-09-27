package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Item> list = Arrays.asList(new Item(9, "apple"), new Item(3, "lemon"), new Item(6, "peach"),
				new Item(6, "banana"));

		list.stream().sorted(Comparator.comparing(Item::getId)).map(id -> id.getName()).forEach(i -> System.out.println(i));
	}
	
	

}
