package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataClean {

	static BufferedReader bufr = null;
	static BufferedWriter bufw = null;

	public static void main(String[] args) throws Exception {
		System.out.println("start...");
		cleanCulture("C:/D/NLPIR/paper/files/test/culture/");
		cleanEducation("C:/D/NLPIR/paper/files/test/education/");
		cleanEntertainment("C:/D/NLPIR/paper/files/test/entertainment/");
		cleanHistory("C:/D/NLPIR/paper/files/test/history/");
		cleanIT("C:/D/NLPIR/paper/files/test/it/");
		cleanMilitary("C:/D/NLPIR/paper/files/test/military/");
		cleanReading("C:/D/NLPIR/paper/files/test/reading/");
		cleanSocietylaw("C:/D/NLPIR/paper/files/test/society&law/");
		System.out.println("end....");
	}


	private static void cleanSocietylaw(String path) throws Exception{
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("【】")) {
				} else if (line.contains("公益又开心:")) {
				} else if (line.contains("请您文明上网")) {
				} else if (line.contains("欢迎登录")) {
				} else if (line.contains("最佳建仓股")) {
				} else if (line.contains("资料图片：")) {
				} else if (line.contains("我要评论")) {
				} else if (line.contains("连线：")) {
				} else if (line.contains("网上整理")) {
				} else if (line.contains("延伸阅读")) {
					break;
				} else if (line.contains("欢迎登录")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}


	private static void cleanReading(String path) throws Exception{
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("中国新闻出版报-网")) {
				} else if (line.contains("已有评论")) {
				} else if (line.contains("精彩预告")) {
				} else if (line.contains("特色铃音")) {
				} else if (line.contains("写成了")) {
				} else if (line.contains("【】")) {
				} else if (line.contains("发表：")) {
				} else if (line.contains("连载：")) {
				} else if (line.contains("定价:")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}

	private static void cleanMilitary(String path) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("更多精彩内容")) {
				} else if (line.contains("更多内容阅读")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("【】")) {
				} else if (line.contains("■")) {
				} else if (line.contains("更多关于")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}

	private static void cleanIT(String path) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("联系电话：")) {
				} else if (line.contains("地址：")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("更多精彩新闻")) {
				} else if (line.contains("商家名称：")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("更多关于")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}

	private static void cleanHistory(String path) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("责任编辑")) {
				} else if (line.contains("实用：签证")) {
				} else if (line.contains("网友发表了看法")) {
				} else if (line.contains("||")) {
				} else if (line.contains("【大中小】")) {
				} else if (line.contains("前一页")) {
				} else if (line.contains("下一页")) {
				} else if (line.contains("后一页")) {
				} else if (line.contains("【发表评论")) {
				} else if (line.contains("百年前越南华人生活实")) {
				} else if (line.contains("美地理杂志上清末旧影")) {
				} else if (line.contains("图片推荐频道头")) {
				} else if (line.contains("匿名发表")) {
				} else if (line.contains("本文来源:")) {
				} else if (line.contains("精彩预告片")) {
				} else if (line.contains("中国远征军痛宰鬼子兵")) {
				} else if (line.contains("BigNews")) {
				} else if (line.contains("我要评论")) {
				} else if (line.contains("本文来源：网易娱乐专稿")) {
					bufw.write(line.replace("本文来源：网易娱乐专稿", "").replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				} else if (line.contains("更多关于")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}

	private static void cleanEntertainment(String path) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("责任编辑")) {
				} else if (line.contains("实用：签证")) {
				} else if (line.contains("网友发表了看法")) {
				} else if (line.contains("||")) {
				} else if (line.contains("【大中小】")) {
				} else if (line.contains("【发表评论")) {
				} else if (line.contains("请您文明上网")) {
				} else if (line.contains("我要评论")) {
				} else if (line.contains("本文来源：网易娱乐专稿")) {
					bufw.write(line.replace("本文来源：网易娱乐专稿", "").replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				} else if (line.contains("更多关于")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}

	}

	private static void cleanEducation(String path) throws Exception {

		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("责任编辑")) {
				} else if (line.contains("实用：签证")) {
				} else if (line.contains("独家：答疑")) {
				} else if (line.contains("||")) {
				} else if (line.contains("【大中小】")) {
				} else if (line.contains("【发表评论")) {
				} else if (line.contains("请您文明上网")) {
				} else if (line.contains("我要评论")) {
				} else if (line.contains("相关专题")) {
				} else if (line.contains("更多关于")) {
					break;
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}
	}

	private static void cleanCulture(String path) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(path + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("【大中小】")) {
				} else if (line.contains("所有评论仅代表网友意见")) {
				} else if (line.contains("经书面授权")) {
				} else if (line.contains("资料图片")) {
				} else if (line.contains("发布时间")) {
				} else if (line.contains("不代表本网观点")) {
				} else if (line.contains("后一页")) {
				} else if (line.contains("下一页")) {
				} else if (line.contains("摘自:")) {
				} else if (line.contains("更多文化内容请点击")) {
				} else if (line.contains("本文照片均为资料照片")) {
				} else if (line.contains("网友发表评论")) {
				} else if (line.contains("参与评论匿名用户名")) {
				} else if (line.contains("本文节选自")) {
				} else if (line.contains("相关链接")) {
					break;
				} else if (line.contains("相关阅读")) {
					break;
				} else if (line.length() < 15) {
				} else {
					bufw.write(line.replaceAll("[\\(][^\\(\\)]+[\\)]", "").replaceAll("[\\【][^\\【\\】]+[\\】]", "").replaceAll("[\\（][^\\（\\）]+[\\）]", "").replaceAll("[\\[][^\\[\\]]+[\\]]", ""));
					bufw.newLine();
					bufw.flush();
				}
			}
			if (bufw != null) {
				bufw.close();
			}
			if (bufr != null) {
				bufr.close();
			}
		}
	}
}
