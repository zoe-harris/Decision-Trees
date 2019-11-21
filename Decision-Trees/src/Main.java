import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter path to text file containing training set: ");
        String trainingSet = scnr.next();

        System.out.print("Enter path to text file containing test set: ");
        String testingSet = scnr.next();

        ID3 me = new ID3();

        int status = me.readData(trainingSet);
        if (status <= 0) return;

        System.out.println("\n--------------------- DECISION TREE RULES ---------------------\n");
        me.createDecisionTree();

        ApplyRules training = new ApplyRules();
        training.getRepresentatives(trainingSet);
        training.classify();

        System.out.println("\n------------------------ APPLY TREE RULES TO TRAINING SET -----------------------");
        training.printRepresentatives();

        ApplyRules test = new ApplyRules();
        test.getRepresentatives(testingSet);
        test.classify();

        System.out.println("\n------------------------ APPLY TREE RULES TO TEST SET -----------------------");
        training.percentageIncorrect();

    }

}
