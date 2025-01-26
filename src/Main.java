import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Highway highway = new Highway();

        Map<VehicleType, Double> toll1Charges = Map.of(
                VehicleType.CAR, 10.0,
                VehicleType.TRUCK, 20.0,
                VehicleType.BIKE, 5.0,
                VehicleType.BUS, 15.0
        );

        Map<VehicleType, Double> toll2Charges = Map.of(
                VehicleType.CAR, 12.0,
                VehicleType.TRUCK, 22.0,
                VehicleType.BIKE, 7.0,
                VehicleType.BUS, 17.0
        );

        Map<VehicleType, Double> toll3Charges = Map.of(
                VehicleType.CAR, 15.0,
                VehicleType.TRUCK, 25.0,
                VehicleType.BIKE, 10.0,
                VehicleType.BUS, 20.0
        );

        Map<VehicleType, Double> toll4Charges = Map.of(
                VehicleType.CAR, 18.0,
                VehicleType.TRUCK, 28.0,
                VehicleType.BIKE, 12.0,
                VehicleType.BUS, 22.0
        );

        Toll toll1 = new TollImpl("T1", toll1Charges);
        Toll toll2 = new TollImpl("T2", toll2Charges);
        Toll toll3 = new TollImpl("T3", toll3Charges);
        Toll toll4 = new TollImpl("T4", toll4Charges);

        highway.addCityWithToll("A", toll1);
        highway.addCityWithToll("B", toll2);
        highway.addCityWithToll("C", toll3);
        highway.addCityWithToll("D", toll4);

        Vehicle vehicle1 = new Vehicle("V1", VehicleType.CAR, UserType.REGULAR);
        Vehicle vehicle2 = new Vehicle("V2", VehicleType.TRUCK, UserType.VIP);

        highway.registerJourney("A", "D", vehicle1);
        highway.registerJourney("C", "A", vehicle2);

        highway.displayAllTolls();
        highway.displayAllJourneys();
    }
}