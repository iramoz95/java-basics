public class Break {
    public static void main(String[] args){
        int num;
        num = 100;

        //loop while i-squared is less than num
        for(int i=0; i < num; i++){
            if(i*i >= num) break;
                System.out.print(i + " ");//Terminate loop if i*i >= 100
        }
        System.out.println("Loop complete.");
    }
}
