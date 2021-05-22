package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pivot.Pivot;
import pivot.PivotFactory;
import quicksort.Quicksort;

public class Main {
	public static void main(String[] args) {
		// Adição de elementos na lista para teste 
		Random random = new Random();
	
		List<Integer> sortArray = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			sortArray.add(random.nextInt(10));
		}
		
		Pivot pivotAtual = PivotFactory.create("Mediano");
		Quicksort algoritmoSort = new Quicksort(sortArray);
		
		algoritmoSort.sortList(pivotAtual);
	}
}
