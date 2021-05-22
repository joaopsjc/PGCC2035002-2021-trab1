package pivot;

import java.util.List;

public class PivotRandomico implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) {
		// Pegamos o primeiro e último item da lista...  
		Integer inicio = sortArray.get(0), 
				fim = sortArray.get(sortArray.size()),
				pivot= (1)/(fim-inicio+1);

		//ou Pegamos o menor e o maior
		/*		
		Integer menor = sortArray.get(0),
				maior = sortArray.get(0),
				
		for (int i = 1; i < sortArray.size(); i++) {
			if (sortArray.get(i) < menor) {
				menor = sortArray.get(i);

			}else if (sortArray.get(i)> maior) {
				sortArray.get(sortArray.size());
			}{
				maior = sortArray.get(i);		
			}
		}
		Integer pivot= (1)/(maior-menor+1);
		*/
		return pivot;
	}
}
