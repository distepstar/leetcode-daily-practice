package PalindromeNumber;


import java.util.*;


public class PalindromeNumber{
	boolean memo[][];
	public PalindromeNumber() {
	}
	

	// Head Tail Screening
	public boolean isPalindrome(int x) {
		char[] chArr = ("" + x).toCharArray();

		// False due to negative number
		if(chArr[0] == '-'){
			return false;
		}

		int i = 0, j = chArr.length - 1;

		while(i <= j){
			if(chArr[i] == chArr[j]){
				i++;
				j--;
			}else{
				return false;
			}
		}


		return true;
    }

	
	// Reverse solution
	public boolean isPalindrome2(int x) {
		char[] chArr = ("" + x).toCharArray();
		char[] cloneArr = Arrays.copyOf(chArr, chArr.length);


		if(chArr[0] == '-'){
			return false;
		}

		// reverse chArr
		reverse(chArr);
		
		if(String.valueOf(chArr).equals(String.valueOf(cloneArr))) return true;

		System.out.println(new String(chArr));
		System.out.println(new String(cloneArr));


		return false;
    }


	public void reverse(char[] arr){
		int i = 0, j = arr.length - 1;

		while(i <= j){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	// Mod solution
	public boolean isPalindrome3(int x) {
		if(x < 0 || (x != 0 && x % 10 == 0)) return false;
		int rev = 0;

		while(x > rev){
			rev = rev*10 + x%10;
			x = x/10;
		}
		return (x == rev || x == rev/10);
    }
}

