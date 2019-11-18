import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {

        // 1. Run ID3.java on the TRAINING SET of examples to build a decision tree.
        // 2. Save an electronic copy of the induced tree.

        ID3 me = new ID3();

        int status = me.readData("C:\\Users\\zharr\\Desktop\\train-house-votes-1984.txt");
        if (status <= 0) return;

        me.createDecisionTree();

        // 3. Next, write a Java program that implements the rules of the decision tree produced by ID3.

        ////////////////////////////////////////////////////////////////////////////////////////////////
        // Credit to B.Abouads for this method of writing from a text file to a Java class
        // https://stackoverflow.com/questions/22374758/how-can-i-execute-java-code-retrived-from-txt-file
        ////////////////////////////////////////////////////////////////////////////////////////////////

        try {

            // create file reader and writer
            BufferedReader br=new BufferedReader(new FileReader("InducedTree.txt"));
            PrintWriter writer=new PrintWriter("d:\\ApplyRules.java");

            // declare class name and execute method
            writer.write("public class ApplyRules{\n");
            writer.write("public static void execute(){\n");

            String reader="";

            // read code from InducedTree.txt -> write to ApplyRules.java
            while((reader=(br.readLine()))!=null)
            {
                writer.write(reader+"\n");
            }

            writer.write("}\n}");

            // close buffered reader and writer
            br.close();
            writer.close();

            // compile ApplyRules.java
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            System.out.println(compiler);
            int b=compiler.run(null, null, null,"d:\\ApplyRules.java");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        // 4. Next, apply your program to the TRAINING SET to make sure it correctly categorizes
        //      each representative in the set as Democrat or Republican.

        // 5a. Run program on TESTING SET.  For each incorrectly classified example, display
        //      entire voting record and the affiliated party.

        // 5b. After processing test data, display percentage of test set that was incorrectly classified.

    }

}
