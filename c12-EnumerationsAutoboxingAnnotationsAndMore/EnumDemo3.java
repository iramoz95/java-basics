//Use an enum constructor, instance variable, and method.
enum Transport {
    CAR(65, 5), TRUCK(55, 2), AIRPLANE(600, 80), TRAIN(70, 1200), BOAT(22, 50);

    private int speed;
    private int passengers;

    // Constructor
    Transport(int s, int p) {
        speed = s;
        passengers = p;

    }

    int getSpeed() {
        return speed;
    }

    int getPassengers() {
        return passengers;
    }
}

class EnumDemo3 {
    public static void main(String[] args) {
        System.out.println(
                "Typical speed for an airplane is " + Transport.AIRPLANE.getSpeed() + " miles per hour.\nPassengers: "
                        + Transport.AIRPLANE.getPassengers());
        System.out.println("\nAll Transport speeds: ");
        for (Transport t : Transport.values())
            System.out.println(t + " typical speed is " + t.getSpeed() + " miles per hour.");
        System.out.println("\nAll Transport number of passengers: ");
        for (Transport t : Transport.values())
            System.out.println(t + " passengers: " + t.getPassengers());
    }
}