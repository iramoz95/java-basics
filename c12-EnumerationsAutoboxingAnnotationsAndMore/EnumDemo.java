//An enumeration of Transport varieties
enum Transport {
    CAR, TRUCK, AIRPLANE, TRAIN, BOAT
}

class EnumDemo {
    public static void main(String[] args) {
        Transport tp; // Declare transport reference
        tp = Transport.AIRPLANE; // Assign tp the constant AIRPLANE
        System.out.println("Value of tp: " + tp);
        System.out.println();

        tp = Transport.TRAIN;

        if (tp == Transport.TRAIN)
            System.out.println("tp contains TRAIN\n");

        switch (tp) {
            case CAR:
                System.out.println("A car carries people");
                break;
            case TRUCK:
                System.out.println("A truck carries freight.");
                break;
            case AIRPLANE:
                System.out.println("An airplane flies.");
                break;
            case TRAIN:
                System.out.println("A train runs on rails.");
                break;
            case BOAT:
                System.out.println("A boat sails on water.");
                break;
        }
    }
}