package pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class LeyendoArchivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leer();
		
	}
	
	public static void leer(){
		
		String file = "/home/juan/archivo";
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String currentLine;
			
			br = new BufferedReader(new FileReader(file));
			
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
	}

}
