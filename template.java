import java.util.*;
import twosum.*;

class template{
		
	// Two Sum
	static TwoSum twoSum = new TwoSum();
	static int nums[] = {2, 11, 15, 4, 8, 9, 10, 2, 4, 7};
	static int target = 9;

	public static void main(String[] args){
		int[] arr = twoSum.twoSum2(nums, target);
		System.out.println(Arrays.toString(arr));
	}
}