public class InvalidScoreEarnedException extends Exception
{
    /**
     * Constructs a new InvalidScoreEarnedException exception telling the user they
     * entered a score less than 0 or more than the total possible score on the
     * assignment
     */
    public InvalidScoreEarnedException(String message)
    {
        super(message);
    }
}
