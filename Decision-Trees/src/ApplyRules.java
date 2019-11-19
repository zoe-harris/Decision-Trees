import java.io.*;
import java.util.Vector;

public class ApplyRules
{

    private Vector<Representative> reps = new Vector<Representative>();

    public static class Representative
    {
        // decision tree attributes
        boolean physicianFeeFreeze = true; // 3rd char
        boolean adoptBudgetResolution = true; // 2nd char
        boolean antiSatelliteTestBan = true; // 6th char

        String party; // party as noted in text file, 16th word
        String classified; // party as classified by decision tree rules

        Representative(String phys, String budgetRes, String antiSat, String party)
        {
            if (phys.equals("n")) physicianFeeFreeze = false;
            if (budgetRes.equals("n")) adoptBudgetResolution = false;
            if (antiSat.equals("n")) antiSatelliteTestBan = false;
            this.party = party;
        }

    }

    void getReps(String fileName) throws IOException {

        // open file + make buffer
        //File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // read + throw away first two lines
        br.readLine();
        br.readLine();

        // add a representative for each line in text
        String str;
        while ((str = br.readLine()) != null)
        {
            String[] tokens = str.split(" ");
            Representative r = new Representative(tokens[3], tokens[2], tokens[6], tokens[16]);
            reps.add(r);
        }

        br.close();

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
