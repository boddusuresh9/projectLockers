package projectP1;

public class file {
	class Node{
		String str;
		Node next;
		
		public Node(String str1) {
			this.str = str1;
			this.next = null;
		}
	}
    String Path="c\\Lockers"; 
	private  Node head = null;
	private  Node tail = null;
	
	public void addFile(String data)
    {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
	
	void deleteFile(String key)
    {
        Node temp = head;
        Node previousNode = null;
 
        if (temp != null && temp.str == key) {
            head = temp.next; // Changed head
            return;
        }
        
        while (temp != null && temp.str != key) {
            previousNode = temp;
            temp = temp.next;
        }
  
        if (temp == null)
            return;
       
        previousNode.next = temp.next;
    }

	public void displayList() {
		Node current = head;

		if(current == null) {
			System.out.println("No files to display");
			return;
		}
		while(current != null) {
			System.out.println(current.str + " ");
			current = current.next;
		}
		System.out.println();
	}
	public void sortList()
    {
        Node current = head, index = null;
 
        String temp;
 
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.str.compareTo(index.str)>0) {
                        temp = current.str;
                        current.str = index.str;
                        index.str = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
