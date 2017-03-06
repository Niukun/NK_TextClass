package nlpir;

import java.awt.FocusTraversalPolicy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;

import com.sun.jna.Native;

import data.keyWords;
import tfidf.src.org.akgul.MutableInt;
import word2vec.utils.ResuUtils;
import word2vec.utils.WordUtil;

public class EntryOfTheCode2017 {

	static CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\source\\NLPIR",
			CLibrary.class);
	static Word2Vec word2Vec;
	static BufferedWriter bufw = null;

	private static List<String> allDocuments = new ArrayList<String>();
	private static BufferedWriter bufwidf;
	private static BufferedWriter bufwtf;
	private static Map<String, Double> idfmap;
	private static Map<String, MutableInt> tfmap;
	private static int keyWordsNum = 9;
	private static BigDecimal big0 = new BigDecimal(0.0);
	private static BigDecimal big1 = new BigDecimal(-1.0);
	static int errorNum = 0;
	static int noClass = 0;//没有分类结果的个数
	static int[][] resultMatix = new int[WordUtil.classes.length][WordUtil.classes.length];

	private static BufferedWriter bufww;
	// 初始化
	static {
		// 分词模块初始化
		int init_flag = instance.NLPIR_Init("", 1, "0");
		try {
			bufww = new BufferedWriter(new FileWriter(new File("c:/d/result.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String resultString = null;
		if (0 == init_flag) {
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n" + resultString);
		}
		// 词向量模型加载
		long start = System.currentTimeMillis();
		word2Vec = WordVectorSerializer.readWord2VecModel("C:/D/NLPIR/paper/files/merge/clean3.0/clean3.0_200_1.txt");
		// word2Vec =
		// WordVectorSerializer.readWord2VecModel("C:/D/NLPIR/paper/files/merge/sohusite_tensite/sohusite_tensiteVector_100_1.txt");
		System.out.println("加载模型使用时间：" + (System.currentTimeMillis() - start));

		// tfidf模块准备，得到idfmap和所有分类文档
		try {
			keyWords kw = new keyWords();
			idfmap = kw.getIdfmap();
			allDocuments = kw.getAllDocuments();
			System.out.println("idf map size:" + idfmap.size());
		} catch (IOException e1) {
			System.out.println("New keyWords() error...");
			// e1.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		// test();
		// System.out.println();
		// System.out.println();
		// train();
		// System.out.println();
		// System.out.println();
		all();
		
		for (int i = 0; i < resultMatix.length; i++) {
			for (int j = 0; j < resultMatix.length; j++) {
				System.out.print(resultMatix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(noClass);
	}

	private static void all() throws Exception {
//		System.out.println(
//				(getCorrectNum("C:/D/NLPIR/paper/files/all/culture.txt", WordUtil.classes[0], keyWordsNum) * 100)
//						+ "%");
//		System.out.println(
//				(getCorrectNum("C:/D/NLPIR/paper/files/all/it.txt", WordUtil.classes[0], keyWordsNum) * 100)
//				+ "%");
		System.out.println(
				(getCorrectNum("C:/D/NLPIR/paper/files/all/entertainment.txt", WordUtil.classes[0], keyWordsNum) * 100)
						+ "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/all/history.txt",
		// WordUtil.classes[1], keyWordsNum) * 100)
		// + "%");
		System.out.println(
				(getCorrectNum("C:/D/NLPIR/paper/files/all/military.txt", WordUtil.classes[1], keyWordsNum) * 100)
						+ "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/all/reading.txt",
		// WordUtil.classes[3], keyWordsNum) * 100)
		// + "%");
		System.out.println(
				(getCorrectNum("C:/D/NLPIR/paper/files/all/society&law.txt", WordUtil.classes[2], keyWordsNum) * 100)
						+ "%");

	}

	private static void test() throws Exception {
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/testnum/seg/Normalize/culture.txt",
				WordUtil.classes[0], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/testnum/seg/Normalize/history.txt",
				WordUtil.classes[1], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/testnum/seg/Normalize/military.txt",
				WordUtil.classes[2], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/testnum/seg/Normalize/reading.txt",
				WordUtil.classes[3], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/testnum/seg/Normalize/society&law.txt",
				WordUtil.classes[4], keyWordsNum) * 100) + "%");

	}

	public static void train() throws Exception {
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/culture.txt",
				WordUtil.classes[0], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/history.txt",
				WordUtil.classes[1], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/military.txt",
				WordUtil.classes[2], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/reading.txt",
				WordUtil.classes[3], keyWordsNum) * 100) + "%");
		System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/society&law.txt",
				WordUtil.classes[4], keyWordsNum) * 100) + "%");

		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/culture.txt",
		// WordUtil.classes[0], keyWordsNum) * 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/education.txt",
		// WordUtil.classes[1], keyWordsNum) * 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/entertainment.txt",
		// WordUtil.classes[2], keyWordsNum)* 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/history.txt",WordUtil.classes[3],
		// keyWordsNum) * 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/it.txt",
		// WordUtil.classes[4], keyWordsNum) * 100) + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/military.txt",
		// WordUtil.classes[5], keyWordsNum) * 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/reading.txt",
		// WordUtil.classes[6], keyWordsNum) * 100)
		// + "%");
		// System.out.println((getCorrectNum("C:/D/NLPIR/paper/files/trainnum/seg/Normalize/society&law.txt",
		// WordUtil.classes[7], keyWordsNum) * 100)
		// + "%");
	}

	public static double getCorrectNum(String fileAbsulotePath, String className, int keyNum) throws Exception {
		// 临时用来读取文件，故加tem
		BufferedReader bufrtem = new BufferedReader(new FileReader(fileAbsulotePath));
		List<String> list = new ArrayList<String>();
		String line = null;
		while ((line = bufrtem.readLine()) != null) {
			list.add(line);
		}
		
		// System.out.println(className + " list.size():" + list.size());
		int correctNum = 0;// 记录正确分类的个数
		for (int index = 0; index < list.size(); index++) {// 对每行（即每个文档）单独处理
			String[] strs;// 用来存放关键字
			WordUtil wu = new WordUtil();
			strs = keyWords.getSortedKeyWords(list.get(index), keyNum);// 使用tfidf抽取关键字
			tfmap = keyWords.getTfmap();
			// System.out.println();//为方便打印关键字换行
			for (int i = 0; i < strs.length; i++) {// 对于每个关键字
				if (strs[i] != null) {// 如果不是null，和不同类别计算距离
					// 1 得到关键字最近的分类，和与该类的距离
					ResuUtils re = getWordsClassDistance(strs[i]);
					// 2 找到该分类在WordUtil中classes的序号，类标志位加1，得分加上cos值
					for (int j = 0; j < wu.classes.length; j++) {
						if (re.c != null && re.c.equals(wu.classes[j])) {
							wu.num[j]++;
							double tf = tfmap.get(strs[i]).getCounter();
							double idf = idfmap.get(strs[i]);
							wu.tfidf[j] = new BigDecimal(tf * idf);
							wu.score[j] = wu.score[j].add(re.temp.multiply(wu.tfidf[j]));
//							bufww.write(strs[i] + ":" + wu.tfidf[j]);
//							bufww.newLine();
						}
					}
				}
			}

			bufww.write("-------------------------");
			bufww.newLine();

			// 得到每个类平均的cos值
			for (int i = 0; i < wu.results.length; i++) {
				if (wu.num[i] != 0) {
					wu.results[i] = wu.score[i].divide(new BigDecimal(wu.num[i]), 8, BigDecimal.ROUND_HALF_UP);
//					bufww.write(wu.classes[i] + ":" + wu.results[i] + ":" + wu.num[i] + ":" + wu.score[i]);
//					bufww.newLine();
				} else {
					wu.results[i] = new BigDecimal(0);
				}
			}

			for (int i = 0; i < wu.num.length; i++) {
				if (wu.num[i] != 0) {
					wu.resultIndex = 0;
				}
			}
			if (wu.resultIndex == -1) {
				bufww.write("没有此分类。。。。。");
				noClass++;
				bufww.write("*********************************************");
				bufww.newLine();
				continue;
			}
			// 最大cos值的index，通过它找到类
			// System.out.print(wu.results[0] + " ");
			for (int i = 1; i < wu.results.length; i++) {
				// System.out.print(wu.results[i] + " ");
				if (wu.results[i].compareTo(wu.results[wu.resultIndex]) > 0) {
					if (wu.results[i].compareTo(new BigDecimal(0.9)) >= 0) {
					} else {
						wu.resultIndex = i;
					}

				}
			}
			if (wu.classes[wu.resultIndex].equals(className)) {
				correctNum++;
			}
			// System.out.println();
			if (!className.equals(wu.classes[wu.resultIndex])) {
				// System.out.println(errorNum++ + ":实际分类：" + className + "
				// 分类结果为：" + wu.classes[wu.resultIndex]);
				// bufww.write("#");
				// bufww.newLine();
				for(int j =0;j<wu.classes.length;j++){
					if(wu.classes[j].equals(className)){
						resultMatix[j][wu.resultIndex]++;
					}
				}
			}else{
				resultMatix[wu.resultIndex][wu.resultIndex]++;
			}
			bufww.write("实际分类：" + className + " 分类结果为：" + wu.resultIndex + wu.classes[wu.resultIndex] + " 得分："
					+ wu.results[wu.resultIndex]);
//			bufww.newLine();
//			bufww.write("*********************************************");
			bufww.newLine();
			// System.out.println("分类结果为：" + wu.classes[wu.resultIndex] + " 得分："
			// + wu.results[wu.resultIndex]);
			// System.out.println("*********************************************");
		}
		// System.out.println("正确率为：" + (correctNum*1.0/files.length) + "%...");
		System.out.println(list.size());
		return correctNum * 1.0 / list.size();
	}

	// 得到一个关键字的分类
	public static ResuUtils getWordsClassDistance(String str) throws Exception {
		String[] classes = getClassWords();
		ResuUtils re = new ResuUtils();
		for (int i = 0; i < classes.length; i++) {
			if (word2Vec.hasWord(str) && word2Vec.hasWord(classes[i])) {
				BigDecimal distince = new BigDecimal(word2Vec.similarity(str, classes[i]));
				// BigDecimal distince = calcWordsDistance(str, classes[i]);
				// 找出离该词最近的分类和距离
				if (distince.subtract(re.temp).compareTo(big0) >= 0) {
					re.temp = distince;
					re.c = classes[i];
				}
			} else {
				re.c = null;
			}
		}
		// System.out.println("关键词 "+str + ":最接近的分类是：" + re.c + "---最接近的余弦值为：" +
		// re.temp);
//		bufww.write("关键词 " + str + ":最接近的分类是：" + re.c + "---最接近的余弦值为：" + re.temp);
//		bufww.newLine();
		return re;
	}

	// 计算两个字符串的cos值
	@Deprecated
	public static BigDecimal calcWordsDistance(String string, String string2) {
		double[] ds1 = word2Vec.getWordVector(string);
		double[] ds2 = word2Vec.getWordVector(string2);
		BigDecimal b1, b2, son, moth, res = null;
		double d1 = 0.0, d2 = 0.0, sum = 0.0;
		if (ds1 == null) {
			// System.out.println(string + ":的向量为null");
			return new BigDecimal(0);
		} else if (ds2 == null) {
			// System.out.println(string2 + ":的向量为null");
			return new BigDecimal(0);
		}
		// 得到该向量的模长平方
		for (int i = 0; i < ds1.length; i++) {
			d1 += Math.pow(ds1[i], 2);
		}
		b1 = new BigDecimal(Math.sqrt(d1));
		for (int i = 0; i < ds2.length; i++) {
			d2 += Math.pow(ds2[i], 2);
		}
		b2 = new BigDecimal(Math.sqrt(d2));

		// cos分子部分,对应位相乘
		for (int i = 0; i < ds2.length; i++) {
			sum += ds1[i] * ds2[i];
		}
		son = new BigDecimal(sum);
		res = son.divide(b1.multiply(b2), 8, BigDecimal.ROUND_HALF_UP);
		return res;
	}

	/**
	 * 预设几大类别
	 * 
	 * @return
	 */
	public static String[] getClassWords() {
		// String[] strs = { "文化", "教育", "娱乐", "历史", "互联网", "武器", "阅读", "犯罪" };

		return WordUtil.classes;
	}

	/**
	 * 
	 * @param file
	 *            传入的文件
	 * @param numOfKeysWords
	 *            需要的关键字个数
	 * @return 该文件内容的关键字
	 */
	public static String[] getKeyWords(File file, int numOfKeysWords) {
		String[] strs = null;
		String resultString = null;
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			resultString = instance.NLPIR_GetKeyWords(sb.toString(), numOfKeysWords, false).toLowerCase();
			strs = resultString.split("#");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strs;

	}

	public static String toSemiangle(String src) {
		char[] c = src.toCharArray();
		for (int index = 0; index < c.length; index++) {
			if (c[index] == 12288) {// 全角空格
				c[index] = (char) 32;
			} else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
				c[index] = (char) (c[index] - 65248);
			}
		}
		return String.valueOf(c);
	}
}
