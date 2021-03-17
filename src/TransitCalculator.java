/* This is my solution for the "Transit Calculator" challenge. It's a program that evaluates which fare option will
result in the least expensive per-ride cost based on how many days and rides one plans to take on vacation.
 */

public class TransitCalculator {
    private static int days;
    private static int rides;
    private static final String[] FARES = { "Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    private static final double[] FARE_PRICES = { 2.75, 33.00, 127.00 };

    private TransitCalculator() { }

    private static double unlimited7Price() {
        double weeks = Math.ceil( days / 7.0 );
        double totalCost = weeks * FARE_PRICES[ 1 ];

        return totalCost / rides;
    }

    private static double unlimited30Price() {
        double periods = Math.ceil( days / 30.0 );
        double totalCost = periods * FARE_PRICES[ 2 ];

        return totalCost / rides;
    }

    private static double[] getRidePrices() {
        double payPerRidePrice = FARE_PRICES[ 0 ];
        double sevenDayPrice = unlimited7Price();
        double thirtyDayPrice = unlimited30Price();

        double[] priceList = { payPerRidePrice, sevenDayPrice, thirtyDayPrice };
        return priceList;
    }

    public static String getBestFare(int days, int rides) {
        TransitCalculator.days = days;
        TransitCalculator.rides = rides;
        double[] ridePrices = getRidePrices();
        int winidx = 0;

        for( int i = 0; i < ridePrices.length; i++ ) {
            if( ridePrices[ i ] < ridePrices[ winidx ] ) {
                winidx = i;
            }
        }
        return "You should get the " + FARES[ winidx ] + " option at $" + Math.round( ridePrices[ winidx ] * 100.00 ) /
        100.00 + " per ride.";
    }
}
