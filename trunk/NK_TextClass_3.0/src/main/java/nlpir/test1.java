package nlpir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		long start = System.currentTimeMillis();

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			if(i%1000==0)
//			System.out.println(i + "\tyou are my girl..");
		}
		System.out.println("I LOVE YOU");
//		System.out.println("爱你时间的千分之一为：" + (System.currentTimeMillis()-start)/1000.0 + "s");
		System.out.println("总共可以爱你时间：" + (System.currentTimeMillis()-start) + "s");
//		System.out.println("总共可以爱你时间：" + (System.currentTimeMillis()-start)/60.0 + "min");
//		System.out.println("总共可以爱你时间：" + (System.currentTimeMillis()-start)/3600.0 + "h");
	}

	public static void testReading() throws FileNotFoundException, IOException {
		BufferedReader bufr = new BufferedReader(new FileReader(new File("c:/d/military.txt")));
		String str = null;
		int count = 0;
		int total = 0;
		String[] strs = new String[3];
		double[] ds = new double[3];
		while((str = bufr.readLine())!=null){
			strs = str.trim().split(" ");
			total++;
			for (int i = 0; i < ds.length; i++) {
				ds[i] = Double.parseDouble(strs[i]);
			}
			if(ds[1]>=ds[0]&&ds[1]>=ds[2]){
				count++;
				System.out.println(count + ":" +str);
			}
		}
		System.out.println("正确率：" + (count*1.0/total) + "%");
	}

	private static void stopWords() throws FileNotFoundException, IOException {
		BufferedReader bufr = new BufferedReader(new FileReader(new File("C:/D/NLPIR/stopwords/MyStopWords.txt")));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/stopwords/StopWords.txt")));
		String line = null;
		while((line = bufr.readLine())!=null){
			bufw.write(" " + line + " ");
			System.out.println(line);
			bufw.newLine();
			bufw.flush();
		}
		
		bufw.close();
		bufr.close();
	}
}
