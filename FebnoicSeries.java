public class FebnoicSeries {

    public static void main(String args[]) {
        for(int i=1; i<=15; i++){ 
            System.out.print(fibonacci2(i) +" "); 
            
        }
        System.out.println("");
        for(int i=1; i<=15; i++){ 
            System.out.print(fibonacciRursion(i) +" "); 
            
        }
    }
    public static int fibonacciRursion(int number){ 
        if(number == 1 || number == 2){
            return 1; 
            
        } return fibonacciRursion(number-1) + fibonacciRursion(number -2); 
        //tail recursion 
    }


   public static int fibonacci2(int number){ 
       if(number == 1 || number == 2){ 
           return 1; 
           
       } 
           int fibo1=1, 
           fibo2=1, 
           fibonacci=1; 
           for(int i= 3; i<= number; i++){ 
               //Fibonacci number is sum of previous two Fibonacci number 
               
               fibonacci = fibo1 + fibo2; 
               fibo1 = fibo2; 
               fibo2 = fibonacci; } 
               return fibonacci; 
                //Fibonacci number 
                } 





    
}


