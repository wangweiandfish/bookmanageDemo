package BookDemo;
/**
 * ͼ��ʵ����
 * @author DELL2017
 *
 */
public class book {
	private String bookId;  //ͼ����
	private String bookName;//ͼ������
	private String isbn;    //�����
	private String type; //ͼ������
	private String author;//����
	private String publisher;//������
	private int count ; //���
	private double price; //ͼ��۸�
	
	book(){
		
	}
	/**
	 * ��д��ͼ������equals�ķ���
	 */
	@Override
	public boolean equals(Object obj) {
		//��������objΪ�ջ�obj������book���ʵ�����򷵻�false
		if(obj==null || !(obj instanceof book))
		{
			return false;
		}
		book book=(book)obj;//��objת��Ϊbook����
		return bookId.equals(book.getBookId()); 
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
