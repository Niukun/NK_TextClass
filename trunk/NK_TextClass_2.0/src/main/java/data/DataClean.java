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
		System.out.println("test........................");
		cleanCulture("C:/D/NLPIR/paper/files/test/culture/","C:/D/NLPIR/paper/files/testnum/culture/");
		cleanEducation("C:/D/NLPIR/paper/files/test/education/","C:/D/NLPIR/paper/files/testnum/education/");
		cleanEntertainment("C:/D/NLPIR/paper/files/test/entertainment/","C:/D/NLPIR/paper/files/testnum/entertainment/");
		cleanHistory("C:/D/NLPIR/paper/files/test/history/","C:/D/NLPIR/paper/files/testnum/history/");
		cleanIT("C:/D/NLPIR/paper/files/test/it/","C:/D/NLPIR/paper/files/testnum/it/");
		cleanMilitary("C:/D/NLPIR/paper/files/test/military/","C:/D/NLPIR/paper/files/testnum/military/");
		cleanReading("C:/D/NLPIR/paper/files/test/reading/","C:/D/NLPIR/paper/files/testnum/reading/");
		cleanSocietylaw("C:/D/NLPIR/paper/files/test/society&law/","C:/D/NLPIR/paper/files/testnum/society&law/");
		
		System.out.println("train.......................");
		
		cleanCulture("C:/D/NLPIR/paper/files/train/culture/","C:/D/NLPIR/paper/files/trainnum/culture/");
		cleanEducation("C:/D/NLPIR/paper/files/train/education/","C:/D/NLPIR/paper/files/trainnum/education/");
		cleanEntertainment("C:/D/NLPIR/paper/files/train/entertainment/","C:/D/NLPIR/paper/files/trainnum/entertainment/");
		cleanHistory("C:/D/NLPIR/paper/files/train/history/","C:/D/NLPIR/paper/files/trainnum/history/");
		cleanIT("C:/D/NLPIR/paper/files/train/it/","C:/D/NLPIR/paper/files/trainnum/it/");
		cleanMilitary("C:/D/NLPIR/paper/files/train/military/","C:/D/NLPIR/paper/files/trainnum/military/");
		cleanReading("C:/D/NLPIR/paper/files/train/reading/","C:/D/NLPIR/paper/files/trainnum/reading/");
		cleanSocietylaw("C:/D/NLPIR/paper/files/train/society&law/","C:/D/NLPIR/paper/files/trainnum/society&law/");
	
		System.out.println("end....");
	}


	private static void cleanSocietylaw(String path,String distPath) throws Exception{
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("【】")) {
				} else if (line.contains("公益又开心:")) {
				} else if (line.contains("请您文明上网")) {
				} else if (line.contains("欢迎登录")) {
				} else if (line.contains("最佳建仓股")) {
				} else if (line.contains("资料图片：")) {
				} else if (line.contains("我要评论")) {
				} else if (line.contains("最美微笑战士")) {
				} else if (line.contains("最美警花救起跳楼少女")) {
				} else if (line.contains("2008中国最美50人")) {
				} else if (line.contains("双胞胎大战中国出水芙蓉")) {
				} else if (line.contains("成都最美环卫工")) {
				} else if (line.contains("最美女大学生")) {
				} else if (line.contains("最美酒模\"带小朋友")) {
				} else if (line.contains("连线：")) {
				} else if (line.contains("网上整理")) {
				} else if (line.contains("上海植物园里的")) {
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


	private static void cleanReading(String path,String distPath) throws Exception{
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("中国新闻出版报-网")) {
				} else if (line.contains("已有评论")) {
				} else if (line.contains("精彩预告")) {
				} else if (line.contains("点击阅读")) {
				} else if (line.contains("特色铃音")) {
				} else if (line.contains("日期：")) {
				} else if (line.contains("时间：")) {
				} else if (line.contains("地点：")) {
				} else if (line.contains("讲者：")) {
				} else if (line.contains("报名：")) {
				} else if (line.contains("民间野史")) {
				} else if (line.contains("洪秀全败于极度淫乱")) {
				} else if (line.contains("罗马皇帝却为娶她")) {
				} else if (line.contains("享尽帝后之仪：")) {
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

	private static void cleanMilitary(String path,String distPath) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("BigNews")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("更多精彩内容")) {
				} else if (line.contains("更多内容阅读")) {
				} else if (line.contains("专题回顾：")) {
				} else if (line.contains("彩预告片")) {
				} else if (line.contains("特色铃音")) {
				} else if (line.contains("下一页")) {
				} else if (line.contains("后一页")) {
				} else if (line.contains("前一页")) {
				} else if (line.contains("上一页")) {
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

	private static void cleanIT(String path,String distPath) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
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

	private static void cleanHistory(String path,String distPath) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("责任编辑")) {
				} else if (line.contains("实用：签证")) {
				} else if (line.contains("网友发表了看法")) {
				} else if (line.contains("||")) {
				} else if (line.contains("【大中小】")) {
				} else if (line.contains("前一页")) {
				} else if (line.contains("下一页")) {
				} else if (line.contains("后一页")) {
				} else if (line.contains("商讯凤凰资讯凤凰图片")) {
				} else if (line.contains("【发表评论")) {
				} else if (line.contains("百年前越南华人生活实")) {
				} else if (line.contains("美地理杂志上清末旧影")) {
				} else if (line.contains("图片推荐频道头")) {
				} else if (line.contains("匿名发表")) {
				} else if (line.contains("本文来源:")) {
				} else if (line.contains("来源:")) {
				} else if (line.contains("地址:")) {
				} else if (line.contains("邮箱:")) {
				} else if (line.contains("电话:")) {
				} else if (line.contains("传真:")) {
				} else if (line.contains("奇趣音效")) {
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

	private static void cleanEntertainment(String path,String distPath) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
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

	private static void cleanEducation(String path,String distPath) throws Exception {

		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
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

	private static void cleanCulture(String path,String distPath) throws Exception {
		File file = new File(path);
		File[] files = file.listFiles();
		String line = null;
		for (int i = 0; i < files.length; i++) {
			bufr = new BufferedReader(new FileReader(files[i]));
			bufw = new BufferedWriter(new FileWriter(new File(distPath + i + ".txt")));
			while ((line = bufr.readLine()) != null) {
				if (line.contains("【大中小】")) {
				} else if (line.contains("所有评论仅代表网友意见")) {
				} else if (line.contains("经书面授权")) {
				} else if (line.contains("资料图片")) {
				} else if (line.contains("《沈从文全集》")) {
				} else if (line.contains(":《")) {
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
				} else if (line.contains("本文摘自")) {
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
