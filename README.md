## 计科2102班 软工3组代码仓库
开发背景
-------
  编写程序从海外博物馆网站爬取中国文物信息，进行加工处理，构建海外文物知识图谱。主要包括以下功能：  
  1）数据爬取： 爬取海外博物馆网站的中国文物信息（至少爬取指定的5家博物馆的所有中国文物，博物馆网址列表附后），包括文物名字、文物图片、年代、介绍等信息。按照规定格式保存下载的数据。  
  A.具体数据格式如下：所有爬取的数据以utf-8编码保存为csv格式。  
  B.数据内容要求如下：应至少包含以下数据，文物基础数据（网站提供），如标题、时代、介绍等；文物对应的详情页面的URL；文物图片（原图，爬取请注意检查，部分网站可能需要手动解析原图地址）；原图下载链接。    
  需要提交一个说明文档，包括英文字段对应的中文说明，如time：文物时代。    
  C.数据爬取网站，根据助教老师后续安排。  
  
5|	香港中文大学中国文化研究所	|https://lingnancrf.ics.cuhk.edu.hk/ancient-books|
6| 上海博物馆	|https://www.shanghaimuseum.net/mu/frontend/pg/lib1/index|
7|	俄国艾尔米塔什博物馆	|https://hermitagemuseum.org/wps/portal/hermitage/explore/artworks/?lng=zh|
8|	国立东方艺术博物馆（都灵）	|https://www.maotorino.it/en/collections/online-catalogue/?src=&portal=mao&catalog_collection=131#filters-1|
  2）数据建模：将爬取的数据转化为三元组形式。   
  3）数据补充：根据需要从互联网爬取数据，对现有数据进行补充，如相关数据的基础信息缺失，需要从其他来源进行爬取或人工补充。例如，从百度百科下载数据，补充现有数据，如书画作家信息等。  
  4）数据存储：将根据步骤2中建模好的三元组数据保存到Virtuoso或Neo4j图数据库中，发布成链接开放数据（选做），可用于关系图谱、时间轴等知识图谱可视化、问答等功能开发；全部数据（用户数据和文物数据等）需要保存到数据库（mysql或其他数据库）中。  

前期风险预测与解决
-----------------
  1、其他小组需要的数据需求未提前协商，可能导致后期反复修改数据库：提前与各小组沟通，先进行部分网站的爬取同时收集其他小组的数据需求。  
  2、小组成员水平不统一，大部分成员都是首次进行知识图谱的构建：需要先进行针对性的学习，后期开会过程中不断沟通与调整，对较艰难的任务可以重新增加人手共同协作进行。  

项目分工
-----------
  成员姓名	     成员分工
  李思琪（组长）	负责爬虫构建、数据补充、文档撰写与审核、PPT制作、视频制作、代码仓库的上传、会议纪要  
  黄家慧	        负责爬虫构建、数据补充、文档撰写、会议纪要  
  王彦鑫	        负责爬虫构建、数据补充、文档撰写、会议纪要  
  黄振雨	        负责数据建模、文档撰写、会议纪要  
  江媛            负责图数据库的存储、文档撰写、会议纪要  
  张时祺          负责MYSQL数据库的存储、文档撰写、会议纪要  

初步技术选型
-------------
* 数据爬取：Python、Java  

* 数据建模：python 

* 服务器：阿里云服务器

* 数据库工具：MySQL

* 知识图谱构建与可视化：Neo4j

组内时间规划
------------
  时间	项目进度计划 
  第六周  项目整体分组、小组任务分配、组内任务分工  
  第七周  撰写小组对应部分的需求规格说明初稿、组员进行所需知识的学习、设计MySQL数据库结构   
  第八周	撰写小组对应部分的设计报告初稿、进行对网站本文数据和图片数据的爬取   
  第九周	对爬取到的数据进行数据清洗，更改为确定的格式，剔除不需要的数据   
  第十周	将文本数据转化为三元组形式，并完成数据建模  
  第十一周	将三元组数据存储到Neo4j图数据库中，构建海外文物知识图谱  
  第十二周	整合汇总上述内容、准备子系统运行检查  
  第十三周	进行总结汇报演讲  
  第十四周    系统集成后的运行检查  

项目推进计划
------------
  会议周期：每周进行一次会议（根据具体情况确定会议具体形式），根据组内时间规划确定会议主题，由组长进行详细的会议记录，并在会议结束后将会议记录整理上传。  
