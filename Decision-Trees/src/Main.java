import java.io.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        // Training Set
        String trainingSet = "C:\\Users\\zharr\\Desktop\\train-house-votes-1984.txt";

        // 1. Run ID3.java on the TRAINING SET of examples to build a decision tree.
        // 2. Save an electronic copy of the induced tree.

        ID3 me = new ID3();

        int status = me.readData(trainingSet);
        if (status <= 0) return;

        me.createDecisionTree();

        // 3. Next, write a Java program that implements the rules of the decision tree produced by ID3.
        ApplyRules ar = new ApplyRules();
        ar.getReps(trainingSet);

        // 4. Next, apply your program to the TRAINING SET to make sure it correctly categorizes
        //      each representative in the set as Democrat or Republican.

        // 5a. Run program on TESTING SET.  For each incorrectly classified example, display
        //      entire voting record and the affiliated party.

        // 5b. After processing test data, display percentage of test set that was incorrectly classified.

    }

}
