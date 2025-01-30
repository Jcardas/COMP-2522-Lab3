import java.util.Objects;

/**
 * Represents an iPhone, a type of {@link IDevice} with the purpose of  talking.
 * This class has variables for the phone's carrier and
 * remaining minutes on its phone plan.
 */
public class IPad extends IDevice
{

    //    private static final double MIN_PHONE_PLAN_MINUTES_REMAINING;
    private static final String PURPOSE;

    static
    {
        PURPOSE = "talking";
    }

    // Instance Variables
    private final boolean hasCase;
    private final String operatingSystemVersion;

    /**
     * Constructs an {@link IPad} object with information about whether it has a case
     * and its operating system version.
     *
     * @param hasCase {@code true} if the iPad has a case, {@code false} otherwise.
     * @param operatingSystemVersion The version of the operating system running on the iPad.
     * @throws IllegalArgumentException If the operating system version is {@code null} or empty.
     */
    IPad(final boolean hasCase, final String operatingSystemVersion)
    {
        super(PURPOSE);
        validateOperatingSystemVersion(operatingSystemVersion);

        this.hasCase = hasCase;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    //     Validates that the operating system version is not null.
    private void validateOperatingSystemVersion(String operatingSystemVersion)
    {
        if (operatingSystemVersion == null || operatingSystemVersion.isBlank())
        {
            throw new IllegalArgumentException("Operating system version cannot be null or empty.");
        }
    }

    /**
     * Returns a string representation of the {@link IPad}, including if it has a case
     * and what OS version it is on.
     *
     * @return A formatted string containing the {@link IPad}'s details.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        if (hasCase)
        {
            sb.append(" it has a case");
        } else
        {
            sb.append(" it has no case");
        }

        sb.append(" and is on version ").append(operatingSystemVersion);

        return sb.toString();
    }

    /**
     * Prints the details of this IPad object to the console.
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Checks if this IPad object is equal to another object.
     * Two IPad objects are considered equal if they have the same
     * operating system version.
     *
     * @param obj The object to compare to this IPad.
     * @return {@code true} if the given object is an IPad with the same
     * operating system version, otherwise {@code false}.
     *
     * @author justin
     * @author grace
     * @version 1.0
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean comparingIPads;

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if (this == obj)
            return true;
        IPad otherIPad = (IPad) obj;
        comparingIPads = Objects.equals(this.operatingSystemVersion, otherIPad.operatingSystemVersion);
        return comparingIPads;
    }

    /**
     * Generates a hash code for this {@link IPad} object.
     * Ensures that equal objects have the same hash code.
     *
     * @return The hash code value for this {@link IPad}.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(operatingSystemVersion);
    }
}
