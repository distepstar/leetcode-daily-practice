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
    
    // Recursion approach
    public int fibonacciSeries2(int num){
        if(num <= 1){
            return num;
        }

        int ans = fibonacciSeries2(num - 1) + fibonacciSeries2(num - 2);
        System.out.println(ans);
        return ans;
    }

    // DP approach
    public int fibonacciSeries3(int num){
        int f[] = new int[num + 2];
        int i;
        
        f[0] = 0;
        f[1] = 1;
    
        for(i = 2;i <= num; i++){
            f[i] = f[i - 1] + f[i - 2];
        }

        for(int j = 0; j < f.length; j++){
            System.out.println(f[j]);
        }
    
        return f[num];
    }
}

