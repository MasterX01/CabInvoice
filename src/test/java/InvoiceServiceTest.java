import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiveGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        String rideType = "normal";
        double fare = invoiveGenerator.calculateFare(distance, time, rideType);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        String rideType = "normal";
        double fare = invoiceGenerator.calculateFare(distance, time, rideType);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleValue_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {
                        new Ride(2.0, 5, "normal"),
                        new Ride(0.1, 1, "normal")
                        };
        double fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(30, fare, 0.0);
    }

    @Test
    public void givenMultipleValues_ShouldReturnEnhancedInvoice(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, "normal"),
                new Ride(0.1, 1, "normal")
        };
        EnhancedInvoice enhancedInvoice = invoiceGenerator.enhancedInvoice(rides);
        Assertions.assertEquals(2, enhancedInvoice.getNumOfRides());
        Assertions.assertEquals(15.0, enhancedInvoice.getAvgFare(), 0.0);
        Assertions.assertEquals(30, enhancedInvoice.getTotalFare(), 0.0);
    }

    @Test
    public void givenUserIDAndRides_ShouldReturnEnhancedInvoice(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, "normal"),
                new Ride(0.1, 1, "normal")
        };
        String userID = "MasterX";
        invoiceGenerator.addRides(userID, rides);
        EnhancedInvoice enhancedInvoice = invoiceGenerator.enhancedInvoiceForUserID(userID);
        Assertions.assertEquals(2, enhancedInvoice.getNumOfRides());
        Assertions.assertEquals(30, enhancedInvoice.getTotalFare());
    }

    @Test
    public void givenUserIDAndRides_whenPremiumUser_ShouldReturnEnhancedInvoice(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, "premium"),
                new Ride(0.1, 1, "premium")
        };
        String userID = "MasterX";
        invoiceGenerator.addRides(userID, rides);
        EnhancedInvoice enhancedInvoice = invoiceGenerator.enhancedInvoiceForUserID(userID);
        Assertions.assertEquals(2, enhancedInvoice.getNumOfRides());
        Assertions.assertEquals(60, enhancedInvoice.getTotalFare());
    }

}
