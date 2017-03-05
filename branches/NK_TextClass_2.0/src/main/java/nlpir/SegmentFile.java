package nlpir;

import java.math.BigDecimal;

import com.sun.jna.Native;

/**
 * 教程：http://www.cnblogs.com/wukongjiuwo/p/4092480.html#3467712
 * @author Niukun
 *
 */
public class SegmentFile {
	public static void main(String[] args) throws Exception {
		// 初始化
		CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\source\\NLPIR",
				CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		String resultString = null;
		if (0 == init_flag) {
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n" + resultString);
			return;
		}

		System.out.println("初始化成功！");
		//以上部分的内容不用管
		long start = System.currentTimeMillis();
		String sInput = "曾经有一份真挚的感情摆在我的面前我没有珍惜，等我失去的时候才追悔莫及！";

		try {

//			Double d = instance.NLPIR_FileProcess("C:/D/NLPIR/paper/files/merge/tensite/tensite.txt", "C:/D/NLPIR/paper/files/merge/tensite/tensiteSeg.txt", 0);
			Double d = instance.NLPIR_FileProcess("C:/D/NLPIR/paper/files/merge/sohusite_tensite/sohusite_tensite.txt", "C:/D/NLPIR/paper/files/merge/sohusite_tensite/sohusite_tensiteSeg.txt", 0);

			System.out.println("对文件内容进行分词的运行速度为： ");
			if (d.isInfinite())
				System.out.println("无结果");
			else {
				BigDecimal b = new BigDecimal(d);
				System.out.println(b.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP) + "秒");
			}

			instance.NLPIR_Exit();
			System.out.println("end");
			System.out.println("Time is : " +((System.currentTimeMillis()-start)/60000) + " min...");
		} catch (Exception e) {
			System.out.println("错误信息：");
			e.printStackTrace();
		}

	}
}
