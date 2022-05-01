package ZigZag;

import java.util.*;


public class ZigZagConversation{
	public ZigZagConversation() {
	}
    

    // ArrayList solution
    public String convert(String s, int numRows){
        if(numRows == 1) return s;
        int curRow = 0;
        boolean isDown = false;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());

        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1){
                isDown = !isDown;
            }
            curRow += isDown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();


        for(StringBuilder temp : rows){
            sb.append(temp);
        }
        return sb.toString();
    }

    // Maths solution
    public String convert2(String s, int numRows){
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= numRows; i++){
            int pos = i - 1;
            boolean up = true;
            while(pos < s.length()){
                sb.append(s.charAt(pos));
                if(i == 1){
                    pos += 2 * (numRows - 1);
                }else if(i == numRows){
                    pos += 2 * (i - 1);
                }else{
                    pos += up ? 2 * (numRows - 1) : 2 * (i - 1);
                    up = !up;
                }
            }
        }

        return sb.toString();
    }
    
}
