import java.util.Scanner;
import java.io.*;

public class FileReader {

	public void read_ldap(Tree_insiders tree, String FileName) {

		FileInputStream file = null;
		BufferedReader br = null;
		try {
			file = new FileInputStream(FileName);
			br = new BufferedReader(new InputStreamReader(file));

			// jump first line
			br.readLine();
			
			String sNull = null;

			while ((sNull = br.readLine()) != null) {
				String text = sNull;
				String[] spliter = text.split(",");
				User user = new User(spliter[0], spliter[1], spliter[2], spliter[3], spliter[4]);
				tree.insertUser(user);
				// System.out.println(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void read_input(Tree_insiders tree, String FileName) {

		FileInputStream file = null;
		BufferedReader br = null;
		try {
			file = new FileInputStream(FileName);
			br = new BufferedReader(new InputStreamReader(file));

			// jump first line
			br.readLine();
			
			String sNull = null;
			while ((sNull = br.readLine()) != null) {
				String text = sNull;
				String[] spliter = text.split(",");
				String[] date_id = spliter[1].split(" ");
				String hours = date_id[1];
				String[] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				if(spliter[4].equalsIgnoreCase("connect")) {
					tree.insertConnect(device, hours);
				}else {
					tree.insertDisconnect(device, hours);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void read_http(Tree_insiders tree, String FileName) {
		FileInputStream file = null;
		BufferedReader br = null;
		//Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			br = new BufferedReader(new InputStreamReader(file));
			

			// jump first line
			br.readLine();

			String sNull = null;

			while ( (sNull = br.readLine() ) != null) {
				String text = sNull;
				String [] spliter = text.split(",");
				String [] date_id = spliter[1].split(" ");
				String [] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e1){
			e1.printStackTrace();

		}finally {
			if (file != null) {
				try {
					file.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void read_logon(Tree_insiders tree, String FileName) {
		FileInputStream file = null;
		BufferedReader br = null;
		try {
			file = new FileInputStream(FileName);
			br = new BufferedReader(new InputStreamReader(file));
			//sc = new Scanner(file, "UTF-8");

			// jump first line
			br.readLine();
			

			String sNull = null;

			while ((sNull = br.readLine() ) == null) {
				String text = br.readLine();
				String [] spliter = text.split(",");
				String [] date_id = spliter[1].split(" ");
				String [] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1){
			e1.printStackTrace();
		}finally {
			if (file != null) {
				try {
					file.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
