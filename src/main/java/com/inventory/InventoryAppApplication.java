package com.inventory;

import java.io.File;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class InventoryAppApplication {

	
	  public static void main(String[] args) {
	  SpringApplication.run(InventoryAppApplication.class, args); }
	 
	
	/*
	 * public static void main(String[] args) { System.out.println(new
	 * File(".").getAbsolutePath()); }
	 */

}