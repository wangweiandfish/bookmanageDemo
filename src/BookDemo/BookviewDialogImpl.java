package BookDemo;

import java.util.Scanner;

/**
 * ʹ�öԻ�������ͼ�����ϵͳ
 * @author DELL2017
 *
 */
public class BookviewDialogImpl extends abstractBookview{
	private Scanner in;
	private static String libraryName="XXͼ�����ϵͳ";
	 private bookBiz bookbiz;
	public BookviewDialogImpl()
	{
		bookbiz=new bookBiz();
		in=new Scanner(System.in);
	}

	@Override
	public String showMainView() {
		
		return null;
	}

	@Override
	public book showaddBookView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public book showdelBookView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showbooks(book... booksarray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showfindbookid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showInstore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOutstore() {
		// TODO Auto-generated method stub
		
	}
	
}
