package BookDemo;

public class datas {
	/**ͼ����Ϣ�Ĳֿ�*/
	public static book[] bookdatas=new book[999];
	//ʹ�þ�̬��Ϊ�ֿ���������鼮��Ϣ,�Ա����
	//��������ʵ������ִ�е����ȼ���
	static {
		book newbook1=new book();
		newbook1.setBookId("10001");
		newbook1.setBookName("<<�߿���Я���Ȿ �����>>");
		newbook1.setIsbn("9787313128584");
		newbook1.setCount(1000);
		newbook1.setPrice(49.00);
		bookdatas[0]=newbook1;
		
		book newbook2=new book();
		newbook2.setBookId("10002");
		newbook2.setBookName("<<��ҹ��>>");
		newbook2.setIsbn("9787544291163");
		newbook2.setCount(88);
		newbook2.setPrice(59.60);
		bookdatas[1]=newbook2;
		
		book newbook3=new book();
		newbook3.setBookId("10003");
		newbook3.setBookName("<<����־>>");
		newbook3.setIsbn("9787550614581");
		newbook3.setCount(500);
		newbook3.setPrice(28.00);
		bookdatas[2]=newbook3;
	}
}
