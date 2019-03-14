import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
	
//	private final static String FILE_ENCODE = "UTF-8";
	
    List<Transaction> testTxn = new ArrayList<Transaction>(); 
	
	PrintWriter timeWriter = null; 
	public void testAddTxn(){
		
		Transaction newTxn = new Transaction("Node_0_B_1", "Node_0","Node_1",50.0f, new Timestamp(System.currentTimeMillis()));
		testTxn.add(newTxn);
	}
	
	public static void writeToFile(String file, int content) { 
		BufferedWriter out = null; 
		try { 
			out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file, true)));// true,进行追加写。 
			out.write(content+"\r\n"); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally { 
			try { 
				out.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
	}
		
	public static void main(String args[]) {
		String DIFF_MILLS_FILE = "testTxn.txt"; 
		int testTxnNum=0;
		test[] tt = new test[5000];
		for(int i = 0; i<5000; i++){
			tt[i]  = new test();
		}
		while(true){
			for(int i = 0; i<5000; i++){
				tt[i].testAddTxn();
//				tt[i].writeToFile(DIFF_MILLS_FILE);
			}
			testTxnNum++;
			writeToFile(DIFF_MILLS_FILE, testTxnNum);
			System.out.println(testTxnNum);
		}
	}
}
