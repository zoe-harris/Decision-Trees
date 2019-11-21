import java.io.*;
import java.util.Arrays;
import java.util.Vector;

public class ApplyRules
{

    private static Vector<Representative> representatives = new Vector<Representative>();

    public static class Representative
    {
        // decision tree attributes
        String physicianFeeFreeze;
        String adoptBudgetResolution;
        String antiSatelliteTestBan;
        String[] votingRecord;

        // party noted in text file
        String party;

        // party according to decision tree rules
        String classifiedParty;

        Representative(String[] votingRecord, String party)
        {
            this.votingRecord = votingRecord;
            this.physicianFeeFreeze = votingRecord[3];
            this.adoptBudgetResolution = votingRecord[2];
            this.antiSatelliteTestBan = votingRecord[6];
            this.party = party;
        }

    }

    void getRepresentatives(String fileName) throws IOException {

        // open file + make buffer
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // read + throw away first two lines
        br.readLine();
        br.readLine();

        // add a representative for each line in text
        String str;
        while ((str = br.readLine()) != null)
        {
            // split line read into array of String tokens
            String[] tokens = str.split(" ");
            // extract party and voting record from tokens
            String party = tokens[16];
            String[] votingRecord = new String[16];
            System.arraycopy(tokens, 0, votingRecord, 0, 16);
            // make new representative and add to list
            Representative r = new Representative(votingRecord, party);
            representatives.add(r);
        }

        // close buffer
        br.close();

    }

    void classify()
    {
        for (Representative r : representatives)
        {
            if (r.physicianFeeFreeze.equals("n"))
            {
                r.classifiedParty = "democrat";
            } else if (r.physicianFeeFreeze.equals("y")) {
                if (r.adoptBudgetResolution.equals("y"))
                {
                    if (r.antiSatelliteTestBan.equals("n"))
                    {
                        r.classifiedParty = "democrat";
                    } else if (r.antiSatelliteTestBan.equals("y"))
                    {
                        r.classifiedParty = "republican";
                    }
                } else if (r.adoptBudgetResolution.equals("n")) {
                    r.classifiedParty = "republican";
                }
            }
        }
    }

    void printRepresentatives()
    {
        System.out.printf( "%-50s %-15s %-15s %n", "VOTING RECORD: ", "PARTY: ", "CATEGORIZED AS: ");
        for (Representative r : representatives)
        {
            System.out.printf( "%-50s %-15s %-15s %n", Arrays.toString(r.votingRecord), r.party, r.classifiedParty);
        }
    }

    public void percentageIncorrect()
    {
        double numIncorrect = 0.0;
        System.out.println("--------------------------- INCORRECTLY CLASSIFIED --------------------------");
        System.out.printf( "%-50s %-15s %-15s %n", "VOTING RECORD: ", "PARTY: ", "CATEGORIZED AS: ");

        for (Representative r : representatives)
        {
            if (!r.classifiedParty.equals(r.party))
            {
                numIncorrect++;
                System.out.printf( "%-50s %-15s %-15s %n", Arrays.toString(r.votingRecord), r.party, r.classifiedParty);
            }
        }
        System.out.println("\nPERCENTAGE INCORRECT: " + (numIncorrect / representatives.size()) * 100 + "%");
    }

}
