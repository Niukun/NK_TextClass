##1、语料词向量生成（针对搜狗语料库）##
第一步：utils/splitFileUtils.java:切分大文件，并验证是否符合标准  
第二步：utils/xmlFilesToTxt.java:将小文件逐一转化为xml文件，并从xml文件中逐一解析出需要的小文本集合  
第三步：utils/mergeFileUtils.java:将小文件合并成大文件  

第四步：utils/Normalize.java:顺对单个文档进行预处理  
第五步：nlpir/SegmentFile.java:使用NLPIR工具进行分词，直接对文件操作  
第六步：utils/countFileWords.java:计算文档词数的功能  

第七步：demo/FitDemo.java:生成词向量  
第八步：nlpir/EntryOfTheCode.java:计算准确率  

## 2、实验数据整理   ##
重要一步：预先处理要分类的文件  
第〇步：data/DataClean.java:去除无用的信息  

第一步：data/FileToLine.java:生成每个类别文件的txt，使其每一行对应一个文件  
第二步：data/SegmentDoc.java:分词  
第三步：data/FormatFile.java:移除停用词  
第四步：utils/mergeFileUtils.java:合并生成语料文件
第五步：demo/FitDemo.java:生成词向量  
第六步：nlpir/EntryOfTheCode2017.java:进行实验，得到准确率  

其中：data/keyWords.java:获取每个文档的tf、tfidf值（工具类）  

## 3、我的计划 ##
2017/02/25写，未来三天  
2.25：完成关键词提取，跑通文档分类算法，准确率不能低于60%  
2.26：调整参数提高准确率  
2.27：开始写大小论文  (失败)
		
## 4、我的进度（持续更新）： ##
2017/02/25  
今天上午完成关键词提取的功能  
	
2017/02/26  
今天上午完成准确率计算，昨天没有得到准确率，今天压力大了，还有参数调整和优化。  

2017/03/04  
用之前大文件生成的词向量进行分类实验，同步修改代码，查看准确率  
mallet数据导入和主题建模，能够得到一个分类的关键词  
修改词向量配置，重新对训练数据生成词向量  
使用deeplearning4j训练得到一段文字的词向量，看看得到的是什么情况  

2017/03/05  
准备完成：  
早上完成数据清洗工作，跑一遍代码看准确率情况  
使用mallet将处理好的数据导入进来生成主题词汇，用来作为分类标签  
实际完成：  
夜间得到sohusite_tensite、sohusite、tensite的200维1次迭代的词向量  

##  参考： ##
NLPIR官网：http://ictclas.nlpir.org/  
NLPIR github:https://github.com/NLPIR-team/NLPIR  
NLPIR使用教程：http://www.cnblogs.com/wukongjiuwo/p/4092480.html  
deeplearning4j_word2vec:https://deeplearning4j.org/cn/word2vec