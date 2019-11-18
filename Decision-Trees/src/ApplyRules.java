import java.util.Vector;

public class ApplyRules
{

    Vector [] represenatives;

    public class Representative
    {
        // decision tree attributes
        boolean physicianFeeFreeze = true;
        boolean adoptBudgetResolution = true;
        boolean antiSatelliteTestBan = true;

        String party; // party as noted in text file
        String classified; // party as classified by decision tree rules

        public Representative(String phys, String budgetRes, String antiSat, String party)
        {
            if (phys.equals("n")) physicianFeeFreeze = false;
            if (budgetRes.equals("n")) adoptBudgetResolution = false;
            if (antiSat.equals("n")) antiSatelliteTestBan = false;
            this.party = party;
        }

    }

    public static void populateRepresentatives(String file)
    {
        // generate list of representative nodes
    }

    public static void classify()
    {
        // classify representatives as "democrat" or "republican"
    }

    public static void percentageIncorrect()
    {
        // display percentage of representatives incorrectly classified by tree rules
    }

}
