package ainterview.question;

public class LinkedLists<E> {

	transient Node<E> first;
    transient Node<E> last;

    public static void main(String[] args) {
    	LinkedLists lili = new LinkedLists();
    	lili.add(3);
    	lili.add(4);
    	
	}
    
    public boolean add(E e) {
        System.out.println(" Added value " + e);
        System.out.println(" Node first value " + first);
        System.out.println(" Node last value " + last);
        linkLast(e);
        return true;
    }
   
     
	 void linkLast(E e) {
		   	System.out.println(" linklast Node first value " + first);
	        System.out.println(" linklast Node last value " + last);
	        final Node<E> l = last;
	        System.out.println(" linklast Node L value " + l);
	        
	        final Node<E> newNode = new Node<>(l, e, null);
	        last = newNode;
	        if (l == null)
	            first = newNode;
	        else
	            l.next = newNode;
	        }
	 
	 private static class Node<E> {
	        E item;
	        Node<E> next;
	        Node<E> prev;

	        Node(Node<E> prev, E element, Node<E> next) {
	            this.item = element;
	            this.next = next;
	            this.prev = prev;
	        }
	    }

	
}
