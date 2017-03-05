package word2vec.utils;

import java.math.BigDecimal;

public class test {

	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		String str = "###qw qw wq 12131 adqwe 12阿达说的";
		str = str.replaceAll("[a-zA-Z]{1,}", "");
		System.out.println(str);
		
	}

}
