package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Output {
	
    private static final String FILE_NAME = "prediction.data.training";

    //
	public static void write(String [] dataSet){
        try {
            FileWriter fw = new FileWriter(FILE_NAME,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outFile = new PrintWriter(bw, true);
            outFile.println(dataSet[0] + "," + dataSet[1] + "," + dataSet[2] + "," + dataSet[3] + 
            		"," + dataSet[4] + "," + dataSet[5] + "," + dataSet[6] + "," + dataSet[7] + 
            		"," + dataSet[8] + "," + dataSet[9] + "," + dataSet[10] + "," + dataSet[11]);
            outFile.flush();
            outFile.close();

        } catch(Exception e) {
            System.err.println("Could not write to file, Exception: " + e.getMessage());
        }
    }

}
