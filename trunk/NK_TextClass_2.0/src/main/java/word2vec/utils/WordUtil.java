package word2vec.utils;

import java.math.BigDecimal;

public class WordUtil {
	public static String[] classes = { "文化", "教育", "娱乐", "民国", "科技", "武器", "书", "犯罪" };
	public int[] num = {0,0,0,0,0,0,0,0};
	public BigDecimal[] score = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public BigDecimal[] results = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public int resultIndex = 0;
	
}
