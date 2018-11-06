package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
	
	public void read(Tree_insiders tree, File filename) {
		
		Scanner sc = null;
		try {
			sc = new Scanner(filename, "UTF-8");
			
			//jump first line
			if(sc.hasNextLine()) {
				sc.nextLine();
			}
			
			while(sc.hasNextLine()) {
				String text = sc.nextLine();
				String [] spliter = text.split(",");
				User user = new User(spliter[0], spliter[1], spliter[2], spliter[3], spliter[4]);
				tree.insertUser(user);
				//System.out.println(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if( sc != null) {
				sc.close();
			}
		}
			
	}
}
