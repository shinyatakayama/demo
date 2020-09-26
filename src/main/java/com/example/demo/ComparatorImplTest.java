package com.example.demo;

import java.util.Comparator;

public class ComparatorImplTest {
	public static void main(String[] args) {
		Comparator<Integer> c = (s1, s2) -> s1.compareTo(s2);
		System.out.println(c.compare(4, 4));
		
		Comparator<String> d = (s1, s2) -> s1.compareTo(s2);
        System.out.println(d.compare("ABC", "DEF"));
	}
}
