import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InvestmentProjection {

    private static Map<Integer, Double> cache = new HashMap<>();

    public static double computeProjection(double currentAmount, double annualRate, int periods) {
        if (cache.containsKey(periods)) {
            return cache.get(periods);
        }

        if (periods == 0) {
            return currentAmount;
        }

        double projected = computeProjection(currentAmount * (1 + annualRate), annualRate, periods - 1);
        cache.put(periods, projected);
        return projected;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Please enter the initial investment amount: ");
        double initialAmount = inputReader.nextDouble();

        System.out.print("Please enter the yearly growth rate (decimal form, e.g., 0.07 for 7%): ");
        double growthRate = inputReader.nextDouble();

        System.out.print("Enter the number of years to project: ");
        int totalYears = inputReader.nextInt();

        double finalAmount = computeProjection(initialAmount, growthRate, totalYears);
        System.out.printf("Projected value after %d years: %.2f%n", totalYears, finalAmount);

        inputReader.close();
    }
}
