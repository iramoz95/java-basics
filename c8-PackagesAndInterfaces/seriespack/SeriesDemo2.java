package seriespack;

class SeriesDemo2 {
    public static void main(String[] args) {
        ByTwos twoOb = new ByTwos();
        ByThrees threeOb = new ByThrees();
        Series ob;

        for (int i = 0; i < 5; i++) {
            ob = twoOb;
            System.out.println("Next ByTwos value is " + ob.getNext());
            ob = threeOb;
            System.out.println("Next ByThrees value is " + ob.getNext());
        }
        // Using default interface method
        ob = threeOb;
        int[] result = ob.getNextArray(10);
        System.out.println("The next " + result.length + " values are:");
        for (int r : result)
            System.out.println("getNextArray(10) default interface method " + r);
    }
}