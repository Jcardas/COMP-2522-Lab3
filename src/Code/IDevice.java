/**
 * Represents a device.
 * A device gets it's purpose and prints its own details.
 */
public abstract class IDevice
{
    private final String purpose;

    public IDevice()
    {
        this.purpose = "";
    }

    public IDevice(String purpose)
    {
        this.purpose = purpose;

    }

    public String getPurpose()
    {
        String purpose;

        purpose = "";

        return purpose;
    }

    private void validatePurpose()
    {

    }

    public abstract void printDetails();
}
