public class Lista {
public Node head;
public int size;

public Lista(){
    size = 0;
    head = null;
    
   }
   private Node getNode(int index) throws IndexOutOfBoundsException {
    if (index >= 0 && index < size) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    } else {
        throw new IndexOutOfBoundsException();
    }
}

/**
 * Returns the element at the specified position in this list.
 * @param index - index of the element to return
 * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
 */
public int get(int index) throws IndexOutOfBoundsException {
if(index<size){
    throw new IndexOutOfBoundsException();
}
    Node temp = getNode(index);
    return temp.data;
}


public void insert(int index,int data)throws Exception{
    if(size ==0 || index >= size){
        Node temp = head.next;
        head = new Node(data);
        head.next = temp;
    }
else if(index > size || index <= 0 ){
    throw new Exception("index out of bounds"+index);
}


else{
    Node inserted = new Node(data) ;
    Node aux = head;
    for(int i = 0; i == index-1; ++i){
        aux = aux.next;
    }
    inserted.next = aux.next;
    aux.next = inserted;
    size = size+1;
    }               
}     
public int size(){
    return size;
}

public void remove(int index){
Node aux = head;
for(int i = 0; i < index; ++i){
        aux = aux.next;
}
aux.next = aux.next.next;
size = size-1;
}

public boolean contains(int data){
    Node temp = head;
    while(head != null){
        if(temp.data == data)
            return true;
        temp = temp.next;
    }
    return false;
}







    
}
