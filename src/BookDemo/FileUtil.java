package BookDemo;
/**
 * �ļ������ࣨ�������ļ��Ķ�д��̬������
 * @author DELL2017
 *
 */

import java.awt.GridLayout;
//import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileUtil {
/**�ļ�·�� */
	private static final String FilePath="src/BookDemo/fileData";
	/**���ŷָ��**/
	private static final String sepAttr=",";
	/**���зָ��**/
	private static final String sepLine=System.getProperty("line.separator");
	static bookBiz bookbiz=null;//bookbizʵ����
	//static FileWriter filewriter=null;
	
	static File file=null;
	private static BufferedWriter filewriter;
	
	/**
	 * д�����--���ǲ���1.0
	 * @param bookArray
	 * @throws IOException 
	 */
	public static boolean savaBook(book ...bookArray) throws IOException
	{
		
		if(bookArray==null) return false;
		file=new File(FilePath);//�ļ�ʵ��������������Ķ�д����
		bookbiz=new bookBiz();
		if(!file.exists())
		{
			file.createNewFile();
		}
		 filewriter = new BufferedWriter(new FileWriter(file,false));//false��׷��ֱ�Ӹ���
		int count=bookbiz.getbookvariety(bookArray);//���㴫������ͼ������
		StringBuffer content=new StringBuffer();
		/**ƴ�Ӵ������������ַ�**/
		for(int i=0;i<count;i++)
		{
			content.append(bookArray[i].getBookId());	content.append(sepAttr);
			content.append(bookArray[i].getBookName());	content.append(sepAttr);
			content.append(bookArray[i].getCount());	content.append(sepLine);
			
		}
		
		filewriter.write(content.toString());//д��
		return true;
		
	}
	public static void runSavaBook(book ...bookArray)
	{
		try {
			if(savaBook(bookArray))
			{
				
				JOptionPane.showMessageDialog(null, "¼��ͼ��ɹ�");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ���ļ��ж�ȡ���ݣ����������ϳɶ����������
	 * @return
	 * @throws IOException 
	 */
	public static book[] loadBook() throws IOException {
		file=new File(FilePath);
		BufferedReader reader=new BufferedReader(new FileReader(file));//����������reader�����ַ���ȡ��
		String readline=null;//�������ն�ȡ��ÿһ�У�ÿһ���飩
		
		int count=0;
		while((readline=reader.readLine())!=null)//�ַ���readline�������մ��ļ��ж�ȡ�����ݵ���ȡ���ݲ�Ϊ��ʱ
		{
			book book =new book();//ʵ����book��������str�����������
			String[] strline=readline.split(sepAttr);//����ȡ��һ���÷ָ�����з��룬���طָ�����ַ�����
			book.setBookId(strline[0].trim());//ע��trim():ȥ�����ߵĿո�
			book.setBookName(strline[1].trim());
			book.setCount(Integer.parseInt(strline[2].trim()));//ͼ��۸�
			datas.bookdatas[count++]=book;
			
			
			}
		reader.close();
		return datas.bookdatas;
		}
	
//	public static void runLoadBook() //���м��أ�����GUIͼ�α�̣�
//	{
//		JFrame frame=new JFrame("ͼ��ֿ�");
//		frame.setSize(800, 900);//��͸�
//		int count=0;
//		try {
//			book[] showbook=loadBook();
//			count = bookbiz.getbookvariety(showbook);
//			// ����һ�����񲼾ֹ�����ʵ��grid�����Ϊ3*count
//			GridLayout grid=new GridLayout(3, count);
//			// ����frame��ҳ�沼��Ϊgrid
//			frame.setLayout(grid);
//			/// ����һ��JButton������b�����鳤��Ϊ3*count
//			JButton[] bu=new JButton[3*count];
//			int bookcount=0;//���������ȡ���ı�����
//			
//			for(int i=0;i<count;i+=3)
//			{
//				
//				
//					bu[i]=new JButton(showbook[bookcount].getBookId());
//				
//				
//					bu[i+1]=new JButton(showbook[bookcount].getBookName());
//				
//				
//					bu[i+2]=new JButton(Integer.toString(showbook[bookcount].getCount()));
//				
//				frame.add(bu[i]);
//				frame.add(bu[i+1]);
//				frame.add(bu[i+2]);
//				
//			}
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setVisible(true);
//		} catch (IOException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}//���ö�����
//		
//			
//		}
public static void runLoadBook()
{
	try {
		book[] showbook=loadBook(); 
		for(int i=0;i<showbook.length;i++)
		{
			if(showbook[i]==null)
			{
				break;
			}
			System.out.println(showbook[i].getBookId()+"\t"+showbook[i].getBookName());
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}






}

	
	
		
		
	

	

