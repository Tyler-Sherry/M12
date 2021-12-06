import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class where command line interacts with user and the user can enter in the
 * assignment names, total points possible for the assignment, and the points earned on
 * the assignment.  The average of the assignments is printed out once the user
 * enters "stop" for the assignment name.
 * @author Tyler Sherry
 */
public class TestScores
{
    public static void main(String[] args)
    {
        /**
         * @throws InvalidPossibleScoreException if the user enters in an assignment score less than 0
         * @throws InvalidScoreEarnedException if the user enters a score received which is less than 0
         * or more than the possible points on the assignment
         */
        double pointsEarned = 0;
        int totalPointsPossible = 0;
        double assignmentArrayListPointsEarned = 0;
        int assignmentArrayListTotalPointsPossible = 0;
        double averageOfAssignments;
        DecimalFormat df = new DecimalFormat("##.##");
        String assignmentName = null;
        Scanner scnr = new Scanner(System.in);
        ArrayList<Assignment> assignmentsArrayList = new ArrayList<Assignment>();

        //Ask the user for the assignment name
        System.out.println("What is the name of the assignment?");
        assignmentName = scnr.next();

        while(!assignmentName.equals("stop"))
        {
            //Ask the user for total points possible for the assignment
            System.out.println("How many total points possible for the assignment?");
            try{
                totalPointsPossible = scnr.nextInt();
                if (totalPointsPossible <= 0)
                    throw new InvalidPossibleScoreException("ERROR: THE POINTS POSSIBLE IS INVALID");
            } catch (InvalidPossibleScoreException e)
            {
                System.out.println(e.getMessage());
            }

            //Ask the user for total points received for the assignment
            System.out.println("How many points did the student earn?");
            try{
                pointsEarned = scnr.nextInt();
                if ((pointsEarned > totalPointsPossible) || (pointsEarned < 0))
                    throw new InvalidScoreEarnedException("ERROR: THE POINTS EARNED IS INVALID");
            } catch (InvalidScoreEarnedException e)
            {
                System.out.println(e.getMessage());
            }

            //Create an assignment object with the information provided by the user
            Assignment assignment = new Assignment(assignmentName, pointsEarned, totalPointsPossible);

            //Add assignment to the Assignment ArrayList
            assignmentsArrayList.add(assignment);

            System.out.println("What is the name of the next assignment? - enter \"stop\" at anytime when you are done.");
            assignmentName = scnr.next();
        };

        /*
        When the user enters the word "stop" for the assignment name the program should
        use a for loop to compute the average of the assignment scores, print the average
        for all of the valid assignments entered and then shut down.
         */
        for(Assignment a : assignmentsArrayList )
        {
            assignmentArrayListPointsEarned += a.getPointsReceived();
            assignmentArrayListTotalPointsPossible += a.getTotalPointsPossible();
        }

        //Compute the average score of the assignments entered by the user
        averageOfAssignments =  100 * (assignmentArrayListPointsEarned / assignmentArrayListTotalPointsPossible);

        //Display the average of the assignments to the user
        System.out.println("The grade earned from these assignments is " +  (int)assignmentArrayListPointsEarned + "/" +
                assignmentArrayListTotalPointsPossible + " (" + df.format(averageOfAssignments) + "%)");
    }
}
