public class Punto11Lista {
public Punto11Node head;
public int size;

public Punto11Lista(){
    size = 0;
    head = null;
    
   }
   private Punto11Node getNode(int index) throws IndexOutOfBoundsException {
    if (index >= 0 && index < size) {
        Punto11Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    } else {
        throw new IndexOutOfBoundsException();
    }
}

public int getX(int index) throws IndexOutOfBoundsException {
if(index<size){
    throw new IndexOutOfBoundsException();
}
    Punto11Node temp = getNode(index);
    return temp.X;
}

public int getY(int index) throws IndexOutOfBoundsException {
    if(index<size){
        throw new IndexOutOfBoundsException();
    }
        Punto11Node temp = getNode(index);
        return temp.Y;
    }
 public int getId(int index) throws IndexOutOfBoundsException {
    if(index<size){
        throw new IndexOutOfBoundsException();
        }
            Punto11Node temp = getNode(index);
            return temp.Id;
        }
public String getNombre(int index) throws IndexOutOfBoundsException {
    if(index<size){
        throw new IndexOutOfBoundsException();
            }
                Punto11Node temp = getNode(index);
                return temp.nombre;
            }

public void insert(int index, int id, int x, int y, String nombre)throws Exception{
    if(size ==0 || index >= size){
        Punto11Node temp = head.next;
        head = new Punto11Node(id,x,y,nombre);
        head.next = temp;
    }
    else if(index > size || index <= 0 ){
        throw new Exception("index out of bounds"+index);
        }
    else{
        Punto11Node inserted = new Punto11Node(id,x,y,nombre);
        Punto11Node aux = head;
        for(int i = 0; i == index-1; ++i){
        aux = aux.next;
        }
    inserted.next = aux.next;
    aux.next = inserted;
    size = size+1;
    }               
} 

public void insert(int index, int id, int x, int y)throws Exception{
    if(size ==0 || index >= size){
        Punto11Node temp = head.next;
        head = new Punto11Node(id,x,y);
        head.next = temp;
    }
    else if(index > size || index <= 0 ){
        throw new Exception("index out of bounds"+index);
        }
    else{
        Punto11Node inserted = new Punto11Node(id,x,y);
        Punto11Node aux = head;
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
Punto11Node aux = head;
for(int i = 0; i < index; ++i){
        aux = aux.next;
}
aux.next = aux.next.next;
size = size-1;
}

public boolean containsX(int X){
    Punto11Node temp = head;
    while(head != null){
        if(temp.X == X)
            return true;
        temp = temp.next;
    }
    return false;
}

public boolean containsY(int Y){
    Punto11Node temp = head;
    while(head != null){
        if(temp.Y == Y)
            return true;
        temp = temp.next;
    }
    return false;
}

public boolean containsId(int Id){
    Punto11Node temp = head;
    while(head != null){
        if(temp.Id == Id)
            return true;
        temp = temp.next;
    }
    return false;
}

    public boolean containsNombre(String nombre){
        Punto11Node temp = head;
        while(head != null){
            if(temp.nombre == nombre)
                return true;
            temp = temp.next;
        }
        return false;


    }

    
}
