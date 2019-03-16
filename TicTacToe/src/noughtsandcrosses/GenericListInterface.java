package noughtsandcrosses;

public interface GenericListInterface<T> extends Iterable<T>{

	
	public int size();

	
	public boolean isEmpty();

	
	public T get(int index) throws ListIndexOutOfBoundsException;

	
	public void add(int index, T newItem) throws ListIndexOutOfBoundsException;


	public void remove(int index) throws ListIndexOutOfBoundsException;
	
	
	public void clear();
	
	
	public void display();


}
