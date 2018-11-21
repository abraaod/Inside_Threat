
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		Tree_insiders tree = new Tree_insiders();
		FileReader file = new FileReader();
		System.out.println("começo ldap");
		file.read_ldap(tree, "data/ldap.csv");
		System.out.println("terminou ldap e começou device");
		file.read_input(tree, "data/device.csv");
		System.out.println("terminou device e começou http");
		//file.read_http(tree, "data/http.csv");
		System.out.println("terminou http e começou logon");
		file.read_logon(tree, "data/logon.csv");
		System.out.println("terminou de ler tudo");
		//tree.users();
		//tree.doAnalyzer();
		Analyzer analyzer = new Analyzer();
		analyzer.analyzerUsers(tree.getSpecificUser("RES0962"));
		
	}
}
