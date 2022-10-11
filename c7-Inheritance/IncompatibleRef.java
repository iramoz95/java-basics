//This will not compile
class X {
    int a;

    X(int i) {
        a = i;
    }
}

class Y {
    int a;

    Y(int i) {
        a = i;
    }
}

class IncompatibleRef {
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y y = new Y(5);
        x2 = x; // OK, both the same type
        x2 = y; // Error, not the same type. Cannot convert from Y yo X
    }
}
