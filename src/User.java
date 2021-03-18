public class User {
    public static void main(String[] args) {
        String output = TransitCalculator.getBestFare(5, 12);
        System.out.println(output);

        TunedTC nycTrip = TunedTC.newTrip();
        String result = nycTrip.getBestFare();
        System.out.println(result);
    }
}
