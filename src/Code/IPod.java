import java.util.Objects;

/**
 * Represents a device you can listen to music on, which is a subclass of {@link IDevice}.
 * Contains instance variables, constructor parameters,
 * accessor methods, and mutator methods for values:
 * (int) number of songs stored, and
 * (double) maximum volume in decibels.
 * Overrides the toString() method to return all the instance variables
 * in a single String.
 * Overrides the equals() method. IPods with the same number
 * of songs stored are considered equal.
 * Override the hashcode() method whenever you override equals().
 *
 * @author grace
 * @author justin
 * @version 1.0
 */
public class IPod extends IDevice
{
    private static final double MIN_DECIBEL_LVL;
    private static final double UNSAFE_DECIBEL_LVL;
    private static final String PURPOSE;

    static
    {
        MIN_DECIBEL_LVL = 0.0;
        UNSAFE_DECIBEL_LVL = 85.0;
        PURPOSE = "music";
    }

    private int numOfStoredSongs;
    private final double maxVolumeDecibel;

    /**
     * Constructs an iPod object.
     *
     * @param numOfStoredSongs the current number of stored songs on the iPod.
     * @param maxVolumeDecibel the absolute max volume the iPod
     *                         can go measured in decibels.
     */
    public IPod(final int numOfStoredSongs, final double maxVolumeDecibel)
    {
        super("music");
        validateMaxDecibelLevel();
        this.numOfStoredSongs = numOfStoredSongs;
        this.maxVolumeDecibel = maxVolumeDecibel;


    }

    /**
     * Prints the numOfStoredSongs and maxVolumeDecibel as a string.
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * @return the number of songs stored in the iPod as an integer value.
     */
    public int getNumOfStoredSongs() {
        return numOfStoredSongs;
    }

    /**
     *
     * @param numOfStoredSongs is the number of songs stored on
     *                         the iPod currently.
     */
    public void setNumOfStoredSongs(int numOfStoredSongs) {
        this.numOfStoredSongs = numOfStoredSongs;
    }

    /**
     * Adds 1 to the count of stored songs.
     */
    public void addSong()
    {
        numOfStoredSongs++;
    }

    /**
     * Lowers the number of stored songs by 1.
     */
    public void delSong()
    {
        numOfStoredSongs--;
    }

    /*
     * Validates the inputted decibel level and
     * makes sure it's between MIN_DECIBEL_LVL db and
     * UNSAFE_DECIBEL_LVL (the level when volume become dangerous for humans).
     */
    private void validateMaxDecibelLevel()
    {
        if(maxVolumeDecibel < MIN_DECIBEL_LVL)
        {
            throw new IllegalArgumentException("Max volume must be a positive number.");
        } else if(maxVolumeDecibel > UNSAFE_DECIBEL_LVL)
        {
            throw new IllegalArgumentException("Please input a number that is a safe decibel number.");
        }
    }

    /**
     * Returns a string representation of the {@link IPod}, including its
     * {@code numOfStoredSongs} and {@code maxVolumeDecibel}.
     *
     * @return A formatted string containing the {@link IPod}'s details.
     */
    @Override
    public String toString()
    {
        StringBuilder sb;
        sb = new StringBuilder();

        sb.append(String.format(
                "Number of stored songs: %d\n", numOfStoredSongs));
        sb.append(String.format(
                "Max volume decibel: %f\n", maxVolumeDecibel));

        return sb.toString();
    }

    /**
     * Checks if this IPod object is equal to another object.
     * Two IPod objects are considered equal if they have the same
     * amount of songs stored.
     *
     * @param obj The object to compare to this IPod.
     * @return {@code true} if the given object is an IPod with the same
     * amount of songs stored, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean comparingIPods;

        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        IPod other = (IPod) obj;
        comparingIPods = this.numOfStoredSongs == other.numOfStoredSongs;

        return comparingIPods;
    }

    /**
     * Generates a hash code for this {@link IPod} object.
     * Ensures that equal objects have the same hash code.
     *
     * @return The hash code value for this {@link IPod}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                numOfStoredSongs,
                maxVolumeDecibel);
    }
}
