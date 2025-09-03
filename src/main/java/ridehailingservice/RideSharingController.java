package ridehailingservice;

import org.springframework.web.bind.annotation.*;
import ridehailingservice.*;
import ridehailingservice.entities.Driver;
import ridehailingservice.entities.Location;
import ridehailingservice.entities.Trip;
import ridehailingservice.entities.Vehicle;
import ridehailingservice.enums.DriverStatus;
import ridehailingservice.enums.RideType;
import ridehailingservice.observer.Rider;
import ridehailingservice.strategy.matching.NearestDriverMatchingStrategy;
import ridehailingservice.strategy.pricing.VehicleBasedPricingStrategy;

@RestController
@RequestMapping("/api/ride")
public class RideSharingController {

    private final RideSharingService service;

    public RideSharingController() {
        this.service = RideSharingService.getInstance();
        this.service.setDriverMatchingStrategy(new NearestDriverMatchingStrategy());
        this.service.setPricingStrategy(new VehicleBasedPricingStrategy());
    }

    // ✅ Register Rider
    @PostMapping("/riders")
    public Rider registerRider(@RequestParam String name, @RequestParam String contact) {
        return service.registerRider(name, contact);
    }

    // ✅ Register Driver
    @PostMapping("/drivers")
    public Driver registerDriver(@RequestParam String name,
                                 @RequestParam String contact,
                                 @RequestParam String vehicleNumber,
                                 @RequestParam String vehicleModel,
                                 @RequestParam RideType rideType,
                                 @RequestParam double latitude,
                                 @RequestParam double longitude) {
        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleModel, rideType);
        Location location = new Location(latitude, longitude);
        Driver driver = service.registerDriver(name, contact, vehicle, location);
        driver.setStatus(DriverStatus.ONLINE); // driver goes online after registration
        return driver;
    }

    // ✅ Request Ride
    @PostMapping("/request")
    public Trip requestRide(@RequestParam String riderId,
                            @RequestParam double pickupLat,
                            @RequestParam double pickupLng,
                            @RequestParam double dropLat,
                            @RequestParam double dropLng,
                            @RequestParam RideType rideType) {
        Location pickup = new Location(pickupLat, pickupLng);
        Location drop = new Location(dropLat, dropLng);
        return service.requestRide(riderId, pickup, drop, rideType);
    }

    // ✅ Accept Ride
    @PostMapping("/accept")
    public String acceptRide(@RequestParam String driverId, @RequestParam String tripId) {
        service.acceptRide(driverId, tripId);
        return "Driver " + driverId + " accepted Trip " + tripId;
    }

    // ✅ Start Trip
    @PostMapping("/start")
    public String startTrip(@RequestParam String tripId) {
        service.startTrip(tripId);
        return "Trip " + tripId + " started";
    }

    // ✅ End Trip
    @PostMapping("/end")
    public String endTrip(@RequestParam String tripId) {
        service.endTrip(tripId);
        return "Trip " + tripId + " ended successfully";
    }
}
