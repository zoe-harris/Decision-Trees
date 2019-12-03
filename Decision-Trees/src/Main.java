import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter path to text file containing training set: ");
        String trainingSet = scnr.nextLine();

        System.out.print("Enter path to text file containing test set: ");
        String testingSet = scnr.nextLine();

        ID3 me = new ID3();

        int status = me.readData(trainingSet);
        if (status <= 0) return;

        System.out.println("\n--------------------- DECISION TREE RULES ---------------------\n");
        me.createDecisionTree();

        System.out.println("\n------------------------ APPLY TREE RULES TO TRAINING SET -----------------------");

        ApplyRules training = new ApplyRules();
        // retrieve representative data from training set
        training.getRepresentatives(trainingSet);
        // use decision tree rules to classify candidates
        training.classify();
        // print list of candidates with their classifications
        // training.printRepresentatives();
        // print percentage of candidates incorrectly classified
        training.percentageIncorrect();

        System.out.println("\n------------------------ APPLY TREE RULES TO TEST SET -----------------------");

        ApplyRules test = new ApplyRules();
        // retrieve representative data from test set
        test.getRepresentatives(testingSet);
        // use decision tree rules to classify candidates
        test.classify();
        // print percentage of candidates incorrectly classified
        test.percentageIncorrect();

    }

}
