public class ForEmpty {
    public static void main(String[] args){
        int i;

        for(i = 0; i < 10;){
            System.out.println("Pass #" + i);
            i++; //Increment loop control var
        }
        System.out.println();
        i = 0;
        for(; i < 10;){
            System.out.println("Pass #" + i);
            i++; //Increment loop control var
        }
    }


}
