package n.genaric;

public class Box<T> {
	private T[] obArr;
	private int size;
	public Box(T[] obArr, int siz0e) {
		super();
		this.obArr = obArr;
		this.size = siz0e;
	}
	public Box() {
		super();
	}
	public T[] getObArr() {
		return obArr;
	}
	public void setObArr(T[] obArr) {
		this.obArr = obArr;
	}
	public int getSiz0e() {
		return size;
	}
	public void setSiz0e(int siz0e) {
		this.size = size;
	}
	
	
	
}
