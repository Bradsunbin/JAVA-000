学习笔记


gc：观察

	针对GCLogAnalysis的复现，在本地笔记本上的测试：-Xmx:512m -Xms512m
	生成对象数：
		java8: CMS >  Parallel > serial
		java11: G1 > Parallel
	表现运行多次 cms > paralle 
	原因：
	1、 单线程并没有存在因并发gc而产生与java线程的cpu资源竞争。
	2、 cms 并发充分利用了系统资源，减少了gc停顿时间。

gateway-server:  
	实验环境 cpu : 2c4t; java 8 ,20并发，30s -Xmx:1g -Xms:1g
	表现：g1 约等于 parallel > cms
	原因：
		本机环境，20并发，gc与java线程竞争cpu资源，所以平均表现上 parallel 略大于 cms
		java8 g1还不够完善（猜测） 所以没有优于 parallel的表现
	

