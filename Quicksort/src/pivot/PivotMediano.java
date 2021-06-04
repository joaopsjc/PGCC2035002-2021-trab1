package pivot;

import java.util.List;

public class PivotMediano implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) {
		Integer k = sortArray.get(sortArray.size()/2);
		return kesimo(sortArray,k);
	}
	
	public Integer kesimo(List<Integer> sortArray, Integer k)
	{
		if( sortArray.size()>1)
		{
			Pivot achaPivot = new PivotAchaPivot();
			Integer pivoIntermediario = achaPivot.findPivot(sortArray);
			int pivoIntermediaroPos = sortArray.indexOf(pivoIntermediario);
			
			if(pivoIntermediaroPos >= sortArray.indexOf(k))
			{
				List<Integer> newArray;
				
				if(pivoIntermediaroPos==0)
				{
					newArray = sortArray.subList(0, 1);
				}
				else
				{
					newArray = sortArray.subList(0, pivoIntermediaroPos);
				}
				return kesimo(newArray,k);
			}
			else
			{
				List<Integer> newArray;
				
				if(pivoIntermediaroPos==sortArray.size()-1)
				{
					newArray = sortArray.subList(pivoIntermediaroPos, sortArray.size());
				}
				else
				{
					newArray = sortArray.subList(pivoIntermediaroPos+1,sortArray.size());
				}
				return kesimo(newArray,k);
			}
			
		}
		else
		{
			return sortArray.get(0);
		}
	}
	
	public String getTipo()
	{
		return "Mediano";
	}
}
