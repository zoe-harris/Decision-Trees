public class Main {

    public static void main(String[] args) /*throws Exception*/  {

        //  int num = args.length;
        //	if (num != 1) {
        //  	System.out.println("You need to specify the name of the datafile at the command line " );
        //		return;
        //	}

        ID3 me = new ID3();

        long startTime = System.currentTimeMillis();	//  To print the time taken to process the data

        int status = me.readData("C:\\Users\\zharr\\Desktop\\train-house-votes-1984.txt");
        if (status <= 0) return;

        me.createDecisionTree();

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime-startTime)/1000;

        System.out.println( totalTime + " Seconds");


    }

}
