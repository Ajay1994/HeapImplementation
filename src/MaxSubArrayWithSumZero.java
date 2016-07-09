import java.util.*;

public class MaxSubArrayWithSumZero {

	public static int maxLen(int array[]){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int max_length = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			if(array[i] == 0 && max_length == 0) max_length = 1;
			if(sum == 0) max_length = Math.max(max_length, i);
			Integer index = map.get(sum);
			if(index != null) max_length = Math.max(max_length, i - index);
			else map.put(sum, i);
		}
		return max_length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                           + maxLen(arr));
	}

}
