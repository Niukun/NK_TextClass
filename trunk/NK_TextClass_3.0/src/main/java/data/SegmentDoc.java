package data;

import java.io.File;

import com.sun.jna.Native;

import nlpir.CLibrary;

public class SegmentDoc {
	static CLibrary instance ;
	static{
		// 初始化
				instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\source\\NLPIR",
						CLibrary.class);
				int init_flag = instance.NLPIR_Init("", 1, "0");
				String resultString = null;
				if (0 == init_flag) {
					resultString = instance.NLPIR_GetLastErrorMsg();
					System.err.println("初始化失败！\n" + resultString);
				}
				System.out.println("NLPIR初始化完成...");
	}
	public static void main(String[] args) {
		
		System.out.println("start...");
		segFile("E:/NLPIR/Database/testnum/");
		segFile("E:/NLPIR/Database/trainnum/");
		
		
//		//mallet主题建模数据处理、
//		File file = new File("C:/D/mallet/classes/");
//		File[] files = file.listFiles();
//		for (int i = 0; i < files.length; i++) {
//			segFile(files[i].getAbsolutePath());
//		}
		
		instance.NLPIR_Exit();
		System.out.println("end...");
	}

	/**
	 * 不递归，只处理目录下txt文件
	 * @param dataPath
	 */
	private static void segFile(String dataPath) {
		File file = new File(dataPath);
		File segFile = new File(dataPath + "/seg/");
		segFile.mkdirs();
		File[] files = file.listFiles();
		for (File f : files) {
			if(!f.isDirectory()){
				instance.NLPIR_FileProcess(f.getAbsolutePath(), segFile.getAbsolutePath()+"/"+f.getName(), 0);
//				System.out.println(f.getName() + ":分词完成...");
			}
		}
	}

}
