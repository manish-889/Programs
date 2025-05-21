package com.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain1 {

	public static void main(String[] args) {
		
		//Create a list and Filter all even numbers from list
		List<Integer> list1 = List.of(2,44,89,76,4,45,3,11,12);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(11);
		list2.add(32);
		list2.add(64);
		list2.add(59);
		list2.add(25);
		
		//without stream
		List<Integer> listOfEven = new ArrayList<>();
		 for (Integer i : list1) {
			if(i % 2 == 0) {
				listOfEven.add(i);
			}
		}
		 
		 System.out.println(list1);
		 System.out.println(listOfEven);
		
		 System.out.println("Using Stream Api....");
		 
		 //using stream
		 List<Integer> streamList = list1.stream().filter(f -> f % 2 == 0).collect(Collectors.toList());
		 System.out.println(streamList);
		 
		 
	}
	
}
