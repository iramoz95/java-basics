//Demonstrate manual boxing  and unboxing with a type wrapper
class Wrap {
    public static void main(String[] args) {
        Integer iOb = new Integer.valueOf(100);
        int i = iOb.intValue();
        System.out.println(i + " " + iOb);
    }
}