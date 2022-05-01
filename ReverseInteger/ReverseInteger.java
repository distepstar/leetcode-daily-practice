package ReverseInteger;

import java.util.*;


public class ReverseInteger{

	public ReverseInteger() {
	}
	

	// Maths solution
	public int reverse(int x){
		if(x >= -9 && x <= 9){
			return x;
		}

		if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE){
			return 0;
		}

		int sign = x < 0 ? -1 : 1;
		x = Math.abs(x);
		int res = 0;
	
		while(x > 0){
			int digit = x % 10;
			if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
				return 0;
			}

			res = res * 10 + digit;
			x /= 10;
		}
		

		return sign * res;
	}

	
	// StringBuilder solution
	
	public int reverse2(int x){
		StringBuilder sb = new StringBuilder();

		String res = "";
		int val = 0;
		
		int sign = x > 0 ? 1 : -1;

		x = Math.abs(x);

		res = sb.append(x).reverse().toString();
		try{
			val = (int) Integer.parseInt(res);
		}catch(NumberFormatException e){
			return 0;
		}

		return val * sign;
	}
}
