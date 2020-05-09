package BookDemo;
/**
 * 图书实体类
 * @author DELL2017
 *
 */
public class book {
	private String bookId;  //图书编号
	private String bookName;//图书名称
	private String isbn;    //出版号
	private String type; //图书类型
	private String author;//作者
	private String publisher;//出版社
	private int count ; //库存
	private double price; //图书价格
	
	book(){
		
	}
	/**
	 * 重写了图书对象的equals的方法
	 */
	@Override
	public boolean equals(Object obj) {
		//如果传入的obj为空或obj不属于book类的实例，则返回false
		if(obj==null || !(obj instanceof book))
		{
			return false;
		}
		book book=(book)obj;//将obj转换为book类型
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
