package seriespack;

class SeriesDemo {
    public static void main(String[] args) {
        ByTwos ob = new ByTwos();
        ByThrees obt = new ByThrees();

        for (int i = 0; i < 5; i++)
            System.out.println("Prevoius : " + ob.getPrevious() + "\tCurrent: " + 2 * i + "\tNext: " + ob.getNext());

        System.out.println("\nReseting");
        ob.reset();
        for (int i = 0; i < 5; i++)
            System.out.println("Prevoius : " + ob.getPrevious() + "\tCurrent: " + 2 * i + "\tNext: " + ob.getNext());

        System.out.println("\nStarting at 100");
        ob.setStart(100);
        for (int i = 0; i < 5; i++)
            System.out.println(
                    "Prevoius : " + ob.getPrevious() + "\tCurrent: " + (2 * i + 100) + "\tNext: " + ob.getNext());

        System.out.println("\nBy Threes from 0 to 30");
        for (int i = 0; i <= 10; i++)
            System.out.println("Current: " + 3 * i + "\tNext: " + obt.getNext());
    }
}