// Mario Granados
// lab 1 

//class 
public class InClass_Lab_1_Mario_Granados {
    //psvm stuff
    public static void main(String[] args){
        System.out.println("hello world");
        //wanted to see max stuff
        for(int i = 10; i <= 1000000; i = i * 10) {
            System.out.printf("Elapsed time %d when n = %d\n", Algorithm(i), i);
        }
        return;
    }
    //from algorithm provided
    public static long Algorithm(int n) {
        long startTime = 0;
        long endTime = 0;
        long elapsedTime = 0;

        startTime = System.nanoTime();

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = sum + i;

        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;


        return elapsedTime;
    }
}