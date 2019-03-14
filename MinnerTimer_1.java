import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

public class MinnerTimer_1 {
	
	public final static int MAX_DIFF = 4;
	
	private final static String DIFF_MILLS_FILE = "diffcult_time.txt"; 
	private final static String FILE_ENCODE = "UTF-8";
	
	public static int[] runMillsOfDiffcults() {
		
		Timestamp genesisTime = new Timestamp(System.currentTimeMillis());
		Block parent = new Block("genesis", genesisTime);
		Block miner = new Block("xinying", new Timestamp(System.currentTimeMillis()), parent.getBlockID(), parent, null);
		
		PrintWriter timeWriter = null; 
		try {
			timeWriter = new PrintWriter(DIFF_MILLS_FILE, FILE_ENCODE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		long startTime = System.currentTimeMillis();
		
		int i=0, difficult=6;
		int []sum = new int[100];
		for(; i<100; i++){
			int j=0;
			startTime = System.currentTimeMillis();
			ProofWork powProof = new ProofWork();
			for(; j<1000 ; j++) {
				
				powProof.setMainDiff(difficult);
				miner.setProof(powProof);
				miner.mineBlock();
				
				parent = miner;

			    miner.setBlockID("a"+miner.getBlockID());
				
			}
			sum[i] = (int)(System.currentTimeMillis() - startTime);
			timeWriter.print(sum[i]);
			timeWriter.println();
			timeWriter.flush();
			System.out.println("sum["+i+"], use time: " + sum[i] + " ms");
			System.out.println("**********************************");
		}
		
		timeWriter.close();
		
		return sum;
	}
	
	public static void main(String args[]) {
		runMillsOfDiffcults();
//		readDiffcultsMills();
	}
}

