package pivot;

import java.util.List;

public class PivotMediano implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) {
		int n1=0, n2 = sortArray.size();
		int	k = (n1+n2)/2;
		return kesimo(n1,n2, k, sortArray);
	}
	public Integer kesimo(int n1, int n2, int k, List<Integer> sortArray)
	{
		if( n1 < n2)
		{
			Pivot achaPivot = new PivotAchaPivot();
			Integer pivoIntermediario = achaPivot.findPivot(sortArray);
			int pivoIntermediaroPos = sortArray.indexOf(pivoIntermediario);
			
			if(pivoIntermediaroPos >= k)
			{
				return kesimo(n1,pivoIntermediaroPos,k,sortArray);
			}
			else
			{
				return kesimo(pivoIntermediaroPos+1,n2,k,sortArray);
			}
			
		}
		else
		{
			return sortArray.get(n1);
		}
	}
	public String getTipo()
	{
		return "Mediano";
	}
	public void kesimo()
	{
		
	}
}
