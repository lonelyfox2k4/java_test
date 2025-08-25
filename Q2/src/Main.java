import java.util.Scanner;

public class Main {

    //     Constants for electric pricing tiers
    private static final double TIER1_LIMIT = 25;
    private static final double TIER2_LIMIT = 75;
    private static final double TIER3_LIMIT = 150;

    private static final double TIER1_PRICE = 1000;
    private static final double TIER2_PRICE = 1250;
    private static final double TIER3_PRICE = 1800;
    private static final double TIER4_PRICE = 2500;

    private static final double TIER1_TOTAL = TIER1_LIMIT * TIER1_PRICE; // 25,000
    private static final double TIER2_TOTAL = TIER1_TOTAL + (TIER2_LIMIT - TIER1_LIMIT) * TIER2_PRICE; // 87,500
    private static final double TIER3_TOTAL = TIER2_TOTAL + (TIER3_LIMIT - TIER2_LIMIT) * TIER3_PRICE; // 222,500

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double electricCount = getValidElectricCount(sc);
        double electricPrice = calculateElectricPrice(electricCount);
        displayResult(electricCount, electricPrice);

        sc.close();
    }

    //    Gets valid electric count from user input (must be non-negative)
    private static double getValidElectricCount(Scanner sc) {
        double electricCount;
        System.out.println("Enter electric count number:");

        do {
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid number:");
                sc.next(); // Clear invalid input
            }
            electricCount = sc.nextDouble();

            if (electricCount < 0) {
                System.out.println("Electric count cannot be negative. Please enter again:");
            }
        } while (electricCount < 0);

        return electricCount;
    }

    //     Calculates electric price based on tiered pricing system
    private static double calculateElectricPrice(double electricCount) {
        if (electricCount <= 0) {
            return 0;
        } else if (electricCount <= TIER1_LIMIT) {
            return calculateTier1Price(electricCount);
        } else if (electricCount <= TIER2_LIMIT) {
            return calculateTier2Price(electricCount);
        } else if (electricCount <= TIER3_LIMIT) {
            return calculateTier3Price(electricCount);
        } else {
            return calculateTier4Price(electricCount);
        }
    }


//     Calculates price for Tier 1 (0-25)

    private static double calculateTier1Price(double electricCount) {
        return electricCount * TIER1_PRICE;
    }


    //     Calculates price for Tier 2 (26-75)
    private static double calculateTier2Price(double electricCount) {
        return TIER1_TOTAL + (electricCount - TIER1_LIMIT) * TIER2_PRICE;
    }


    //      Calculates price for Tier 3 (76-150)
    private static double calculateTier3Price(double electricCount) {
        return TIER2_TOTAL + (electricCount - TIER2_LIMIT) * TIER3_PRICE;
    }


    //     Calculates price for Tier 4 (>150 kWh)
    private static double calculateTier4Price(double electricCount) {
        return TIER3_TOTAL + (electricCount - TIER3_LIMIT) * TIER4_PRICE;
    }

    //      Displays the calculation result with detailed breakdown
    private static void displayResult(double electricCount, double electricPrice) {
        System.out.printf("Total electric price: %.0f VND%n", electricPrice);
    }
}