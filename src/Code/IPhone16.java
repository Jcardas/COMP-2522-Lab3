import java.util.Objects;

/**
 * Represents an iPhone 16, a type of {@link IPhone} with
 * variables for having a high-res camera, and memory in GB.
 *
 * @author justin
 * @author grace
 * @version 1.0
 */
public class IPhone16 extends IPhone
{
    // Constants
    private static final int MIN_MEMORY_GB;

    static
    {
        MIN_MEMORY_GB = 1;
    }

    // Instance Variables
    private boolean highResCamera;
    private int memoryGB;

    /**
     * Constructs an {@link IPhone16} object with phone plan details, carrier information,
     * a high-resolution camera option, and memory in gigabytes.
     *
     * @param phonePlanMinutesRemaining The number of minutes remaining on the phone plan.
     * @param carrier                   The carrier of the {@link IPhone16}.
     * @param highResCamera             Whether the phone has a high-resolution camera.
     * @param memoryGB                  The memory of the phone in gigabytes.
     * @throws IllegalArgumentException If the memory is less than the minimum required.
     */
    public IPhone16(final double phonePlanMinutesRemaining,
                    final String carrier,
                    final boolean highResCamera,
                    final int memoryGB)
    {
        super(phonePlanMinutesRemaining, carrier);

        validateMemoryGB(memoryGB);
        this.highResCamera = highResCamera;
        this.memoryGB = memoryGB;
    }

    //    Validates the memory size in gigabytes.
    private void validateMemoryGB(final int memoryGB)
    {
        if (memoryGB < MIN_MEMORY_GB)
        {
            throw new IllegalArgumentException("Memory cannot be less than " + MIN_MEMORY_GB);
        }
    }

    /**
     * Returns whether this {@link IPhone16} has a high-resolution camera.
     *
     * @return {@code true} if the phone has a high-res camera, {@code false} otherwise.
     */
    public boolean hasHighResCamera()
    {
        return highResCamera;
    }

    /**
     * Sets whether this {@link IPhone16} has a high-resolution camera.
     *
     * @param highResCamera {@code true} to enable high-res camera, {@code false} to disable.
     */
    public void setHighResCamera(boolean highResCamera)
    {
        this.highResCamera = highResCamera;
    }

    /**
     * Gets the memory of the iPhone16 in gigabytes.
     *
     * @return The memory size in gigabytes.
     */
    public int getMemoryGB()
    {
        return memoryGB;
    }

    /**
     * Sets the memory of the {@link IPhone16} in gigabytes.
     *
     * @param memoryGB The new memory size in gigabytes.
     */
    public void setMemoryGB(int memoryGB)
    {
        this.memoryGB = memoryGB;
    }


    /**
     * Returns a string representation of the {@link IPhone16} object, including details about its phone plan minutes,
     * carrier, high-resolution camera, and memory in GB.
     *
     * @return A string representation of the {@link IPhone16} object.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(super.getPhonePlanMinutesRemaining());
        sb.append(" phone plan minutes remaining with the carrier ");
        sb.append(super.getCarrier());
        sb.append(".");

        if (highResCamera)
        {
            sb.append(" It also has a high-res camera,");
        } else
        {
            sb.append(" It does not have a high-res camera,");
        }

        sb.append(" and has ");
        sb.append(memoryGB);
        sb.append("GB of memory.");

        return sb.toString();
    }

    /**
     * Prints the details of the {@link IPhone16} object to the console.
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Compares this {@link IPhone16} object with another object. Two {@link IPhone16} objects are considered equal if
     * they have the same number of remaining phone plan minutes and the same high-resolution camera status.
     *
     * @param obj The object to compare this {@link IPhone16} with.
     * @return {@code true} if the {@link IPhone16} objects are equal, {@code false} otherwise.
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

        IPhone16 otherIPhone = (IPhone16) obj;
        comparingIPhones = super.getPhonePlanMinutesRemaining() == otherIPhone.getPhonePlanMinutesRemaining() &&
                hasHighResCamera() == otherIPhone.hasHighResCamera();
        return comparingIPhones;
    }

    /**
     * Generates a hash code for the {@link IPhone16} object based on the phone plan minutes remaining.
     *
     * @return The hash code of this {@link IPhone16} object.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getPhonePlanMinutesRemaining());
    }
}
