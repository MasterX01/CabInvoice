import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RideRepository {
    public static HashMap<String, List<Ride>> ridesData = new HashMap<String, List<Ride>>();

    public static void addRide(String userId, Ride[] rides){
       try {
           for (Ride ride : rides) {
               ridesData.get(userId).add(ride);
           }
       }catch (Exception e){
           ridesData.put(userId, Arrays.asList(rides));
           }
    }

    public List<Ride> getRidesData(String userID){
        return ridesData.get(userID);
    }
}
