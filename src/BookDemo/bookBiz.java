package BookDemo;
/**
 * ͼ��ҵ����
 * @author DELL2017
 *
 */
public class bookBiz {
		//����ͼ�飬���⣬��⣬��ѯ������ 
	/**
	 * ���ͼ��ֿ�datas.bookdatas������ͼ�����ĸ���(����)
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
	
	//bookvariety����������
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
	 * ���ͼ��
	 * @param book
	 * @return ����ֿ������򷵻�false��������ӵ�ͼ��ֿ���(datas.bookdatas),������true
	 */
	public boolean addBook(book book)
	{
		int getcount=datas.bookdatas.length;//�õ���ͼ�������
		for(int i=0;i<getcount;i++)
		{
			if(book.equals(datas.bookdatas[i]))//������==����Ϊid��string��
			{
				return false;
			}
		}//����ֿ������д��飬�򷵻�false
		
		if(getbookvariety()==getcount) return false;
		datas.bookdatas[getbookvariety()]=book;
		return true;
		
	}
	/**
	 * ɾ��ͼ��
	 * @param book
	 * @return
	 */
	public boolean delboook(book book)
	{
		int delIndex=-1;
		int getcount=getbookvariety();//ͼ�������
		for(int i=0;i<getcount;i++)
		{
			if(book.equals(datas.bookdatas[i]))
			{
				delIndex=i; //Ѱ�ҵ����¼�±�
				break;
			}
		}
		if(delIndex==-1)
		{
			System.out.println("�ֿ��в�δ�д���!");
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
	 * ͨ��ͼ��id������ͼ��
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
	 * ͼ��������(�����˲��ҹ���findbyid)
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
	 * ͼ��������
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
