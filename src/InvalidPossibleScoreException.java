public class InvalidPossibleScoreException extends Exception
{
    /**
     * Constructs a new InvalidPossibleScoreException exception telling the user they
     * entered a score less than 0 for the total points possible for an assignment entered
     */
    public InvalidPossibleScoreException(String message)
    {
        super(message);
    }
}
