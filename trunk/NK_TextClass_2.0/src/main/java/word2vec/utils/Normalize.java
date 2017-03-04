package word2vec.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Normalize {
	private static List<String> stopWordsList = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		System.out.println("start");
		long start = System.currentTimeMillis();
		Process("C:/D/NLPIR/paper/files/merge/tensite/tensiteSeg");
		System.out.println((System.currentTimeMillis() - start) / 60000.0);
		
		Process("C:/D/NLPIR/paper/files/merge/sohusite_tensite/sohusite_tensiteSeg");
		System.out.println("end");
		System.out.println((System.currentTimeMillis() - start) / 60000.0);
	}

	static {
		// 加载stopWords文件，得到一个list
		try {
			BufferedReader signBufr = new BufferedReader(new FileReader("source/stopWords"));
			Set<String> signSet = new HashSet<String>();
			String signStr = "";
			int num = 0;
			while ((signStr = signBufr.readLine()) != null) {
				signSet.add(signStr);
				num++;
			}
			Iterator iter = signSet.iterator();
			while (iter.hasNext()) {
				signStr = (String) iter.next();
				stopWordsList.add(signStr);
			}
			System.out.println("stopWordsList长度：" + stopWordsList.size());

		} catch (Exception e) {
			System.out.println("stopWordsList配置文件加载出错。。。");
			e.printStackTrace();
		}
	}

	/**
	 * 精确到文件名，但是不带后缀 移除停用词
	 * 
	 * @param pathWithFileName
	 * @throws Exception
	 */
	public static void Process(String pathWithFileName) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader(pathWithFileName + ".txt"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(pathWithFileName + "stopWordsRemoved.txt"));
		Set<String> strSet = new TreeSet<String>();

		// 移除停用词
		String str = "";
		while ((str = bufr.readLine()) != null) {
			for (int i = 0; i < stopWordsList.size(); i++) {
				while (str.contains(stopWordsList.get(i))) {
					str = str.replace(stopWordsList.get(i), " ");
				}
			}
			str = str.replaceAll("[a-zA-Z]{1,}", " ").trim();
			while (str.contains("  ")) {
				str = str.replace("  ", " ");
			}
			bufw.write(str);
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
		bufr.close();
	}

	/**
	 * 
	 * @param pathWithFileName
	 * @throws Exception
	 */
	public static void ProcessWithoutTXT(String fileName, String distFileName) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader(fileName));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(distFileName));
		Set<String> strSet = new TreeSet<String>();

		String str = "";
		while ((str = bufr.readLine()) != null) {
			for (int i = 0; i < stopWordsList.size(); i++) {
				while (str.contains(stopWordsList.get(i))) {
					str = str.replace(stopWordsList.get(i), " ");
				}
			}
			str = str.replaceAll("[a-zA-Z]{1,}", " ").trim();
			}
			while (str.contains("  ")) {
				str = str.replace("  ", " ");
			}
			str = str.replaceAll("\t", "");
		}
		Iterator iter = strSet.iterator();
		while (iter.hasNext()) {
			bufw.write((String) iter.next());
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
		bufr.close();
	}
}
