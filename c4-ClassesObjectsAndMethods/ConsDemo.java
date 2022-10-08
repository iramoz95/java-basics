/*
A constructor initializes an object when its created.It has the same name as its class
and is syntactically similar to a method. Constructors have no explicit return type.
*/


class MyClass{
    int x;

    //Constructor of my class
    MyClass( int i){
        x = i;
    }
}

class ConsDemo {
    public static void main(String[] args){
        MyClass t1 = new MyClass(10);
        MyClass t2 = new MyClass(88);
        System.out.println(t1.x + " " + t2.x);
    }
}
