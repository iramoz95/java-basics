//This refers to the object on which getVal() was called
//Thus, this.val, this.b, etc refers to that object's copy of val.
class Pwr {
    double b;
    int e;
    double val;

    Pwr(double b, int e){
        this.b = b;
        this.e =  e;
        this.val = 1;
        if(e==0) return;
        for(; e >0; e--) this.val = this.val * b;
    }

    double getVal(){
        return this.val;
    }
}

public class DemoPwr {
    public static void main(String[] args){
        Pwr x = new Pwr(4.1,2);
        Pwr y = new Pwr(2.5, 1);
        Pwr z = new Pwr(5.7, 0);

        System.out.println(x.b + " raised to the " + x.e + " power is " + x.getVal());
        System.out.println(y.b + " raised to the " + y.e + " power is " + y.getVal());
        System.out.println(z.b + " raised to the " + z.e + " power is " + z.getVal());
    }
}
