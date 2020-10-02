package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
	public static void main(String[] args) {
		Predicate<String> predicate = new Predicate<String>() {
		    public boolean test(String s) {
		        return s.startsWith("A");
		    }
		};
		
		
	}

}
