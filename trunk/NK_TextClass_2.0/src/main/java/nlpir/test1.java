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
		
		String str = "a bb bb c bb c";
		System.out.println(str.replaceAll(" bb ", " "));
		str = str.replaceAll(" bb ", " ");
		System.out.println(str.replaceAll(" bb ", " "));
		
		// 要验证的字符串
	    // 正则表达式规则
	    String regEx = " bb ";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    while(matcher.find()){
	    	str = str.replaceAll(regEx, " ");
	    }
	    System.out.println(str);
		
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
