public class Punto11Node {
    public int Id;
    public int X;
    public int Y;
    public String nombre;    
    public Punto11Node next;

    public Punto11Node(int id, int x , int y , String nombre){
        next = null;
        Id = id;
        X = x;
        Y = y;
        this.nombre = nombre;
        
    }
    public Punto11Node(int id, int x , int y){
        next = null;
        Id = id;
        X = x;
        Y = y;
        nombre = null;        
        
    }
}
