
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		Tree_insiders tree = new Tree_insiders();
		FileReader file = new FileReader();
		file.read(tree, "data/ldap.csv");
		System.out.println(tree.getUserSize());
		Thread.sleep(10000);
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long actual = afterUsedMem - beforeUsedMem;
		System.out.println(actual/1024);
	}
}
