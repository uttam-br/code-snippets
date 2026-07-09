import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class DashboardChallenge {

    // --- YOUR TASK GOES HERE ---
    public static List<Flight> findBestFlights(String route) {
        // TODO: 1. Create a CompletableFuture for each airline using supplyAsync.
        // TODO: 2. Apply a 2-second timeout to each future using .completeOnTimeout().
        // TODO: 3. Use CompletableFuture.allOf() to wait for all of them.
        // TODO: 4. Extract the results, combine them into one list, and sort by price.

        CompletableFuture<List<Flight>> alphaFlightsFuture = CompletableFuture
                .supplyAsync(() -> fetchAlphaFlights(route))
                .completeOnTimeout(List.of(), 2, TimeUnit.SECONDS);

        CompletableFuture<List<Flight>> betaFlightsFuture = CompletableFuture
                .supplyAsync(() -> fetchBetaFlights(route))
                .completeOnTimeout(List.of(), 2, TimeUnit.SECONDS);

        CompletableFuture<List<Flight>> gammaFlightsFuture = CompletableFuture
                .supplyAsync(() -> fetchGammaFlights(route))
                .completeOnTimeout(List.of(), 2, TimeUnit.SECONDS);

        CompletableFuture<Void> all = CompletableFuture.allOf(alphaFlightsFuture, betaFlightsFuture, gammaFlightsFuture);
        all.join();

        List<Flight> alphaFlights = alphaFlightsFuture.join();
        List<Flight> betaFlights = betaFlightsFuture.join();
        List<Flight> gammaFlights = gammaFlightsFuture.join();

        return Stream.of(alphaFlights, betaFlights, gammaFlights)
                .flatMap(Collection::stream)
                .sorted((f1, f2) -> Double.compare(f1.price(), f2.price()))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("Searching for flights... (Max wait: 2 seconds)\n");
        long startTime = System.currentTimeMillis();

        List<Flight> results = findBestFlights("JFK-LHR");

        long endTime = System.currentTimeMillis();

        results.forEach(System.out::println);
        System.out.println("\nTotal time taken: " + (endTime - startTime) + "ms");

        // If done correctly, the total time should be just over 2000ms.
        // You should see flights from Alpha and Beta, but NOT Gamma.
    }

    // ==========================================
    // MOCK AIRLINE APIs (DO NOT MODIFY THESE)
    // ==========================================

    public static List<Flight> fetchAlphaFlights(String route) {
        simulateDelay(1000); // Fast
        return Arrays.asList(new Flight("Alpha Airlines", 450.00), new Flight("Alpha Airlines", 520.00));
    }

    public static List<Flight> fetchBetaFlights(String route) {
        simulateDelay(1500); // Moderate
        return Arrays.asList(new Flight("Beta Airways", 399.99));
    }

    public static List<Flight> fetchGammaFlights(String route) {
        simulateDelay(5000); // SUPER SLOW! Will trigger timeout.
        return Arrays.asList(new Flight("Gamma Flights", 250.00)); // Great price, but too slow!
    }

    private static void simulateDelay(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }

    // ==========================================
    // DATA CLASSES (DO NOT MODIFY THESE)
    // ==========================================

    record Flight(String airline, Double price) {
        @Override
        public String toString() {
            return String.format("[%s] $%.2f", airline, price);
        }
    }
}