package pivot;

import java.util.List;

public class PivotAchaPivot implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) {
		
		Integer pivot=sortArray.get(0);
		
		for (int pos=1; pos < sortArray.size();) {

			if(sortArray.get(pos) >= sortArray.get(pos-1))
			{
				pos++;
			}
			else
			{
				pivot = pos;
			}
		}
		
		
		return pivot;
	}

	public String getTipo()
	{
		return "AchaPivot";
	}

}
