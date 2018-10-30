import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
	
	public void read(Tree_insiders tree, String FileName) {
		
		FileInputStream file = null;
		Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			sc = new Scanner(file, "UTF-8");
			
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
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if( sc != null) {
				sc.close();
			}
		}
			
	}
}
