package merge_two_sorted_arraylists;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrayLists {
	
	public static <T extends Comparable<? super T>> List<T> mergeTwoSortedArrayLists(List<T> list1, List<T> list2) {
		if(list1 == null || list1.size() == 0)
			return list2;
		else if(list2 == null || list2.size() == 0)
			return list1;
		
		List<T> result = new ArrayList<>();
		int i1 = 0, i2 = 0;
		while(i1 < list1.size() && i2 < list2.size()) {
			if(list1.get(i1).compareTo(list2.get(i2)) < 0) {
				result.add(list1.get(i1));
				i1++;
			} else {
				result.add(list2.get(i2));
				i2++;
			}
		}
		if(i1 >= list1.size())
			result.addAll(list2.subList(i2, list2.size()));
		else
			result.addAll(list1.subList(i1, list1.size()));
		
		return result;
	}
}
