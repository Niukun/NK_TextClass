package word2vec.utils;

import java.math.BigDecimal;

public class WordUtil {
	public static String[] classes =  {"娱乐","武器","犯罪" };
//	public static String[] classes =  {"教育","科技","武器" };
	public int[] num = {0,0,0,0,0,0,0,0};
	public BigDecimal[] score = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public BigDecimal[] results = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public int resultIndex = -1;
	public BigDecimal[] tfidf = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	
}
