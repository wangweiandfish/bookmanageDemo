package BookDemo;
/**
 * 图书业务类
 * @author DELL2017
 *
 */
public class bookBiz {
		//增加图书，出库，入库，查询，排序 
	/**
	 * 获得图书仓库datas.bookdatas数组中图书对象的个数(种类)
	 */
	public int getbookvariety()
	{
		int count=0;
		for(book book : datas.bookdatas)
		{
			if(book==null) break;
			count++;
			
		}
		return count;
	}
	
	//bookvariety方法的重载
	public int getbookvariety(book ...bookArray)
	{
		int count=0;
		for(book book : bookArray)
		{
			if(book==null) break;
			count++;
			
		}
		return count;
	}
	/**
	 * 添加图书
	 * @param book
	 * @return 如果仓库已满则返回false，否则添加到图书仓库中(datas.bookdatas),并返回true
	 */
	public boolean addBook(book book)
	{
		int getcount=datas.bookdatas.length;//得到来图书的种类
		for(int i=0;i<getcount;i++)
		{
			if(book.equals(datas.bookdatas[i]))//不能用==，因为id是string型
			{
				return false;
			}
		}//如果仓库中已有此书，则返回false
		
		if(getbookvariety()==getcount) return false;
		datas.bookdatas[getbookvariety()]=book;
		return true;
		
	}
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
	public boolean delboook(book book)
	{
		int delIndex=-1;
		int getcount=getbookvariety();//图书的数量
		for(int i=0;i<getcount;i++)
		{
			if(book.equals(datas.bookdatas[i]))
			{
				delIndex=i; //寻找到后记录下标
				break;
			}
		}
		if(delIndex==-1)
		{
			System.out.println("仓库中并未有此书!");
			return false;
		}
		for(int i=delIndex;i<getcount;i++)
		{
			datas.bookdatas[i]=datas.bookdatas[i+1];
//			if(i==getcount-1)
//			{
//				datas.bookdatas[i]=null;
//			}
		}
		datas.bookdatas[getcount-1]=null;
		return true;
	}
	/**
	 * 通过图书id来查找图书
	 * @param bookId
	 * @return
	 */
	public book findById(String bookId)
	{
		int getcount=getbookvariety();
		for(int i=0;i<getcount;i++)
		{
			if(bookId.equals(datas.bookdatas[i].getBookId()))
			{
				return datas.bookdatas[i];
			}
		}
		return null;
	}
	/**
	 * 图书入库操作(用上了查找功能findbyid)
	 * @param bookId
	 * @param count
	 * @return
	 */
	public boolean instore(String bookId,int count)
	{
		book book=findById(bookId);
		if(book==null)
		{
			return false;
		}
		book.setCount(book.getCount()+count);
		return true;
	
		
	}
	/**
	 * 图书出库操作
	 * @param bookId
	 * @param count
	 * @return
	 */
	public boolean outstore(String bookId,int count)
	{
		book book=findById(bookId);
		if(book==null)
		{
			return false;
		}
		if(book.getCount()-count<0) {
			return false;
		}
		book.setCount(book.getCount()-count);
		return true;
	}
}
