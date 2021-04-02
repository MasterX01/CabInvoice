public class InvoiceGenerator {

    private double MIN_COST_PER_KILOMETER;
    private int COST_PER_TIME;
    private double MIN_FARE;


    public double calculateFare(double distance, int time, String rideType) {
        if(rideType.equalsIgnoreCase("normal")){
            MIN_COST_PER_KILOMETER = 10;
            COST_PER_TIME = 1;
            MIN_FARE = 5;
        }
        if(rideType.equalsIgnoreCase("premium")){
            MIN_COST_PER_KILOMETER = 15;
            COST_PER_TIME = 2;
            MIN_FARE = 20;
        }
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
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return totalFare;
    }

    public EnhancedInvoice enhancedInvoice(Ride[] rides) {
        return new EnhancedInvoice(rides.length, calculateFare(rides));
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
