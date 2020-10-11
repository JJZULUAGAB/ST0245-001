import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class importar {
    /** 
    * Método le los datos de un archivo csv 
     * @param ruta El parámetro ruta es la ruta del archivo 
     * *@param datos  El parámetro datos preguntas a tener en cuenta para leer el archivo  
     *@return el conjunto de datos a analizar con las preguntas a tener en cuenta 
     */
    
    public static ArrayList<String[]> Lector(String ruta, int [] datos){
        ArrayList<String[]> lista = new ArrayList<String[]>();

        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader(ruta));
            String line = lector.readLine();

            while(line != null){
                String [] dividido  = line.split(";");
                String [] agregado = new String[datos.length+1];
                int i = 0;
               
                if(dividido[0].equals("estu_consecutivo.1"))
                    agregado[i++] = "edad";
                else{
                    String edad = Integer.toString(edad(dividido[18],dividido[19]));
                    agregado[i++] = edad;
                }
                
                for(int e : datos){
                    agregado[i++] = dividido[e-1];
                }
                
                lista.add(agregado);

                line = lector.readLine(); 

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
        return lista;
    }
    /** 
    * Método le los datos de un archivo csv 
     * @param ruta El parámetro ruta es la ruta del archivo 
     *@return el conjunto de datos a analizar con las todas la preguntas preguntas 
     */
    public ArrayList<String[]> Lector(String ruta){
        ArrayList<String[]> lista = new ArrayList<String[]>();

        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader(ruta));
            String line = lector.readLine();

            while(line != null){
                lista.add(line.split(";"));                
                line = lector.readLine(); 

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
        return lista;
    }

    /** 
    * Método toma la fecha de nacimiento y el periodo en el cual presentó el examen y calcula la edad 
     * @param fecha El parámetro fecha es la fecha de nacimiento de la persona  
     * *@param periodo  El parámetro periodo es el perido en el cual realizó los ICFES   
     *@return la edad de la persona cuando realizo los ICFES 
     */
    private  static int edad(String fecha, String periodo){
        String [] Fseparada = fecha.split("/"); 
        fecha = Fseparada[2];
        periodo = periodo.substring(0,4);

        return Integer.parseInt(periodo)-Integer.parseInt(fecha);
    }

}
