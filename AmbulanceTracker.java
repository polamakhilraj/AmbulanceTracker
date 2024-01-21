import java.util.HashMap;
import java.util.Map;

class Ambulance {
    private String id;
    private double latitude;
    private double longitude;

    public Ambulance(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void updateLocation(double newLatitude, double newLongitude) {
        this.latitude = newLatitude;
        this.longitude = newLongitude;
    }
    public String toString() {
        return "Ambulance{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

class Tracker {
    private Map<String, Ambulance> ambulanceMap;

    public Tracker() {
        this.ambulanceMap = new HashMap<>();
    }

    public void addAmbulance(Ambulance ambulance) {
        ambulanceMap.put(ambulance.getId(), ambulance);
    }

    public void updateAmbulanceLocation(String ambulanceId, double newLatitude, double newLongitude) {
        Ambulance ambulance = ambulanceMap.get(ambulanceId);
        if (ambulance != null) {
            ambulance.updateLocation(newLatitude, newLongitude);
        }
    }

    public Ambulance getAmbulanceById(String ambulanceId) {
        return ambulanceMap.get(ambulanceId);
    }

    public void displayAmbulanceLocations() {
        System.out.println("Ambulance Locations:");
        for (Ambulance ambulance : ambulanceMap.values()) {
            System.out.println(ambulance);
        }
    }
}
class AmbulanceTracker {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        Ambulance ambulance1 = new Ambulance("A1", 37.7749, -122.4194);
        Ambulance ambulance2 = new Ambulance("A2", 34.0522, -118.2437);

        tracker.addAmbulance(ambulance1);
        tracker.addAmbulance(ambulance2);

        tracker.updateAmbulanceLocation("A1", 38.8951, -77.0364);
        tracker.updateAmbulanceLocation("A2", 40.7128, -74.0060);

        tracker.displayAmbulanceLocations();
    }
}
