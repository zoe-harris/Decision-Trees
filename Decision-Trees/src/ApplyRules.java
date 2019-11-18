import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.io.*;
import java.util.Vector;

public class ApplyRules
{

    Vector [] represenatives;

    public class Representative
    {
        boolean physicianFeeFreeze = true;
        boolean adoptBudgetResolution = true;
        boolean antiSatelliteTestBan = true;
        String party;

        public Representative(String phys, String budgetRes, String antiSat)
        {
            if (phys.equals("n")) physicianFeeFreeze = false;
            if (budgetRes.equals("n")) adoptBudgetResolution = false;
            if (antiSat.equals("n")) antiSatelliteTestBan = false;
        }

    }

    public static void populateRepresentatives(String file)
    {

    }

}
