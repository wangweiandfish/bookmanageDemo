package BookDemo;

import java.util.Scanner;

public abstract class abstractBookview {
	//private static String libraryName="XXͼ�����ϵͳ";
//	 private bookBiz bookbiz;
//	 private Scanner in;
	 /**
	  * ��ʼ��ͼ����ͼ��
	  */
	 public abstractBookview()
	 {
		 //�޲ι����ʼ��
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
	  * ���˵���ͼ��
	  * @return �����û�ѡ��Ĳ˵��1-7֮�䣩
	  *
	  */
	 public abstract String showMainView();
	 
	
	 /**
	  * ����ͼ��
	  * @return
	  */
	 public abstract book showaddBookView();
	 /**
	  * ɾ��ͼ����ͼ��
	  * @return
	  */
	 public abstract book showdelBookView();
	 
	 
	 /**
	  * չʾ�����ͼ����Ϣ
	  * @param booksarray
	  */
	 public abstract void showbooks(book ...booksarray);
	
	 /**
	  * ����Ų���ͼ��
	  */
	 public abstract void showfindbookid();
	 
	 /**
	  * ͼ��������
	  */
	 public abstract void showInstore();
	
	 public abstract void showOutstore();
}
	 
