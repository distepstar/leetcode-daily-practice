package twosum;

import java.util.*;

public class TwoSum{

	// HashMap approach
	public int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();

		int i = 0;

		while(i < nums.length){
			int gap = target - nums[i];
			System.out.println(gap);

			if(map.containsKey(gap)){
				int[] res = {map.get(gap), i};
				return res;
			}
				
			map.put(nums[i], i);
			i++;
		}

		return null;
	}

	// Binary Search solution
	public int[] twoSum2(int[] nums, int target){
		if(nums == null){
			return null;
		}

		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);
		int i = 0, len = nums2.length;
		int selectNum = 0;
		int foundNum = -1;

		// binarySearch the number
		while(i < len){
			selectNum = nums2[i];
			int diff = target - nums2[i];
			int found = binarySearch(nums2, diff);
			if(found != -1){
				// found, break out the loop
				foundNum = diff;
				break;
			}
			i++;
		}

		if(binarySearch(nums2, foundNum) != -1){
			int[] res = new int[2];

			for(int j = 0; j < nums.length; j++){
				if(nums[j] == selectNum){
					res[0] = j;
					break;
				}
			}

			for(int j = nums.length - 1; j >= 0; j--){
				if(nums[j] == foundNum){
					res[1] = j;
					break;
				}
			}


			//if(selectNum != foundNum){
			//	for(int j = 0; j < nums.length; j++){
			//		if(nums[j] == foundNum){
			//			res[1] = j;
			//			break;
			//		}
			//	}
			//}else{
			//	for(int j = 0; j < nums.length; j++){
			//		if(nums[j] == foundNum && j != res[0]){
			//			res[1] = j;
			//			break;
			//		}
			//	}
			//}


			return res;
		}

		

		return null;
	}

	public int binarySearch(int[] nums, int target){
		int l = 0, h = nums.length - 1;


		while(l <= h){
			int mid = l + (h - l) / 2;

			if(nums[mid] == target){
				return mid;
			}
			
			// nums[mid] smaller than target, ignore left part
			if(nums[mid] < target){
				l = mid + 1;
			}

			// nums[mid] larger than target, ignore right part
			else{
				h = mid - 1;
			}
		}

		// Not found, return -1
		return -1;
	}
}
