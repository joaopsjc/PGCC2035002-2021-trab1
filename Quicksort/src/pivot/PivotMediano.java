package pivot;

import java.util.List;

public class PivotMediano implements Pivot{

	@Override
	public Integer findPivot(List<Integer> sortArray) {

		int index1 = 0,
			index2 = sortArray.size()-1;
		int	index3 = (index1+index2/2);
		Integer value1 = sortArray.get(index1),
				value2 = sortArray.get(index2),
				value3 = sortArray.get(index3);
		Integer pivot = (value1 + value2 + value3)/3;
		return pivot;
	}
}
