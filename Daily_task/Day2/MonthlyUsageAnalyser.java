/**
 * Analyses monthly usage and demonstrates arrays, casting, ternary operators,
 * slab-based charges, long arithmetic, and a 2-D array.
 */
public class MonthlyUsageAnalyser {

    public static void main(String[] args) {
        System.out.println("=== Monthly Usage Analyser ===");
        analyseMonthlyUsage(SampleData.HOUSE_1_MONTHLY);
        printWeeklyTotal(SampleData.ONE_WEEK);
        analyseAllHouses(SampleData.THREE_HOUSES_MONTHLY);
    }

    private static void analyseMonthlyUsage(int[] monthlyUsage) {
        long total = 0L;
        int max = monthlyUsage[0];
        int min = monthlyUsage[0];

        for (int usage : monthlyUsage) {
            // Cast each value to long before adding, avoiding int accumulation overflow.
            total += (long) usage;
            if (usage > max) {
                max = usage;
            }
            if (usage < min) {
                min = usage;
            }
        }

        // Explicit cast makes the average fractional rather than integer division.
        double average = (double) total / monthlyUsage.length;
        char grade = average >= Constants.GRADE_A_MIN_AVERAGE ? 'A'
                   : average >= Constants.GRADE_B_MIN_AVERAGE ? 'B'
                   : average >= Constants.GRADE_C_MIN_AVERAGE ? 'C'
                   : 'D';

        long estimatedCharge = calculateCharge(total);

        System.out.println("\nHouse 1 monthly results");
        System.out.println("Total usage: " + total);
        System.out.printf("Average usage: %.2f%n", average);
        System.out.println("Maximum monthly usage: " + max);
        System.out.println("Minimum monthly usage: " + min);
        System.out.println("Usage grade: " + grade);
        System.out.println("Illustrative total charge: " + estimatedCharge);
    }

    /**
     * Calculates an illustrative charge progressively by usage slab.
     * The long return type and long arithmetic reduce overflow risk.
     */
    public static long calculateCharge(long usage) {
        if (usage < 0) {
            throw new IllegalArgumentException("Usage cannot be negative.");
        }

        long charge = 0L;
        long firstSlabUnits = Math.min(usage, Constants.SLAB_1_LIMIT);
        charge += firstSlabUnits * Constants.SLAB_1_RATE;

        if (usage > Constants.SLAB_1_LIMIT) {
            long secondSlabUnits =
                Math.min(usage - Constants.SLAB_1_LIMIT,
                         Constants.SLAB_2_LIMIT - Constants.SLAB_1_LIMIT);
            charge += secondSlabUnits * Constants.SLAB_2_RATE;
        }

        if (usage > Constants.SLAB_2_LIMIT) {
            long thirdSlabUnits = usage - Constants.SLAB_2_LIMIT;
            charge += thirdSlabUnits * Constants.SLAB_3_RATE;
        }

        return charge;
    }

    private static void printWeeklyTotal(int[] weeklyUsage) {
        long weeklyTotal = 0L;
        for (int usage : weeklyUsage) {
            weeklyTotal += (long) usage;
        }
        System.out.println("\nOne-week sample total: " + weeklyTotal);
    }

    private static void analyseAllHouses(int[][] houses) {
        System.out.println("\nThree-house comparison (2-D array)");
        for (int house = 0; house < houses.length; house++) {
            long total = 0L;
            for (int monthlyValue : houses[house]) {
                total += (long) monthlyValue;
            }
            double average = (double) total / houses[house].length;
            System.out.printf("House %d: total=%d, average=%.2f%n",
                              house + 1, total, average);
        }
    }
}
