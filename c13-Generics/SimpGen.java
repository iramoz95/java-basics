//A simple generic class with two type
//parameters: T and V
class TwoGen<T, V> {
    T ob1;
    V ob2;

    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    void showTypes() {
        System.out.println("Types of T is " + ob1.getClass().getName());
        System.out.println("Types of V is " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(88, "Generics");
        tgObj.showTypes();
        int v = tgObj.getOb1();
        System.out.println("value: " + v);
        String str = tgObj.getOb2();
        System.out.println("value: " + str);

        System.out.println();
        TwoGen<String, Double> tgObj2 = new TwoGen<String, Double>("Double as a String", 12.51);
        tgObj2.showTypes();
        str = tgObj2.getOb1();
        System.out.println("value: " + str);
        Double d = tgObj2.getOb2();
        System.out.println("value: " + d);

    }
}