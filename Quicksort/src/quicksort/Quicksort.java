package quicksort;

import java.util.ArrayList;
import java.util.List;

import pivot.Pivot;

public class Quicksort {
	private List<Integer> sortArray;
	private Pivot pivotFunction;

	

	public Quicksort(List<Integer> sortArray) {
		this.sortArray = sortArray;
		this.pivotFunction = null;
	}

	public List<Integer> sortList(Pivot pivotFunction)
	{
		this.pivotFunction = pivotFunction;
		return sortFunction(sortArray);
	}

	private List<Integer> sortFunction(List<Integer> currentArray)
	{
		List<Integer> result = currentArray;
		if(currentArray.size()>1)
		{
			Integer pivot = pivotFunction.findPivot(currentArray);
			
			List<Integer> leftArray = new ArrayList<>();
			List<Integer> rightArray = new ArrayList<>();
			
			for (int i = 0; i < currentArray.size(); i++) {
				
				if(currentArray.get(i)<=pivot)
				{
					leftArray.add(currentArray.get(i));
				}
				else 
				{
					rightArray.add(currentArray.get(i));
				}
				
			}
			
			List<Integer> resultLeftArray;
			List<Integer> resultRightArray;
			

			if(rightArray.size()==0)
			{
				leftArray.remove(pivot);
				rightArray.add(pivot);
			}
			resultLeftArray = sortFunction(leftArray);
			resultRightArray = sortFunction(rightArray);

			resultLeftArray.addAll(resultRightArray);
			result = resultLeftArray;
		}
		return result;
	}
	
}
