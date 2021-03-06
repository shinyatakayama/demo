package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		System.out.println("test");
		
		List<SampleEntity> sampleEntityList = new ArrayList<SampleEntity>();
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setName("test");
		sampleEntity.setAge("20");
		sampleEntityList.add(sampleEntity);
		
		SampleEntity sampleEntity2 = new SampleEntity();
		sampleEntity2.setName("test2");
		sampleEntity2.setAge("21");
		sampleEntityList.add(sampleEntity2);
		
//		for(SampleEntity eintity: sampleEntityList) {
//			System.out.println(eintity.getName());
//			
//		}
		
		sampleEntityList.stream().map(e -> e.getName()).forEach(System.out::println);
		
		Runnable runnable1 = () -> System.out.println("ABC");
		runnable1.run();
		
		Predicate<String> predicate3 = s -> "ABC".equals(s);
		System.out.println(predicate3.test("ABC"));
		
		Function<String, Integer> function3 = s -> {
		    if ("ABC".equals(s)) {
		        return 1;
		    } else {
		        return 0;
		    }
		};
		System.out.println(function3.apply("ABC"));
	}
};
