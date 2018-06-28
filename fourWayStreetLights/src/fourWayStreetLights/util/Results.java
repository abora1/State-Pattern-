package fourWayStreetLights.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results {
	public ArrayList<String> resList = new ArrayList<>();
	//add strings to the ArrayList
	private static Results resultI;
	public static Results Instance(){
		if(resultI == null)
		{
			resultI = new Results();
		}
		return resultI;
	}
		public void storeNewResult(String s) {
			resList.add(s);
		}
	//Used to write to the Output file Specified
		public void writeToFile(String s) {
			File f1=null;
			FileWriter fp1=null;
			try{
				 f1=new File(s);
				 fp1=new FileWriter(f1);
				fp1.write(""+resList);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
					fp1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
	//Write to console.
		public void writeToStdout() {
			System.out.println(resList + " \n");
		}
}
