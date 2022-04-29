package LongestSubstring;

import java.util.*;

public class LongestSubstring{
	public LongestSubstring() { }


    // String function
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }

        char ch = s.charAt(0);
        
        String ans = "";
        ans += ch;

        int max = 1;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            int index = ans.indexOf(ch);

            if(index == -1){
                ans += ch;
                max = Math.max(ans.length(), max);
            }else{
                ans = ans.substring(index + 1) + ch;
            }
        }

        return max;
    }

    // Sliding Window
    public int lengthOfLongestSubstring2(String s){
        int i = 0, j = 0;
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();

        while(j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            j++;
            max = Math.max(set.size(), max);
        }

        System.out.println(max);
        return max;
    }
    
    // Acquire and release (Window sliding)
    public int lengthOfLongestSubstring3(String s){
        int acquire = 0;
        int release = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        while(acquire < s.length()){
            if(!set.contains(s.charAt(acquire))){
                set.add(s.charAt(acquire));
                acquire++;
                Math.max(set.size(), max);
            }else{
                set.remove(s.charAt(release));
                release++;
            }
        }

        return max;
    }
}
