public class Assignment
{
    private String assignmentName;
    private double pointsReceived;
    private int totalPointsPossible;

    public Assignment()
    {
    }

    public Assignment(String assignmentName, double pointsReceived, int totalPointsPossible)
    {
        this.assignmentName = assignmentName;
        this.pointsReceived = pointsReceived;
        this.totalPointsPossible = totalPointsPossible;
    }

    public String getAssignmentName()
    {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName)
    {
        this.assignmentName = assignmentName;
    }

    public double getPointsReceived()
    {
        return pointsReceived;
    }

    public void setPointsReceived(int pointsReceived)
    {
        this.pointsReceived = pointsReceived;
    }

    public int getTotalPointsPossible()
    {
        return totalPointsPossible;
    }

    public void setTotalPointsPossible(int totalPointsPossible)
    {
        this.totalPointsPossible = totalPointsPossible;
    }
}
