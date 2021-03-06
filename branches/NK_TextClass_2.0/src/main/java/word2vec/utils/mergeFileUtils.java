package word2vec.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Niukun
 *
 */
public class mergeFileUtils {

	public static void main(String[] args) {
		System.out.println("start");
//		filetoOne(new File("D:/NLPIR/sougou/big/0214"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/testnum/seg/Normalize"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/trainnum/seg/Normalize"));
//		filetoOne(new File("E:/NLPIR/sougou/news_sohusite_xml/xml/full"));
//		filetoOne(new File("E:/NLPIR/sougou/news_tensite_xml/xml/full"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/merge/sohusite_tensite"));
		filetoOne(new File("C:/D/NLPIR/paper/files/merge/clean3.0"));
		System.out.println("end");
	}

	private static int countFileWords(String string) {
		int wordNum = 0;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(string));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/paper/files/bigfile/bigfileWord.txt"));
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			String str = sb.toString();
			String[] strs = str.split(" ");
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < strs.length; i++) {
				set.add(strs[i].trim().replaceAll("", ""));
			}
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				wordNum++;
				bufw.write(it.next());
				bufw.newLine();
			}
			bufw.flush();
			bufw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordNum;
	}
	
	/**
	 * 把指定目录下所有文件合并成一个文件，以bigfile.txt存在当前文件夹中
	 * 递归处理，得到目录中所有的文本文件
	 * @param file
	 */
	public static void filetoOne(File file) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String line = null;
		try {
			bufw = new BufferedWriter(new FileWriter(file.getParent()+"/bigfile.txt", true));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					filetoOne(files[i]);
				}
			} else {
				bufr = new BufferedReader(new FileReader(file));
//				System.out.println(file.getAbsolutePath());
				while ((line = bufr.readLine()) != null) {
					bufw.write(line.toLowerCase());
					bufw.newLine();
					bufw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufr != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
