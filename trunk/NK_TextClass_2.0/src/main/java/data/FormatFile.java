package data;

import java.io.File;

import word2vec.utils.Normalize;

public class FormatFile {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		getFileNormalized("C:/D/NLPIR/paper/files/test/seg/");
		getFileNormalized("C:/D/NLPIR/paper/files/train/seg");
		System.out.println("end...");
		System.out.println("Time is : " + ((System.currentTimeMillis() - start )/60000) + " min");
	}

	private static void getFileNormalized(String dataPath) throws Exception {
		File file = new File(dataPath);
		File normalizeFile = new File(file.getAbsolutePath()+"/Normalize/");
		normalizeFile.mkdir();
		File[] files = file.listFiles();
		for (File f : files) {
			if (!f.isDirectory()){
				//传进去的参数都是txt结尾的
				Normalize.ProcessWithoutTXT(f.getAbsolutePath(),normalizeFile.getAbsolutePath()+"/" + f.getName());
			}
		}
	}

}
