/**
 * Central place for the analyser's business rules.
 */
public final class Constants {
    private Constants() {
        // Utility class; do not instantiate.
    }

    // Illustrative usage slabs and rates. Update these to match your assignment's rules.
    public static final int SLAB_1_LIMIT = 100;
    public static final int SLAB_2_LIMIT = 300;
    public static final long SLAB_1_RATE = 2L;
    public static final long SLAB_2_RATE = 3L;
    public static final long SLAB_3_RATE = 5L;

    // Average monthly usage thresholds used to assign a grade.
    public static final double GRADE_A_MIN_AVERAGE = 250.0;
    public static final double GRADE_B_MIN_AVERAGE = 150.0;
    public static final double GRADE_C_MIN_AVERAGE = 75.0;
}
