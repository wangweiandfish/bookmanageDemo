package BookDemo;

import java.io.IOException;

public class Test {

	public static void show()
	{
		bookBiz biz=new bookBiz();
		
		if(biz.getbookvariety()<=0)
		{
			System.out.println("图书仓库是空的!");
			return;
		}
		for(int i=0;i<biz.getbookvariety();i++)
		{
			System.out.println(datas.bookdatas[i].getBookId()+"\t"+datas.bookdatas[i].getBookName()+"\t"+datas.bookdatas[i].getCount());
		}
	}
	
public static void main(String[] args) {
//	book book=new book();
//	bookBiz biz=new bookBiz();
//	book.setBookId("011");
//	book.setBookName("白夜行");
//	book.setCount(10);
//	biz.addBook(book);
//	biz.instore("011", 39);
//	show();
////	biz.delboook(book);
////	show();
//	bookView view =new bookView();

	//new bookView();
//abstractBookview bookview =new BookviewConsoleImpl();
	//FileUtil file=new FileUtil();
	//FileUtil.runSavaBook(datas.bookdatas);
	FileUtil.runLoadBook();
//	int count;
//	try {
//		count = new bookBiz().getbookvariety(FileUtil.loadBook());
//		System.out.println(count);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//bookview.domainview();

}
}
