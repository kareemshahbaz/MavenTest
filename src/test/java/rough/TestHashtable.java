package rough;

import java.util.Hashtable;

public class TestHashtable {
	
	public static void main(String args[])
	{
		Hashtable<String,String> ht = new Hashtable<String,String>();
		ht.put("Iteration", "1");
		ht.put("TestData", "Login1");
		
		System.out.println(ht.get("TestData"));
		
		
	}

}
