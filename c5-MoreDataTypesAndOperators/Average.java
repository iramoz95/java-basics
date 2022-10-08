class Average{
    public static void main(String[] args){
        double[] numbers = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,11.0};
        double sum;

        sum = 0;
        System.out.println("Original array numbers");
        for(double n : numbers){                
            sum += n;
            System.out.print(n + " ");
        }
        System.out.println();


        System.out.println("Sum: " + sum);
        System.out.println("Total: " + numbers.length);
        System.out.println("Average: " + sum/numbers.length);
    }
}
