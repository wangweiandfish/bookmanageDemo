package BookDemo;
/**
 * 文件工具类（包含对文件的读写静态方法）
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
	/**
	 * 从文件中读取内容，再重新整合成对象数组输出
	 * @return
	 * @throws IOException 
	 */
	public static book[] loadBook() throws IOException {
		file=new File(FilePath);
		BufferedReader reader=new BufferedReader(new FileReader(file));//带缓存区的reader（按字符读取）
		String readline=null;//用来接收读取的每一行（每一类书）
		
		int count=0;
		while((readline=reader.readLine())!=null)//字符型readline用来接收从文件中读取的内容当读取内容不为空时
		{
			book book =new book();//实例化book类来接收str型数组的内容
			String[] strline=readline.split(sepAttr);//将读取的一行用分割符进行分离，返回分隔后的字符数组
			book.setBookId(strline[0].trim());//注解trim():去掉两边的空格
			book.setBookName(strline[1].trim());
			book.setCount(Integer.parseInt(strline[2].trim()));//图书价格
			datas.bookdatas[count++]=book;
			
			
			}
		reader.close();
		return datas.bookdatas;
		}
	
//	public static void runLoadBook() //运行加载（利用GUI图形编程）
//	{
//		JFrame frame=new JFrame("图书仓库");
//		frame.setSize(800, 900);//宽和高
//		int count=0;
//		try {
//			book[] showbook=loadBook();
//			count = bookbiz.getbookvariety(showbook);
//			// 创建一个网格布局管理器实例grid，表格为3*count
//			GridLayout grid=new GridLayout(3, count);
//			// 设置frame的页面布局为grid
//			frame.setLayout(grid);
//			/// 定义一个JButton的数组b，数组长度为3*count
//			JButton[] bu=new JButton[3*count];
//			int bookcount=0;//用来计算读取到哪本书了
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
//		}//设置多少行
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

	
	
		
		
	

	

