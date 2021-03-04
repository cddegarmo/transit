/* This is my solution for the "Transit Calculator" challenge. It's a program that evaluates which fare option will
result in the least expensive per-ride cost based on how many days and rides one plans to take on vacation.
 */

public class TransitCalculator {

    int days;
    int rides;

    String[] fares = { "Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] farePrices = { 2.75, 33.00, 127.00 };

    public TransitCalculator( int numRides, int numDays ) {
        rides = numRides;
        days = numDays;
    }

    public double unlimited7Price() {
        double weeks = Math.ceil( days / 7.0 );
        double totalCost = weeks * farePrices[ 1 ];

        return totalCost / rides;
    }

    public double unlimited30Price() {
        double periods = Math.ceil( days / 30.0 );
        double totalCost = periods * farePrices[ 2 ];

        return totalCost / rides;
    }

    public double[] getRidePrices() {
        double payPerRidePrice = farePrices[ 0 ];
        double sevenDayPrice = unlimited7Price();
        double thirtyDayPrice = unlimited30Price();

        double[] priceList = { payPerRidePrice, sevenDayPrice, thirtyDayPrice };
        return priceList;
    }

    public String getBestFare() {
        double[] ridePrices = getRidePrices();
        int winidx = 0;

        for( int i = 0; i < ridePrices.length; i++ ) {
            if( ridePrices[ i ] < ridePrices[ winidx ] ) {
                winidx = i;
            }
        }
        return "You should get the " + fares[ winidx ] + " option at $" + Math.round( ridePrices[ winidx ] * 100.00 ) /
        100.00 + " per ride.";
    }

    // Conduct tests here
    public static void main( String[] args ) {
        TransitCalculator nyc = new TransitCalculator(12, 5);
        System.out.println( nyc.getBestFare());
    }
}
