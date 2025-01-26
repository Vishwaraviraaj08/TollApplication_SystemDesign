class Vehicle {
    private final String id;
    private final VehicleType type;
    private final UserType userType;

    public Vehicle(String id, VehicleType type, UserType userType) {
        this.id = id;
        this.type = type;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public UserType getUserType() {
        return userType;
    }
}