public class Solicitud {
    private String tienda;
    private String marca; 
    public String getmarca(){
            return marca;
    }
    public String gettienda(){
        return  tienda;
}
    public Solicitud(String m, String t) {
        marca = m;
        tienda = t;
    }
}
