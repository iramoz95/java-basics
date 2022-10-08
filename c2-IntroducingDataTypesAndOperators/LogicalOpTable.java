//A truth table for the logical operators
public class LogicalOpTable {
    public static void main(String[] args){
        boolean p, q;

        System.out.println("P\tQ\tAND\tOR XOR NOT");

        p = true; q = true;
        System.out.print(p + " " + q + " ");
        System.out.print(((p&q)?"1":"2") + " " + ((p|q)?"1":"0") + " ");
        System.out.println(((p ^ q)?"1":"0") + " " + ((!p)?"1":"0"));

        p = true; q = false;
        System.out.print(p + " " + q +" ");
        System.out.print(((p&q)?"1":"2") + " " + ((p|q)?"1":"0") + " ");
        System.out.println(((p ^ q)?"1":"0") + " " + ((!p)?"1":"0"));

        p = false; q = true;
        System.out.print(p + " " + q +" ");
        System.out.print(((p&q)?"1":"2") + " " + ((p|q)?"1":"0") + " ");
        System.out.println(((p ^ q)?"1":"0") + " " + ((!p)?"1":"0"));

        p = false; q = false;
        System.out.print(p + " " + q +" ");
        System.out.print(((p&q)?"1":"0") + " " + ((p|q)?"1":"0") + " ");
        System.out.println(((p ^ q)?"1":"0") + " " + ((!p)?"1":"0"));
    }
}
