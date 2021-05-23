package pivot;

import java.util.List;

public class PivotIndexado implements Pivot {

	@Override
	public Integer findPivot(List<Integer> sortArray) {
		Integer inicio = sortArray.get(0), 
				fim = sortArray.get(sortArray.size()),
				inteiro =  (inicio +fim)/2,
				pivot= (inicio + fim + inteiro)/3;

		return pivot;
	}
	
	public String getTipo()
	{
		return "Indexado";
	}
}
