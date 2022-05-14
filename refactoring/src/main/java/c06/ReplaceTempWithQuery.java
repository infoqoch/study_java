package c06;

public class ReplaceTempWithQuery {
    public static void main(String[] args) {
//        drinkCoffeeTimes(10);
        drinkCoffeeTimesV2(10);
    }

    private static void drinkCoffeeTimes(int years) {
        double breakfastFrequency = 0.5;
        double lunchFrequency = 0.8;
        double dinnerFrequency = 0.3;

        int breakFast = (int) (years * 365 * breakfastFrequency);
        int lunch = (int) (years * 365 * lunchFrequency);
        int dinner = (int) (years * 365 * dinnerFrequency);

        int sum = breakFast + lunch + dinner;

        System.out.println("sum = " + sum);
    }

    private static void drinkCoffeeTimesV2(int years) {
        double breakfastFrequency = 0.5;
        double lunchFrequency = 0.8;
        double dinnerFrequency = 0.3;

        int breakFast = calculateCoffeeTimes(years, breakfastFrequency);
        int lunch = calculateCoffeeTimes(years, lunchFrequency);
        int dinner = calculateCoffeeTimes(years, dinnerFrequency);

        int sum = breakFast + lunch + dinner;

        System.out.println("sum = " + sum);
    }

    private static int calculateCoffeeTimes(int years, double frequency) {
        return (int) (days(years) * frequency);
    }

    public static int days(int years){
        return years*365;
    }
}
