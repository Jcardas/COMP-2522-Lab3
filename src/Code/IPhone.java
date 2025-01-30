import java.util.Objects;

/**
 * Represents an iPhone, a type of {@link IDevice} with the purpose of  talking.
 * This class has variables for the phone's carrier and
 * remaining minutes on its phone plan.
 */
public class IPhone extends IDevice
{

    private static final double MIN_PHONE_PLAN_MINUTES_REMAINING;
    private static final String PURPOSE;

    static
    {
        MIN_PHONE_PLAN_MINUTES_REMAINING = 0.0;
        PURPOSE = "talking";
    }

    private final double phonePlanMinutesRemaining;
    private final String carrier;

    /**
     * Constructs an {@link IPhone} object with the specified remaining minutes
     * and carrier.
     *
     * @param phonePlanMinutesRemaining The number of minutes remaining
     *                                  on the phone plan.
     * @param carrier                   The mobile carrier for this {@link IPhone}.
     * @throws IllegalArgumentException If phone plan minutes are less than {@code MIN_PHONE_PLAN_MINUTES_REMAINING}
     *                                  or if the carrier is {@code null}.
     */
    IPhone(final double phonePlanMinutesRemaining, final String carrier)
    {
        super(PURPOSE);
        validatePhonePlanMinutesRemaining();
        validateCarrier();

        this.phonePlanMinutesRemaining = phonePlanMinutesRemaining;
        this.carrier = carrier;
    }

    /*
     * Validates that the remaining phone plan minutes are not below
     * the allowed minimum.
     */
    private void validatePhonePlanMinutesRemaining()
    {
        if (phonePlanMinutesRemaining < MIN_PHONE_PLAN_MINUTES_REMAINING)
        {
            throw new IllegalArgumentException("Phone plan minutes remaining cannot be less than" +
                    MIN_PHONE_PLAN_MINUTES_REMAINING);
        }
    }

    //     Validates that the carrier is not null.
    private void validateCarrier()
    {
        if (carrier == null)
        {
            throw new IllegalArgumentException("Carrier cannot be null.");
        }
    }

    /**
     * Returns a string representation of the {@link IPhone}, including its
     * remaining phone plan minutes and carrier.
     *
     * @return A formatted string containing the {@link IPhone}'s details.
     */
    @Override
    public String toString()
    {
        return (super.toString() + ", it has " + phonePlanMinutesRemaining +
                " phone plan minutes remaining with the carrier " + carrier + ".");
    }

    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Checks if this IPhone object is equal to another object.
     * Two IPhone objects are considered equal if they have the same
     * amount of remaining phone plan minutes.
     *
     * @param obj The object to compare to this IPhone.
     * @return {@code true} if the given object is an IPhone with the same
     * remaining phone plan minutes, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean comparingIPhones;

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if (this == obj)
            return true;
        IPhone otherIPhone = (IPhone) obj;
        comparingIPhones = this.phonePlanMinutesRemaining ==
                otherIPhone.phonePlanMinutesRemaining;
        return comparingIPhones;
    }

    /**
     * Generates a hash code for this {@link IPhone} object.
     * Ensures that equal objects have the same hash code.
     *
     * @return The hash code value for this {@link IPhone}.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(phonePlanMinutesRemaining);
    }
}
