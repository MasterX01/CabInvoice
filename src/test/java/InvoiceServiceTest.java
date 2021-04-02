import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiveGenerator invoiveGenerator = new InvoiveGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiveGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        InvoiveGenerator invoiveGenerator = new InvoiveGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiveGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleValue_ShouldReturnTotalFare(){
        InvoiveGenerator invoiveGenerator = new InvoiveGenerator();
        Ride[] rides = {
                        new Ride(2.0, 5),
                        new Ride(0.1, 1)
                        };
        double fare = invoiveGenerator.calculateFare(rides);
        Assertions.assertEquals(30, fare, 0.0);
    }

    @Test
    public void givenMultipleValues_ShouldReturnEnhancedInvoice(){
        InvoiveGenerator invoiveGenerator = new InvoiveGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        EnhancedInvoice enhancedInvoice = invoiveGenerator.enhancedInvoice(rides);
        Assertions.assertEquals(2, enhancedInvoice.getNumOfRides());
        Assertions.assertEquals(15.0, enhancedInvoice.getAvgFare(), 0.0);
        Assertions.assertEquals(30, enhancedInvoice.getTotalFare(), 0.0);
    }

    @Test
    public void givenUserIDAndRides_ShouldReturnEnhancedInvoice(){
        InvoiveGenerator invoiveGenerator = new InvoiveGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        String userID = "MasterX";
        invoiveGenerator.addRides(userID, rides);
        EnhancedInvoice enhancedInvoice = invoiveGenerator.enhancedInvoiceForUserID(userID);
        Assertions.assertEquals(2, enhancedInvoice.getNumOfRides());
    }
}
