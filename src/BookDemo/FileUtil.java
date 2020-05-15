package BookDemo;
/**
 * �ļ������ࣨ�������ļ��Ķ�д��̬������
 * @author DELL2017
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	
}
