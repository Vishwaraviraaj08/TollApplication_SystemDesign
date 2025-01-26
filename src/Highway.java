import java.util.*;

class Highway {
    private final Map<String, Toll> cityToTollMap;
    private final List<String> cities;
    private final List<Journey> journeys;

    public Highway() {
        cityToTollMap = new HashMap<>();
        cities = new ArrayList<>();
        journeys = new ArrayList<>();
    }

    public void addCityWithToll(String city, Toll toll) {
        cities.add(city);
        cityToTollMap.put(city, toll);
    }

    public void registerJourney(String startCity, String destinationCity, Vehicle vehicle) {
        Journey journey = new Journey(vehicle);
        List<Toll> tolls = findTollsBetweenCities(startCity, destinationCity);

        for (Toll toll : tolls) {
            journey.addToll(toll);
        }

        journeys.add(journey);

        System.out.println("Journey Details:");
        journey.displayJourneyDetails();
    }

    private List<Toll> findTollsBetweenCities(String startCity, String destinationCity) {
        int startIndex = cities.indexOf(startCity);
        int endIndex = cities.indexOf(destinationCity);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid start or destination city.");
        }

        List<Toll> tollsClockwise = new ArrayList<>();
        List<Toll> tollsCounterClockwise = new ArrayList<>();
        int n = cities.size();

        int i = startIndex;
        while (i != endIndex) {
            tollsClockwise.add(cityToTollMap.get(cities.get(i)));
            i = (i + 1) % n;
        }
        tollsClockwise.add(cityToTollMap.get(cities.get(endIndex)));

        i = startIndex;
        while (i != endIndex) {
            tollsCounterClockwise.add(cityToTollMap.get(cities.get(i)));
            i = (i - 1 + n) % n;
        }
        tollsCounterClockwise.add(cityToTollMap.get(cities.get(endIndex)));

        return tollsClockwise.size() <= tollsCounterClockwise.size() ? tollsClockwise : tollsCounterClockwise;
    }

    public void displayAllTolls() {
        System.out.println("All Tolls and Passing Vehicles:");
        for (Map.Entry<String, Toll> entry : cityToTollMap.entrySet()) {
            Toll toll = entry.getValue();
            System.out.println("City: " + entry.getKey() + ", Toll ID: " + toll.getId());
            System.out.println("Vehicles Passed:");
            for (VehicleRecord record : toll.getVehicleRecords()) {
                System.out.println("Vehicle ID: " + record.getVehicle().getId() + ", Amount Paid: " + record.getAmountPaid());
            }
        }
    }

    public void displayAllJourneys() {
        System.out.println("All Journeys:");
        for (Journey journey : journeys) {
            journey.displayJourneyDetails();
        }
    }
}