package java_chobo02_ch12;

import java.util.ArrayList;

public class Box<T> {

//	private ArrayList<T> list = new ArrayList<T>();
	private ArrayList<T> list;   //위 내용과 같은 내용.생성자에 추가하면
	
	public Box() {
		list = new ArrayList<T>();
		}
	public void add(T item) {
		list.add(item);
	}
	public T get(int idx) {
		return list.get(idx);
		
	}
	public ArrayList<T> getList() {
		return list;
	}
	public int size() {
		return list.size();
	}
	@Override
	public String toString() {
		return String.format("Box [%s]", list);
	}
	
}
