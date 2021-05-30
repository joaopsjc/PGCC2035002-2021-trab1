package pivot;

import java.util.List;
import java.util.Random;

public class PivotRandomico implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) { 
		Random random = new Random();
		int fim = sortArray.size();
		int pivotIndex = random.nextInt()%fim;
		Integer pivot = sortArray.get(pivotIndex);
		return pivot;
	}
	public String getTipo()
	{
		return "Randomico";
	}
}
