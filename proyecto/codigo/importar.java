import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class importar {

private ArrayList<String[]> datos = new ArrayList<>();

public importar(String ruta){
BufferedReader lector = null;
try {
 lector = new BufferedReader(new FileReader(ruta));
String line = lector.readLine();
int i = 0;
while(line != null){
    String[] j = line.split(";");
    datos.add(i, j);
    ++i;
   line =  lector.readLine();
}
} catch (Exception FileNotFoundException) {
        System.out.println(FileNotFoundException.getMessage());
    }    
finally{
try {
    lector.close();
} catch (Exception IOException ) {
    System.out.println(IOException.getMessage());
        }
   
    }

}

public String valorString(int columna, int fila){
String [] h = datos.get(fila);
return h[columna];
}

public static void main(String[] args) {
    importar b = new importar("4.csv");
    System.out.println(b.valorString(18,999));
}

}
