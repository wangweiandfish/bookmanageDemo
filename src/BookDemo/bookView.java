package BookDemo;

import java.util.Scanner;

public class bookView {
 private static String libraryName="XXͼ�����ϵͳ";
 private bookBiz bookbiz;
 private Scanner in;
 /**
  * ��ʼ��ͼ����ͼ��
  */
 bookView()
 {
	 //�޲ι����ʼ��
	 bookbiz=new bookBiz();
	 in=new Scanner(System.in);
	 System.out.println("**********************");
	 System.out.println("��ӭʹ��"+libraryName);
	 System.out.println("1.��¼");
	 System.out.println("2.�˳�");
	 System.out.println("**********************");
	 String choice=in.next();
	 if(choice.equals("1"))
	 {
		 //�ɹ���¼����ʼ����ӡ���˵�
		 
			 while(showMainView()) {
				 //showbooks(datas.bookdatas);
			 };//
			 
		 
		 
	 }
	 System.out.println("�ɹ��˳�,��ӭ�´�����!");
 }
 /**
  * ���˵���ͼ��
  * @return false���˳���true��ѭ��
  *
  */
 public boolean showMainView()
 {
	 System.out.println("\n"+libraryName+">>���˵�");
	 System.out.println("1.����ͼ��\t2.ɾ��ͼ��\t3.�鿴����ͼ��\t4����Ų�ѯ\t5���\t6����\t�˳�");
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
  * ����ͼ��
  * @return
  */
 public book showaddBookView()
 {
	 System.out.println("\n"+libraryName+">>����ͼ��");
	 System.out.print("ͼ����:");
	 String bookID=in.next();
	 book book=bookbiz.findById(bookID);
	 if(book==null)
	 {
		 book=new book();//���¹���
		 book.setBookId(bookID);
		 System.out.println("ͼ������:");
		 book.setBookName(in.next());
		 System.out.println("ͼ�������");
		 book.setCount(in.nextInt());
		 new bookBiz().addBook(book);
		 
	 }else {
		 //����
		 System.out.println("��ͼ�����Ѵ���");
		 System.out.println("�Ҹ�ͼ������Ϊ:"+book.getBookName());
		 book=showaddBookView();//�ݹ����
	 }
	 return book;
 }
 /**
  * ɾ��ͼ����ͼ��
  * @return
  */
 public book showdelBookView()
 {
	 System.out.println("\n"+libraryName+">>ɾ��ͼ��");
	 System.out.print("ͼ����:");
	 String bookID=in.next();
	 book book=bookbiz.findById(bookID);
	 if(book==null)
	 {
		 System.out.println("���޴���!");
		 book=showdelBookView();
	 }else {
		 if(bookbiz.delboook(book))
		 {
			 System.out.println("ɾ���ɹ�!");
			 
		 }else {
			 System.out.println("ɾ��ʧ��!");
		 }
		 
		 
	 }
	 return book;
 }
 
 /**
  * չʾ�����ͼ����Ϣ
  * @param booksarray
  */
 public void showbooks(book ...booksarray)
 {
	 System.out.println("���\t\tͼ������\t\t\t\t\t���");
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
  * ����Ų���ͼ��
  */
 public void showfindbookid()
 {
	 
	 System.out.println("\n"+libraryName+">>����Ų�ѯͼ��");
	 String bookId=in.next();
	 book book=bookbiz.findById(bookId);
	 if(book==null)
	 {
		 System.out.println("���޴���,��ȷ�ϱ�ź���������");
		 showfindbookid();
	 }
	 showbooks(book);
	 return;
 }
 /**
  * ͼ��������
  */
 public void showInstore()
 {
	 System.out.println("\n"+libraryName+">>ͼ�����");
	 System.out.println("����������ͼ����:");
	 String bookId=in.next();
	 book book=bookbiz.findById(bookId);
	 if(book==null)
	 {
		 System.err.println("��δ�ҵ�����!");
		 showInstore();
	 }
	 System.out.print("��ͼ������Ϊ:");
	 System.out.println(book.getBookName());
	 System.out.print("��������������:");
	 int addcount=in.nextInt();
	 bookbiz.instore(bookId, addcount);
	 //book.setCount(book.getCount()+addcount);
	 //System.out.println("���ɹ�!");
	 return;
 }
 public void showOutstore()
 {
	 System.out.println("\n"+libraryName+">>ͼ�����");
	 System.out.println("����������ͼ����:");
	 String bookId=in.next();
//	 book book=bookbiz.findById(bookId);
//	 if(book==null)
//	 {
//		 System.err.println("��δ�ҵ�����!");
//		 showOutstore();
//	 }
	 //System.out.print("��ͼ������Ϊ:");
	 //System.out.println(book.getBookName());
	 System.out.print("��������������:");
	 int outcount=in.nextInt();
	 if(bookbiz.outstore(bookId, outcount))
	 {
		 return;
	 }else {
		 System.out.println("��δ�д�ͼ����������Խ��!!!");
		 showOutstore();
	 }
		 
	 
 }
}
