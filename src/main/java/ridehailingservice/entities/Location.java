package ridehailingservice.entities;

public class Location {
    public double latitude;
    public double longitude;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(Location other) {
        double dx = this.latitude - other.latitude;
        double dy = this.longitude - other.longitude;
        return Math.sqrt(dx * dx + dy * dy); // Euclidean for simplicity
    }

    @Override
    public String toString() {
        return "Location(" + latitude + ", " + longitude + ")";
    }
}
