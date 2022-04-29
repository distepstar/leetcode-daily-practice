package MedianTwoSortedArray;

import java.util.*;


public class MedianTwoSortedArray{
	public MedianTwoSortedArray() {
	}


    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        if(n + m == 0){
            return 0;
        }

        if(n == 0){
            return nums2[(m - 1) / 2] * 0.5 + nums2[m / 2] * 0.5;
        }
        
        if(m == 0){
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }

        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = n;


        while(l < r){
            int i = (l + r) / 2;
            int j = (n + m) / 2 - i;

            if(nums1[i] < nums2[j - 1]){
                l = i + 1;
            }else{
                r = i;
            }
        }
        
        int first = l;
        int second = (n + m) / 2 - l;

        int shortLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shortRight = first == n ? Integer.MAX_VALUE : nums1[first];
        int longLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longRight = second == m ? Integer.MAX_VALUE : nums2[second];

        // Odd
        if((n + m) % 2 == 1){
            return Math.min(shortRight, longRight);
        }else{
            return Math.max(shortLeft, longLeft) * 0.5 + Math.min(shortRight, longRight) * 0.5;
        }
    }

    // Shorter solution O(log(m + n))
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianSortedArrays2(nums2, nums1);
        }
        
        int lo = 0;
        int hi = nums1.length;
        int combinedLength = nums1.length + nums2.length;

        while(lo <= hi){
            int partX = (lo + hi) / 2;
            int partY = (combinedLength + 1) / 2 - partX;
            
            int leftX = getMax(nums1, partX); // { leftX: [1, ->2], | rightX [3<-, 4] }
            int rightX = getMin(nums1, partX);
            
            int leftY = getMax(nums2, partY);
            int rightY = getMin(nums2, partY);


            // Correct partition
            if(leftX <= rightY && leftY <= rightX){
                if(combinedLength % 2 == 0){
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                }
                return Math.max(leftX, leftY);
            }
            
            if(leftX > rightY){
                hi = partX - 1;
            }else{
                lo = partX + 1;
            }
        }

        return -1;
    }

    // Two Array Approach
    public double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int i = 0, j = 0, k = 0;

        float[] nums = new float[nums1.length + nums2.length];

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                i++;
            }else{
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < nums1.length){
            nums[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j < nums2.length){
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if(nums.length % 2 == 1){
            return nums[nums.length / 2];
        }else{
            return (nums[(nums.length / 2) - 1] + nums[nums.length / 2]) / 2;
        }
    } 

    private int getMax(int nums[], int partition){
        if(partition == 0){
            return (int) Double.NEGATIVE_INFINITY;
        }else{
            return nums[partition - 1];
        }
    }

    private int getMin(int nums[], int partition){
        if(partition == nums.length){
            return (int) Double.POSITIVE_INFINITY;
        }else{
            return nums[partition];
        }
    }

}   

