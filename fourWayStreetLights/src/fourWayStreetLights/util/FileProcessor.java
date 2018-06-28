package fourWayStreetLights.util;

import java.io.BufferedReader;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Logger.DebugLevel;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileProcessor {
	public FileProcessor() {
	}

	private BufferedReader br = null;

	public FileProcessor(String input) {
		try {
			File f = new File(input);
			br = new BufferedReader(new FileReader(f));
			Logger.writeMessage("New Input File has Been Accepted",DebugLevel.FILE_PROCESSOR);

		} catch (IOException e) {
			System.out.println("No INPUT file Found");
			e.printStackTrace();
			System.exit(0);
		}

	}

	public String readline(){
		try {
			String s = null;
			while ((s = br.readLine()) != null) {
				return s;
			}
		} catch (IOException e) {
			System.out.println("File cannot be Fetched");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("exception occured while parsing file");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
//closes the file when completes execution.
	public void fileclose() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

