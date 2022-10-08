public class BreakErr {
    public static void main(String[] args){
        one: for(int i=0; i<3; i++){
            System.out.println("Pass " + i + ": ");
        }
        for(int j=0; j<100; j++){
            /*WRONG: Since the label does not enclose the break statement,
             it is not possible to transfer control to that block*/
            //if(j == 10) break one;
            System.out.print(j + " ");
        }
    }
}
