package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sample {
	public static void main(String[] args) {
		System.out.println("test");

		final List<String> numTextList = Arrays.asList("0", "1", null);

		final List<Integer> numList = numTextList.stream().filter(Objects::nonNull).map(Integer::parseInt)
				.collect(Collectors.toList());

		String test = "";
		test = test.isEmpty() ? null : test.replace("-", "");
		System.out.println(test);

		List<String> stringList = new ArrayList<String>();
		stringList.add("japan");
		stringList.add("usa");
		stringList.add("england");

		System.out.println(stringList);

		List<String> filterList = stringList.stream().sorted().collect(Collectors.toList());

		System.out.println(filterList);
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee("john", 25, 2000.0, 9922001);
		Employee employee2 = new Employee("sohn", 25, 2000.0, 9922001);
		Employee employee3 = new Employee("aohn", 25, 2000.0, 9922001);
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee2);
		
		Employee test2[] = new Employee[] {employee,employee2,employee3, employee};

		Comparator<Employee> comparator = Comparator.comparing(Employee::getName);
	    Arrays.sort(test2, comparator);
	    List<Employee> idList = Arrays.asList(test2);
	    
	   idList.stream().distinct().filter(salary -> salary.getSalary() < 3000).forEach(string -> System.out.println(string.getName()));

		List<Item> list = Arrays.asList(new Item(9, "apple"), new Item(3, "lemon"), new Item(6, "peach"),
				new Item(6, "banana"));

		List<Item> sorted = list.stream().sorted(Comparator.comparing(Item::getId)).collect(Collectors.toList());
		
		String ids[] = new String[]{"a1", "a2", "a3"};
//		List<String> idList = Arrays.asList(ids);
		
		
		
		
	}
}
