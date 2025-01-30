/**
 * Represents a device.
 * A device gets its purpose and prints its own details.
 */
public abstract class IDevice
{
    private final String purpose;

    public IDevice(String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return purpose;
    }

    private void validatePurpose(final String purpose)
    {
        if(purpose == null)
        {
            throw new IllegalArgumentException("Purpose cannot be null");
        }
    }

    @Override
    public String toString()
    {
        return("The purpose of this device is: " + purpose);
    }

    public abstract void printDetails();
}
