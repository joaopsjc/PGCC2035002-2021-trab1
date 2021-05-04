package main;

import java.util.ArrayList;
import java.util.List;

import pivot.Pivot;
import pivot.PivotFactory;
import quicksort.Quicksort;

public class Main {
	public static void main(String[] args) {
		
		List<Integer> sortArray = new ArrayList<>();
		
		Pivot pivotAtual = PivotFactory.create("Mediano");
		Quicksort algoritmoSort = new Quicksort(sortArray);
		
		algoritmoSort.sortList(pivotAtual);
	}
}
