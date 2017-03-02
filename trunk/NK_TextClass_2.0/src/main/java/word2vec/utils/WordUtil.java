package word2vec.utils;

import java.math.BigDecimal;

public class WordUtil {
	public String[] classes = { "文化", "教育", "娱乐", "历史", "互联网", "军事", "阅读", "犯罪" };
	public int[] num = {0,0,0,0,0,0,0,0};
	public BigDecimal[] score = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public BigDecimal[] results = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
	public int resultIndex = 0;
	
}
