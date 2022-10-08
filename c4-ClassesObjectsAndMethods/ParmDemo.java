class ChkNum{
    boolean isEven(int x){
        return (x%2) == 0;
    }
}

class Factor{
    boolean isFactor(int a, int b){
        return (b%a) == 0;
    }
}

public class ParmDemo {
    public static void main(String[] args){
        ChkNum e = new ChkNum();
        Factor x = new Factor();

        if(e.isEven(10)) System.out.println("10 is even.");
        if(e.isEven(9)) System.out.println("9 es even.");
        if(e.isEven(8)) System.out.println("8 es even.");

        if(x.isFactor(2,20)) System.out.println("2 is factor of 20");
        if(x.isFactor(3,20)) System.out.println("This won't be displayed");
    }
}
