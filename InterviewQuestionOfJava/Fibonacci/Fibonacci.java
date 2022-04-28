package InterviewQuestionOfJava.Fibonacci;

public class Fibonacci{
	public Fibonacci() { }


    public void fibonacciSeries(int num){
            
        int a = 0, b = 0, c = 1;

        for(int i = 0; i < num; i++){
            a = b;
            b = c;
            c = a + b;
            System.out.println(a + " ");
        }
    }
}

