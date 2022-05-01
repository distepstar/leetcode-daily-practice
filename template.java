import java.util.*;

// Datatypes
import Datatypes.*;

// Interview Question
import InterviewQuestionOfJava.ReverseString.*;
import InterviewQuestionOfJava.Fibonacci.*;

// Questions java file
import twosum.*;
import AddTwoNumbers.*;
import LongestSubstring.*;
import MedianTwoSortedArray.*;
import LongestPalindromicSubstring.*;
import ZigZag.*;

class template{

	// Two Sum
    public static void CompileTwoSum(){
        TwoSum twoSum = new TwoSum();
        int nums[] = {2, 11, 15, 4, 8, 9, 10, 2, 4, 7};
        int target = 9;
		//int[] arr1 = twoSum.twoSum1(nums, target);
		//int[] arr2 = twoSum.twoSum2(nums, target);
		int[] arr3 = twoSum.twoSum3(nums, target);
		System.out.println(Arrays.toString(arr3));
    }

    // AddTwoNumbers
    public static void CompileAddTwoNumbers(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode ans = addTwoNumbers.addTwoNumbers2(l1, l2);
        ans.printAll();
    }

    // LongestSubstring
    public static void LongestSubstring(){
        LongestSubstring ls = new LongestSubstring();
        String s = "abcabcbb";
        ls.lengthOfLongestSubstring(s);
    }

    // MedianTwoSortedArray
    public static void MedianTwoSortedArray(){
        MedianTwoSortedArray mtsa = new MedianTwoSortedArray();
        // 1, 2, 3, 4, 5, 6
        int nums1[] = {1, 3, 5};
        int nums2[] = {2, 4, 6};
        double d = mtsa.findMedianSortedArrays3(nums1, nums2);
        System.out.println(d);
        
    }
    // LongestPalindromicSubstring
    public static void LongestPalindromicSubstring(){
        String s = "aaaabbaa";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        String ans = lps.longestPalindrome4(s);
        System.out.println(ans);
    }

    public static void ZigZag(){
        String s = "PAYPALISHIRING";
        ZigZagConversation zzc = new ZigZagConversation();

        System.out.println(zzc.convert2(s, 3));
    }

    // Reverse String
    public static void ReverseString(){
        String s = "How are you";
        ReverseString rs = new ReverseString();
        rs.reverseString2(s);
    }

    // Fibonacci 
    public static void Fibonacci(){
        int num = 9;
        Fibonacci fb = new Fibonacci();
        fb.fibonacciSeries3(num);
    }

	public static void main(String[] args){
        /* leetcode */
        //CompileTwoSum();
        //CompileAddTwoNumbers();
        //LongestSubstring();
        //MedianTwoSortedArray();
        //LongestPalindromicSubstring();
        ZigZag();
        /* leetcode */


        /* Interview Question */
        //ReverseString();
        //Fibonacci();
        /* Interview Question */
	}
}
