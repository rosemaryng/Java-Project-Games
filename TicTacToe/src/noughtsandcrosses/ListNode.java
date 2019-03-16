package noughtsandcrosses;

public class ListNode<T>{
	private T item;
	private ListNode<T> next;
	
	public ListNode(T newItem, ListNode<T> newNode) {
		this.item = newItem;
		this.next = newNode;
	}
	
	public ListNode(T newItem) {
		this.item = newItem;
		this.next = null;
	}
	
	public T getItem() {
		return item;
	}
	
	public ListNode<T> getNext() {
		return next;
	}
	
	public void setItem(T newItem) {
		item = newItem;
	}
	
	public void setNext(ListNode<T> newNode) {
		next = newNode;
	}
}
