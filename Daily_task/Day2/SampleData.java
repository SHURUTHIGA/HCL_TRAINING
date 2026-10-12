/**
 * Sample monthly and weekly usage data for three houses.
 */
public final class SampleData {
    private SampleData() {
    }

    public static final String[] MONTHS = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    // One house's usage for each of the 12 months.
    public static final int[] HOUSE_1_MONTHLY = {
        120, 135, 128, 142, 160, 175, 190, 185, 170, 155, 140, 130
    };

    // Rows represent houses; columns represent months.
    public static final int[][] THREE_HOUSES_MONTHLY = {
        {120, 135, 128, 142, 160, 175, 190, 185, 170, 155, 140, 130},
        {90,  95,  105, 115, 125, 140, 150, 145, 135, 120, 110, 100},
        {210, 205, 215, 220, 230, 240, 255, 250, 245, 235, 225, 215}
    };

    // Seven days of sample usage for a week.
    public static final int[] ONE_WEEK = {18, 20, 17, 22, 19, 25, 21};
}
