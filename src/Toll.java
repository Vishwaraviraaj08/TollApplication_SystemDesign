import java.util.List;

public interface Toll {
    String getId();
    double calculateCharge(VehicleType vehicleType, UserType userType);
    void recordVehicle(Vehicle vehicle, double amount);
    List<VehicleRecord> getVehicleRecords();
    double getTotalRevenue();
}