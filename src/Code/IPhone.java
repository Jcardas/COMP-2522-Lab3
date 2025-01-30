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

    IPhone(final double phonePlanMinutesRemaining, final String carrier)
    {
        super("talking");
        validatePhonePlanMinutesRemaining();
        validateCarrier();

        this.phonePlanMinutesRemaining = phonePlanMinutesRemaining;
        this.carrier = carrier;
    }

    private void validatePhonePlanMinutesRemaining()
    {
        if(phonePlanMinutesRemaining < MIN_PHONE_PLAN_MINUTES_REMAINING)
        {
            throw new IllegalArgumentException("Phone plan minutes remaining cannot be less than" +
                    MIN_PHONE_PLAN_MINUTES_REMAINING);
        }
    }

    private void validateCarrier()
    {
        if(carrier == null)
        {
            throw new IllegalArgumentException("Carrier cannot be null.");
        }
    }

    @Override
    public String toString()
    {
        return(super.toString() + ", it has " + phonePlanMinutesRemaining +
                " phone plan minutes remaining with the carrier " + carrier + ".");
    }

    @Override public void printDetails()
    {
        System.out.println(toString());
    }

}
