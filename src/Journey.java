import java.util.ArrayList;
import java.util.List;

class Journey {
    private final Vehicle vehicle;
    private final List<Toll> tollsPassed;
    private double totalCharge;

    public Journey(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.tollsPassed = new ArrayList<>();
        this.totalCharge = 0.0;
    }

    public void addToll(Toll toll) {
        double charge = toll.calculateCharge(vehicle.getType(), vehicle.getUserType());
        toll.recordVehicle(vehicle, charge);
        tollsPassed.add(toll);
        totalCharge += charge;
    }

    public void displayJourneyDetails() {
        System.out.println("Vehicle ID: " + vehicle.getId());
        System.out.println("Tolls Passed:");
        for (Toll toll : tollsPassed) {
            System.out.println("Toll ID: " + toll.getId() + ", Charge: " +
                    toll.calculateCharge(vehicle.getType(), vehicle.getUserType()));
        }
        System.out.println("Total Charge: " + totalCharge);
    }
}
