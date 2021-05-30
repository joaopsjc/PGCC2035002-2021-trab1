package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pivot.Pivot;
import pivot.PivotFactory;
import quicksort.Quicksort;

public class Panel {
	 private void ClearConsole(){
	        try{
	            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
	              
	            if(operatingSystem.contains("Windows")){        
	                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
	                Process startProcess = pb.inheritIO().start();
	                startProcess.waitFor();
	            } else {
	                ProcessBuilder pb = new ProcessBuilder("clear");
	                Process startProcess = pb.inheritIO().start();

	                startProcess.waitFor();
	            } 
	        }catch(Exception e){
	            System.out.println(e);
	        }
 }
	public void inicia()
	{
		Pivot pivotAtual;
		String input = null;
		ClearConsole();
		while(input==null || !input.equals("q"))
		{	
			System.out.println(
					"Escolha qual função pivot utilizar: \n" +
					"1:Mediano. \n" +
					"2:AchaPivot. \n" +
					"3:Randômico. \n" +
					"4:Indexado. \n" +
					"ou 'q' para sair.");
			
	        try {
		        BufferedReader reader = new BufferedReader(
			            new InputStreamReader(System.in));
				input = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ClearConsole();
			switch(input)
			{
				case "1":
					pivotAtual = PivotFactory.create("Mediano");
					ordena(pivotAtual);
					break;
				case "2":
					pivotAtual = PivotFactory.create("AchaPivot");
					ordena(pivotAtual);
					break;
				case "3":
					pivotAtual = PivotFactory.create("Randomico");
					ordena(pivotAtual);
					break;
				case "4":
					pivotAtual = PivotFactory.create("Indexado");
					ordena(pivotAtual);
					break;
				case "q":
					break;
				default:
					System.out.println("O valor digitado não é aceito");
					
			}

		}
	}
	private void imprime(List<Integer> sortArray)
	{
		for (Integer integer : sortArray) {
			System.out.print(integer + ", ");
		}
		System.out.println("");
	}
	private void troca(int indexN1,int indexN2, List<Integer> sortArray) {
		
		Integer aux = sortArray.get(indexN1);
		sortArray.add(indexN1, sortArray.get(indexN2));
		sortArray.remove(indexN1+1);
		sortArray.add(indexN2, aux);
		sortArray.remove(indexN2+1);
		
	}
	private List<Integer> desordena(List<Integer> sortArray, int grauDesordem)
	{
		grauDesordem = grauDesordem *30;
		int quantidadeDeTrocas = sortArray.size() * grauDesordem;
		quantidadeDeTrocas = quantidadeDeTrocas/100;
		quantidadeDeTrocas = quantidadeDeTrocas/2;
		
		Random random = new Random();
		
		for (int i=0, j=sortArray.size()-1; i<j && i<=quantidadeDeTrocas;i++,j--) {
			
			int randIndex = random.nextInt(j-i);
			randIndex = randIndex + i;
			int randIndex2 = random.nextInt(j-i);
			randIndex2 = randIndex2 + i;
			
			troca(i,randIndex,sortArray);
			troca(j,randIndex2,sortArray);
		}
		return sortArray;
	}
	
	private void ordena(Pivot pivotAtual)
	{
		int tamanho=0;
		int grauDesOrdenacao=0;
        BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		
        try {
        	
			while(tamanho<1)
			{
				System.out.println("Qual o tamanho da cadeia a ser ordenada?");	
			    tamanho = Integer.parseInt(reader.readLine());
			    ClearConsole();
			}
			while(grauDesOrdenacao<1 || grauDesOrdenacao>3)
			{
				System.out.println(
						"Escolha o grau de desordenação: \n" +
						"1:Baixo. \n" +
						"2:Médio. \n" +
						"3:Alto. \n");
			    grauDesOrdenacao = Integer.parseInt(reader.readLine());
			    ClearConsole();
			}
			
			List<Integer> sortArray = new ArrayList<>();
			
			for (int i = 0; i < tamanho; i++) {
				sortArray.add(i);
			}
			desordena(sortArray, grauDesOrdenacao);
			System.out.print("array gerado:");
			imprime(sortArray);
			
			long start = System.nanoTime();
			
			Quicksort algoritmoSort = new Quicksort(sortArray);
			List<Integer> sortedArray = algoritmoSort.sortList(pivotAtual);
			long elapsedTime = System.nanoTime() - start;
			
			System.out.print("array ordenado:");
			imprime(sortedArray);
			System.out.println("Tempo de processamento:" + elapsedTime);

	        reader.read();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
