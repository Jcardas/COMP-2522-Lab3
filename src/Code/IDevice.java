/**
 * Represents an abstract IDevice.
 * An IDevice has a specific purpose and requires subclasses to define their own details.
 * This class provides a method to retrieve the purpose and enforces validation.
 *
 * @author Justin
 * @author Grace
 * @version 1.0
 */
public abstract class IDevice
{
    private final String purpose;

    /**
     * Constructs an {@link IDevice} with the specified purpose.
     *
     * @param purpose The purpose of the device.
     * @throws IllegalArgumentException If the purpose is {@code null}.
     */
    public IDevice(String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    /**
     * Retrieves the purpose of this device.
     *
     * @return The purpose of this device as a {@code String}.
     */
    public String getPurpose()
    {
        return purpose;
    }

    /**
     * Validates that the provided purpose is not {@code null}.
     *
     * @param purpose The purpose to validate.
     * @throws IllegalArgumentException If the purpose is {@code null}.
     */
    private void validatePurpose(final String purpose)
    {
        if (purpose == null)
        {
            throw new IllegalArgumentException("Purpose cannot be null");
        }
    }

    /**
     * Returns a string representation of this device, indicating its purpose.
     *
     * @return A formatted {@code String} describing the device's purpose.
     */
    @Override
    public String toString()
    {
        return ("The purpose of this device is: " + purpose);
    }

    /**
     * Abstract method that must be implemented by subclasses
     * to print the details of the specific device.
     */
    public abstract void printDetails();
}
