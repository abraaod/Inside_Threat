import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

	public void read_ldap(Tree_insiders tree, String FileName) {

		FileInputStream file = null;
		Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			sc = new Scanner(file, "UTF-8");

			// jump first line
			if (sc.hasNextLine()) {
				sc.nextLine();
			}

			while (sc.hasNextLine()) {
				String text = sc.nextLine();
				String[] spliter = text.split(",");
				User user = new User(spliter[0], spliter[1], spliter[2], spliter[3], spliter[4]);
				tree.insertUser(user);
				// System.out.println(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}

	}

	public void read_device(Tree_insiders tree, String FileName) {

		FileInputStream file = null;
		Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			sc = new Scanner(file, "UTF-8");

			// jump first line
			if (sc.hasNextLine()) {
				sc.nextLine();
			}

			while (sc.hasNextLine()) {
				String text = sc.nextLine();
				String[] spliter = text.split(",");
				String[] date_id = spliter[1].split(" ");
				String[] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				Input input = new Input(spliter[0], date_id[0], date_id[1], user_id[1], device.getId(), spliter[4]);
				tree.insertInput(input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}

	}

	public void read_http(Tree_insiders tree, String FileName) {
		FileInputStream file = null;
		Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			sc = new Scanner(file, "UTF-8");

			// jump first line
			if (sc.hasNextLine()) {
				sc.nextLine();
			}

			while (sc.hasNextLine()) {
				String text = sc.nextLine();
				String [] spliter = text.split(",");
				String [] date_id = spliter[1].split(" ");
				String [] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				Http http = new Http(spliter[0], date_id[0], date_id[1], user_id[1], device.getId(), spliter[4]);
				tree.insertHttp(http);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}
	}

	public void read_logon(Tree_insiders tree, String FileName) {
		FileInputStream file = null;
		Scanner sc = null;
		try {
			file = new FileInputStream(FileName);
			sc = new Scanner(file, "UTF-8");

			// jump first line
			if (sc.hasNextLine()) {
				sc.nextLine();
			}

			while (sc.hasNextLine()) {
				String text = sc.nextLine();
				String [] spliter = text.split(",");
				String [] date_id = spliter[1].split(" ");
				String [] user_id = spliter[2].split("/");
				Date date = new Date(date_id[0], user_id[1]);
				tree.insertDate(date);
				Device device = new Device(spliter[3], user_id[1], date_id[0]);
				tree.insertDevice(device);
				Logon logon = new Logon(spliter[0], date_id[0], date_id[1], user_id[1], device.getId(), spliter[4]);
				tree.insertLogon(logon);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}
	}
}
