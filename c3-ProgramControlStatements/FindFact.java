/*Use nested loops to find factors of numbers
 between 2 and 100*/
public class FindFact {
    public static void main(String[] args){
        int i, j, iterations;
        iterations = 0;
        for(i=2; i<=100; i++){
            System.out.print("Factors of " + i + ": ");
            for(j=2; j<=(i/2); j++)
            //for(j=2; j<i; j++)
                if((i%j) == 0) System.out.print( j + " ");
            iterations += (j-1);
            System.out.println();
        }
        System.out.println("Total iterations: " +  iterations);
    }

}
