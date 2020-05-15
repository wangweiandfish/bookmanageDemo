package BookDemo;
/**
 * 文件工具类（包含对文件的读写静态方法）
 * @author DELL2017
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileUtil {
/**文件路径 */
	private static final String FilePath="src/BookDemo/fileData";
	/**逗号分割符**/
	private static final String sepAttr=",";
	/**换行分割符**/
	private static final String sepLine=System.getProperty("line.separator");
	static bookBiz bookbiz=null;//bookbiz实例化
	//static FileWriter filewriter=null;
	
	static File file=null;
	private static BufferedWriter filewriter;
	
	/**
	 * 写入操作--覆盖操作1.0
	 * @param bookArray
	 * @throws IOException 
	 */
	public static boolean savaBook(book ...bookArray) throws IOException
	{
		
		if(bookArray==null) return false;
		file=new File(FilePath);//文件实例化，用来后面的读写操作
		bookbiz=new bookBiz();
		if(!file.exists())
		{
			file.createNewFile();
		}
		 filewriter = new BufferedWriter(new FileWriter(file,false));//false表不追加直接覆盖
		int count=bookbiz.getbookvariety(bookArray);//计算传进来的图书种类
		StringBuffer content=new StringBuffer();
		/**拼接传进来的所有字符**/
		for(int i=0;i<count;i++)
		{
			content.append(bookArray[i].getBookId());	content.append(sepAttr);
			content.append(bookArray[i].getBookName());	content.append(sepAttr);
			content.append(bookArray[i].getCount());	content.append(sepLine);
			
		}
		
		filewriter.write(content.toString());//写入
		return true;
		
	}
	public static void runSavaBook(book ...bookArray)
	{
		try {
			if(savaBook(bookArray))
			{
				
				JOptionPane.showMessageDialog(null, "录入图书成功");
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
