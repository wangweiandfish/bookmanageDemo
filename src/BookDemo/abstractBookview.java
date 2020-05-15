package BookDemo;

import java.util.Scanner;

public abstract class abstractBookview {
	//private static String libraryName="XX图书管理系统";
//	 private bookBiz bookbiz;
//	 private Scanner in;
	 /**
	  * 初始化图书视图层
	  */
	 public abstractBookview()
	 {
		 //无参构造初始化
//		 bookbiz=new bookBiz();
//		 in=new Scanner(System.in);
		 
	 }
	 public void domainview()
	 {
		 String result=showMainView();
		 switch (result) {
			case "1":
				showaddBookView();
				
				break;
 
		case "2":
				
				showdelBookView();
				
				break;
		case "3":
			showbooks(null);
			break;
		case "4":
			showfindbookid();
			break;
		case "5":
			showInstore();
			break;
		case "6":
			showOutstore();
			break;
		case "7":
			
			return;
			
			default:
				break;
		 
		 }
				if(result!="7")
				{
					domainview();
				}
	 
	 }
	 /**
	  * 主菜单视图层
	  * @return 返回用户选择的菜单项（1-7之间）
	  *
	  */
	 public abstract String showMainView();
	 
	
	 /**
	  * 新增图书
	  * @return
	  */
	 public abstract book showaddBookView();
	 /**
	  * 删除图书视图层
	  * @return
	  */
	 public abstract book showdelBookView();
	 
	 
	 /**
	  * 展示输入的图书信息
	  * @param booksarray
	  */
	 public abstract void showbooks(book ...booksarray);
	
	 /**
	  * 按编号查找图书
	  */
	 public abstract void showfindbookid();
	 
	 /**
	  * 图书入库操作
	  */
	 public abstract void showInstore();
	
	 public abstract void showOutstore();
}
	 
