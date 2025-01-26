import java.util.*;

public class TollImpl implements Toll {
    private final String id;
    private final Map<VehicleType, Double> charges;
    private final List<VehicleRecord> vehicleRecords;

    public TollImpl(String id, Map<VehicleType, Double> charges) {
        this.id = id;
        this.charges = charges;
        this.vehicleRecords = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public double calculateCharge(VehicleType vehicleType, UserType userType) {
        double baseCharge = charges.getOrDefault(vehicleType, 0.0);
        if (userType == UserType.VIP) {
            baseCharge *= 0.8;
        }
        return baseCharge;
    }

    public void recordVehicle(Vehicle vehicle, double amount) {
        vehicleRecords.add(new VehicleRecord(vehicle, amount));
    }

    public List<VehicleRecord> getVehicleRecords() {
        return vehicleRecords;
    }

    public double getTotalRevenue() {
        return vehicleRecords.stream().mapToDouble(VehicleRecord::getAmountPaid).sum();
    }
}
