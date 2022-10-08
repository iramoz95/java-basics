public class LoopsWithNoBody {
    public static void main(String[] args){
        int i;
        int sum=0;
        //sum the numbers through 100
        for(i = 1; i <= 100; sum += i++);
        System.out.println("Sum is " +sum);
    }
}
