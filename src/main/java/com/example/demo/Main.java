package com.example.demo;

interface InterfaceTest {
	// 抽象メソッド
	public String method(String name, int n);
}

public class Main {

	public static void main(String[] args) {

		// ラムダ式の場合
		InterfaceTest it = (name, n) -> {
			return "Hello " + name + n + "!";
		};
		System.out.println(it.method("Java", 8));
	}

}