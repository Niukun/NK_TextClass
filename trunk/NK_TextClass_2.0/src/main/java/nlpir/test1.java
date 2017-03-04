package nlpir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		long start = System.currentTimeMillis();
		String str = "asdf 54(delete)5445qwerqwer";
		System.out.println(str.replaceAll("[\\(][^\\(\\)]+[\\)]", ""));
		System.out.println("end");
		System.out.println((System.currentTimeMillis()-start)/60000.0);
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
