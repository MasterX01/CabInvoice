import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
}
