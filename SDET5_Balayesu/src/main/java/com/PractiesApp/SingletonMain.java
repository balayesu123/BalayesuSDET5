package com.PractiesApp;

public class SingletonMain {

	public static void main(String[] args) {

		Singleton obje = Singleton.getobj();

		System.out.println(obje.age);
	}

}


