/*Automatic type conversions can affect
 overload  method resolution*/
class Overload2 {
    void f(int x) {
        System.out.println("Inside f(int): " + x);
    }

    void f(double x) {
        System.out.println("Inside f(double): " + x);
    }
}

class TypeConv {
    public static void main(String[] args) {
        Overload2 ob = new Overload2();
        int i = 10;
        double d = 10.1;
        byte b = 99;
        short s = 10;
        float f = 11.5F;

        ob.f(i);// calls ob.f(int)
        ob.f(d);// calls ob.g(double)
        ob.f(b);// calls ob.g(int) - type conversion
        ob.f(s);// calls ob.g(int) - type conversion
        ob.f(f);// calls ob.g(double) - type conversion
    }
}