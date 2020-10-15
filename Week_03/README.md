2020/10/15 学习笔记

递归

	四个结构模块
	1.终止条件
	2.处理当前逻辑
	3.下探到下一层
	4.清理当前层
	
	思维要点
	1.不要人肉递归
	2.找到最近重复子问题
	3.数学归纳法思维
	
代码模板

	// Java
	public void recur(int level, int param) { 
	  // terminator 
	  if (level > MAX_LEVEL) { 
	    // process result 
	    return; 
	  }
	  // process current logic 
	  process(level, param); 
	  // drill down 
	  recur( level: level + 1, newParam); 
	  // restore current status 
	 
	}

