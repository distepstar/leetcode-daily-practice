package InterviewQuestionOfJava.ReverseString;

public class ReverseString{
	public ReverseString() { }

    // Normal iterative
    public void reverseString(String s){
        StringBuilder sb = new StringBuilder();
    
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
    
        System.out.println(sb.toString());
    }

    public void reverseString2(String s){
        int i = 0, j = s.length() - 1;
    
        char[] charArr = s.toCharArray();
    
        while(i <= j){
            char a = s.charAt(i);
            char b = s.charAt(j);

            System.out.println("A: " + a + " B: " + b);
            charArr[i++] = b;
            charArr[j--] = a;
        }

        String ch = new String(charArr);

        System.out.println(ch);
    }

    public void swap(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }
}
