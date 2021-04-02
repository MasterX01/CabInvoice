public class EnhancedInvoice {
    private double totalFare;
    private double avgFare;
    private int numOfRides;

    public EnhancedInvoice(int numOfRides, double totalFare){
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = totalFare/numOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAvgFare() {
        return avgFare;
    }

    public int getNumOfRides() {
        return numOfRides;
    }
}
