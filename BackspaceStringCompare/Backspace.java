package BackspaceStringCompare;

import java.util.*;

public class Backspace{

	public Backspace() {
	}

	// Char Array method
	public boolean backspaceCompare(String s, String t){
		return convert(s).equals(convert(t));
	}

	public String convert(String s){
		if(s.isEmpty())	return null;

		char ch = s.charAt(0);
		String ans = "";

		if(ch != '#'){
			ans += ch;
		}

		for(int i = 1; i < s.length(); i++){
			ch = s.charAt(i);

			if(ch != '#'){
				ans += ch;
			}
			if(ch == '#' && ans.length() != 0){
				ans = ans.substring(0, ans.length() - 1);
			}
		}

		return ans;
	}

	// Two pointer
	public boolean backspaceCompare2(String s, String t){
		int i = s.length() - 1;
		int j = t.length() - 1;

		// backward iteration
		while(i >= 0 || j >= 0){
			int i1 = getNextValidIndex(s, i);
			int j1 = getNextValidIndex(t, j);
			
			if(i1 < 0 && j1 < 0){
				// reach the end of both string
				return true;
			}

			if(i1 < 0 || j1 < 0){
				// reach the end of one of the string
				return false;
			}

			if(s.charAt(i1) != t.charAt(j1)){
				// one of the character is not relavent, false
				return false;
			}

			i = i1 - 1;
			j = j1 - 1;
		}

		return true;
	}

	
	private static int getNextValidIndex(String str, int index){
		int backSpaceCount = 0;

		while(index >= 0){
			if(str.charAt(index) == '#'){
				backSpaceCount++;
			}else if(backSpaceCount > 0){
				backSpaceCount --;
			}else break;

			index --;
		}

		return index;
	}
}
