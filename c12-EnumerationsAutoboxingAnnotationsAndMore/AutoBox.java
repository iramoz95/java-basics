// Demonstrate autoboxing/unboxing
class Autobox {
    public static void main(String[] args) {
        Integer iOb = 100;// auto-box an int
        int i = iOb; // auto-unbox
        System.out.println(i + " " + iOb);
    }
}
