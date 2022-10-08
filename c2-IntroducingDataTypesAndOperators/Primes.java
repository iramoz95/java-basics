//Write a program that finds all the prime numbers between 2 and 100.
public class Primes {
    public static void main(String[] args){
        int i, j;

        j = 1;
        for(i = 2; i <= 100; i++){
            int k;
            boolean isPrime = true;
            for(k = i - 1; k >= 2; k--)
                if(i % k == 0)
                    isPrime = false;
            if(isPrime){
                System.out.println(j + "- " + i);
                j++;
            }
        }
    }
}
