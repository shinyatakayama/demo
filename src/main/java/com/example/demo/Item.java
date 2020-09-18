package com.example.demo;

public class Item {
	 private Integer id;
	    private String name;

	    public Item(Integer id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public Integer getId() { return id; }
	    public String getName() { return name; }

	    @Override
	    public String toString() { return "Item{" + id + ", '" + name + "'}"; }

}
