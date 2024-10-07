interface Queue{
	public void add(Object obj);
	public Object first();
	public Object remove();
	public int size();

}
public class LinkedQueue implements Queue{
	private static class Node{
		Object data;
		Node next=this, prev=this;
		
		Node(Object data){
			this.data=data;
		}
		
		Node(Object data, Node prev, Node next){
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
		
	} 	
	private int size;
	private Node head=new Node(null);
	
	public int size(){
		return size;
	}
	
	public Object first(){
		if(size==0) throw new IllegalStateException("Empty");
		return head.next.data;
	}
	
	public Object remove(){
		if(size==0) throw new IllegalStateException("Empty");
		Object temp=head.next.data;
		head.next=head.next.next;
		head.next.prev=head;
		--size;
		return temp;
	}
	
	public void add(Object data){
		head.prev.next=new Node(data, head.prev, head);
		head.prev=head.prev.next;
		++size;
	}

	public Object sum(){
		int sum=0;
		for(Node p=head.next; p!=head; p=p.next ){
			sum+=(int)p.data;
		}
		return sum;
	}
	
	public void toArray(int size){
		int arr[]= new int[size];
		int i=0;
		for(Node p=head.next; p!=head; p=p.next ){
			arr[i]=(int)p.data;
			i++;
		}
		System.out.println("Converted into array ");
	}
	
	public String toString(){
		String str="";
		for(Node p=head.next; p!=head; p=p.next ){
			str+=p.data+" ";
		}
		return str;
	}
	
	public LinkedQueue clone(){
		LinkedQueue lq1=new LinkedQueue();
		
		for(Node p=head.next; p!=head; p=p.next){
			lq1.add(p.data);
		}
		System.out.println("cloned");
		return lq1;
	}
	
	public Object secondLast(){
		if(size==0) throw new IllegalStateException("Empty");
		return head.prev.prev.data;
	}
	
	public Object secondElement(){
		if(size==0) throw new IllegalStateException("Empty");
		return head.next.next.data;
	}
	
	public boolean equals(LinkedQueue lq1, LinkedQueue lq2){
		
		if(lq1.size()!=lq2.size()){
			return false;
		}else{
		for(Node p1=lq1.head.next, p2=lq2.head.next; p1!=head; p1=p1.next, p2=p2.next){
				if(p1.data!=p2.data){
					System.out.println("Loop");
					return false;
				}
			}	
		}
		return true;
	}

	public static void main(String arg[]){
		LinkedQueue lq=new LinkedQueue();
		lq.add(10);
		lq.add(50);
		lq.add(80);
		lq.add(120);
		//System.out.println(lq.remove());
		System.out.println(lq.first());
		System.out.println("Sum is "+lq.sum());
		lq.toArray(lq.size());
		System.out.println("String is "+lq.toString());
		System.out.println("Second last element "+lq.secondLast());
		System.out.println("Second element "+lq.secondElement());
		LinkedQueue clone=lq.clone();
		System.out.println("original Second element "+lq.secondElement());
		System.out.println("clone Second element "+clone.secondElement());
	
	
		LinkedQueue lq2=new LinkedQueue();
		lq2.add(10);
		lq2.add(50);
		lq2.add(80);
		lq2.add(120);
		System.out.println("Equal state:"+lq.equals(lq,lq2));
		System.out.println("Equal state:"+lq2.remove());
	
	}
} 


/*	convert linkedlist queue into array queue
	firt element= head.next
	head is dummy 
	last element= head.prev
	second element= head.next.next
	second last element = head.prev.prev
*/
