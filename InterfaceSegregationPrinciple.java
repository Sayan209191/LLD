// interface Uber{
//     void bookRide();
//     void acceptRide();
//     void cancelRide();
//     void drive();
//     void rateDriver();
//     void ratePassenger();
// }
interface RiderInterface {
    void bookRide();
    void payRide();
    void cancelRide();
}
interface DriverInterface {
    void acceptRide();
    void drive();
    void endRide();
}
class Rider implements RiderInterface {
    @Override
    public void bookRide() {
        System.out.println("Ride booked by rider.");
    }

    @Override
    public void payRide() {
        System.out.println("Ride paid by rider.");
    }

    @Override
    public void cancelRide() {
        System.out.println("Ride cancelled by rider.");
    }
}

class Driver implements DriverInterface {
    @Override
    public void acceptRide() {
        System.out.println("Ride accepted by driver.");
    }

    @Override
    public void drive() {
        System.out.println("Driver is driving.");
    }

    @Override
    public void endRide() {
        System.out.println("Ride ended by driver.");
    }
}
public class InterfaceSegregationPrinciple {
    
    public static void main(String[] args) {
        Rider rider = new Rider();
        rider.bookRide();
        rider.payRide();
        rider.cancelRide();

        Driver driver = new Driver();
        driver.acceptRide();
        driver.drive();
        driver.endRide();

        // The code above adheres to the Interface Segregation Principle
        // because Rider and Driver interfaces are segregated, allowing
        // each class to implement only the methods relevant to them.
    }
}
