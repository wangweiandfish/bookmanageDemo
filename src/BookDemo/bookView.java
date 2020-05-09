package BookDemo;

import java.util.Scanner;

public class bookView {
 private static String libraryName="XX图书管理系统";
 private bookBiz bookbiz;
 private Scanner in;
 /**
  * 初始化图书视图层
  */
 bookView()
 {
	 //无参构造初始化
	 bookbiz=new bookBiz();
	 in=new Scanner(System.in);
	 System.out.println("**********************");
	 System.out.println("欢迎使用"+libraryName);
	 System.out.println("1.登录");
	 System.out.println("2.退出");
	 System.out.println("**********************");
	 String choice=in.next();
	 if(choice.equals("1"))
	 {
		 //成功登录，初始化打印主菜单
		 
			 while(showMainView()) {
				 //showbooks(datas.bookdatas);
			 };//
			 
		 
		 
	 }
	 System.out.println("成功退出,欢迎下次再来!");
 }
 /**
  * 主菜单视图层
  * @return false则退出，true则循环
  *
  */
 public boolean showMainView()
 {
	 System.out.println("\n"+libraryName+">>主菜单");
	 System.out.println("1.新增图书\t2.删除图书\t3.查看所有图书\t4按编号查询\t5入库\t6出库\t退出");
	 String choice=in.next();
	 switch (choice) {
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
	
	return false;
	
	default:
		break;
	}
	 return true;
 }
 /**
  * 新增图书
  * @return
  */
 public book showaddBookView()
 {
	 System.out.println("\n"+libraryName+">>新增图书");
	 System.out.print("图书编号:");
	 String bookID=in.next();
	 book book=bookbiz.findById(bookID);
	 if(book==null)
	 {
		 book=new book();//重新构造
		 book.setBookId(bookID);
		 System.out.println("图书名称:");
		 book.setBookName(in.next());
		 System.out.println("图书入库量");
		 book.setCount(in.nextInt());
		 new bookBiz().addBook(book);
		 
	 }else {
		 //存在
		 System.out.println("该图书编号已存在");
		 System.out.println("且该图书名称为:"+book.getBookName());
		 book=showaddBookView();//递归调用
	 }
	 return book;
 }
 /**
  * 删除图书视图层
  * @return
  */
 public book showdelBookView()
 {
	 System.out.println("\n"+libraryName+">>删减图书");
	 System.out.print("图书编号:");
	 String bookID=in.next();
	 book book=bookbiz.findById(bookID);
	 if(book==null)
	 {
		 System.out.println("查无此书!");
		 book=showdelBookView();
	 }else {
		 if(bookbiz.delboook(book))
		 {
			 System.out.println("删除成功!");
			 
		 }else {
			 System.out.println("删除失败!");
		 }
		 
		 
	 }
	 return book;
 }
 
 /**
  * 展示输入的图书信息
  * @param booksarray
  */
 public void showbooks(book ...booksarray)
 {
	 System.out.println("编号\t\t图书名称\t\t\t\t\t库存");
	 if(booksarray==null)
	 {
		 booksarray=datas.bookdatas;
	 }
	 int count=bookbiz.getbookvariety(booksarray);
	 for(int i=0;i<count;i++)
	 {
		 System.out.printf("%-8s\t%-30s\t%-5d\n",booksarray[i].getBookId(),booksarray[i].getBookName(),booksarray[i].getCount());
	 }
 }
 /**
  * 按编号查找图书
  */
 public void showfindbookid()
 {
	 
	 System.out.println("\n"+libraryName+">>按编号查询图书");
	 String bookId=in.next();
	 book book=bookbiz.findById(bookId);
	 if(book==null)
	 {
		 System.out.println("查无此书,请确认编号后重新输入");
		 showfindbookid();
	 }
	 showbooks(book);
	 return;
 }
 /**
  * 图书入库操作
  */
 public void showInstore()
 {
	 System.out.println("\n"+libraryName+">>图书入库");
	 System.out.println("请输入入库的图书编号:");
	 String bookId=in.next();
	 book book=bookbiz.findById(bookId);
	 if(book==null)
	 {
		 System.err.println("并未找到此书!");
		 showInstore();
	 }
	 System.out.print("该图书名称为:");
	 System.out.println(book.getBookName());
	 System.out.print("请输入入库的数量:");
	 int addcount=in.nextInt();
	 bookbiz.instore(bookId, addcount);
	 //book.setCount(book.getCount()+addcount);
	 //System.out.println("入库成功!");
	 return;
 }
 public void showOutstore()
 {
	 System.out.println("\n"+libraryName+">>图书出库");
	 System.out.println("请输入出库的图书编号:");
	 String bookId=in.next();
//	 book book=bookbiz.findById(bookId);
//	 if(book==null)
//	 {
//		 System.err.println("并未找到此书!");
//		 showOutstore();
//	 }
	 //System.out.print("该图书名称为:");
	 //System.out.println(book.getBookName());
	 System.out.print("请输入出库的数量:");
	 int outcount=in.nextInt();
	 if(bookbiz.outstore(bookId, outcount))
	 {
		 return;
	 }else {
		 System.out.println("并未有此图书或出库数量越界!!!");
		 showOutstore();
	 }
		 
	 
 }
}
