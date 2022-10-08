// A program that uses the Vehicle class
class Vehicle {
    int passengers;
    int fuelcap;
    int mpg;

    //This is a constructor for Vehicle
    Vehicle(int p, int f, int m){
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    int range(){
        return mpg * fuelcap;
    }

    double fuelNeeded(int miles){
        return (double) miles / mpg;
    }
}

class VehicleDemo{
    public static void main(String[] args){
       // Construct complete vehicles
        Vehicle minivan = new Vehicle(7,16,21);
        Vehicle sportscar = new Vehicle(2,14,12);
        double gallons;
        int dist = 252;

        gallons = minivan.fuelNeeded(dist);
        System.out.println("To go " + dist + " miles minivan needs " +
                gallons + " gallons of fuel");

        gallons = sportscar.fuelNeeded(dist);
        System.out.println("To go " + dist + " miles sports car needs " +
                gallons + " gallons of fuel");
    }
}
