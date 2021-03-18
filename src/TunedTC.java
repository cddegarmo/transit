import java.util.Scanner;

public class TunedTC {
    private int rides;
    private int days;
    private int age;

    private enum Fares {
        PER_RIDE("pay-per-ride", 2.75),
        WEEK("7-day unlimited", 33.00),
        MONTH("30-day unlimited", 127.00);

        private String kind;
        private double price;
        Fares(String text, double value) {
            kind = text;
            price = value;
        }
        public String kind()  { return kind;  }
        public double price() { return price; }
    }

    private enum ReducedFares {
        PER_RIDE("pay-per-ride", 1.35),
        WEEK("7-day unlimited", 16.50),
        MONTH("30-day unlimited", 63.50);

        private String kind;
        private double price;
        ReducedFares(String text, double value) {
            kind = text;
            price = value;
        }
        public String kind()  { return kind; }
        public double price() { return price; }
    }

    private TunedTC() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many rides you anticipate during your trip: ");
        rides = s.nextInt();
        System.out.print("How many days will you be staying? ");
        days = s.nextInt();
        System.out.print("You may qualify for reduced fare if 65 or older." +
                "\nPlease enter your age: ");
        age = s.nextInt();
    }

    public static TunedTC newTrip() {
        return new TunedTC();
    }

    private double get7DayPPR() {
        double weeks = Math.ceil(days / 7.0);
        double total = weeks * Fares.WEEK.price();
        return total / rides;
    }

    private double get30DayPPR() {
        double months = Math.ceil(days / 30.0);
        double total = months * Fares.MONTH.price();
        return total / rides;
    }

    private double get7DayReduced() {
        double weeks = Math.ceil(days / 7.0);
        double total = weeks * ReducedFares.WEEK.price();
        return total / weeks;
    }

    private double get30DayReduced() {
        double months = Math.ceil(days / 30.0);
        double total = months * ReducedFares.MONTH.price();
        return total / rides;
    }

    private double[] standardFares() {
        double payPerRide = Fares.PER_RIDE.price();
        double sevenDay = get7DayPPR();
        double thirtyDay = get30DayPPR();

        return new double[]{payPerRide, sevenDay, thirtyDay};
    }

    private double[] reducedFares() {
        double payPerRide = ReducedFares.PER_RIDE.price();
        double sevenDay = get7DayReduced();
        double thirtyDay = get30DayReduced();

        return new double[]{payPerRide, sevenDay, thirtyDay};
    }

    private double[] getRidePrices() {
        if(age >= 65)
            return reducedFares();
        else
            return standardFares();
    }

    public String getBestFare() {
        double[] prices = getRidePrices();
        int best = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < prices[0])
                best = i;
        }
        return String.format("You should get the %s option at $%.2f per ride.",
                Fares.values()[best].kind(), prices[best]);
    }
}
