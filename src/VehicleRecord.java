class VehicleRecord {
    private final Vehicle vehicle;
    private final double amountPaid;

    public VehicleRecord(Vehicle vehicle, double amountPaid) {
        this.vehicle = vehicle;
        this.amountPaid = amountPaid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
