import java.lang.reflect.Array;
import java.util.List;

public class InvoiveGenerator {
    private static final double MIN_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MIN_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double totalFare =  distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
        if(totalFare < MIN_FARE){
            return MIN_FARE;
        }else{
            return totalFare;
        }
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride: rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public EnhancedInvoice enhancedInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int numOfRides = rides.length;
        return new EnhancedInvoice(numOfRides, totalFare);
    }

    public void addRides(String userID, Ride[] rides) {
        RideRepository.addRide(userID, rides);
    }

    public EnhancedInvoice enhancedInvoiceForUserID(String userID) {
        RideRepository rideRepository = new RideRepository();
        Ride[] rides = new Ride[rideRepository.getRidesData(userID).size()];
        rideRepository.getRidesData(userID).toArray(rides);
        return new EnhancedInvoice(rides.length, calculateFare(rides));
    }
}
