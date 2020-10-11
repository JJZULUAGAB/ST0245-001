
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class pasarDatos {
    /** 
    * Método que analiza la respuesta con mejor gini de cada una de las preguntas 
     * @param ruta El parámetro ruta es la ruta del archivo      * 
     *@return los arreglos con la pregunta, la respuesta con mejor gini y el gini
     */
    public static  ArrayList<String[]> PasarDatos(String ruta){    
        gini Gini = new gini(); 
        ArrayList<String[]> retorno = new ArrayList<String[]>();
        int [] datos = { 5,14,27,33,35,36,37,42,43,46,56,61,66,67,68,69,70,71,72,73,74,78};
           
        ArrayList<String[]> grupo = importar.Lector(ruta, datos);
        for(int i = 1; i<=12;++i){
            retorno.add(Gini.mejorRespuesta(grupo,i));
        }
        retorno.add(Gini.mejorRespuesta(grupo,21));
        retorno.add(Gini.mejorRango(grupo,0));
       for(int i = 13; i < 21; ++i){
        retorno.add(Gini.mejorRango(grupo,i));
       }
            

       return retorno;
    }
    /** 
    * Método toma los resultados del analisis gini de las preguntas y genera un archivo CSV con los resultados
     * @param rutaCSV El parámetro rutaCSV es la ruta en la cual desea que se cree el nuevo archivo CSV
     * @param rutaDataSet El parámetro rutaDataSet es la ruta en la cual se encuentran los datos
     *@return los arreglos con la pregunta, la respuesta con mejor gini y el gini
     */
    public static void crearArchivo(String rutaCSV,String rutaDataSet){
        try{
            File nuevo = new File(rutaCSV);
                    nuevo.createNewFile();
                    FileWriter fw = new FileWriter(nuevo);
                    BufferedWriter bw = new BufferedWriter(fw);                   
                    ArrayList<String[]> retorno = PasarDatos(rutaDataSet);
                    bw.write("pregunta;Dato;Gini;Mejor Analisis");
                    bw.newLine();
                    for(String[] k: retorno){
                        for(String l:k){
                            l = l.replace("0.","0,");
                            bw.write(l+";");
                            }
                            bw.newLine();
                    }
                      
                    
                    bw.close();
                
            } catch (Exception e) {
                e.getMessage();
            }

    }
    /** 
    * Método crea diferentes archivos de diferentes dataSets 
     * @param rutaCSV El parámetro rutaCSV es la ruta en la cual desea que se cree el nuevo archivo CSV
     * @param rutaDataSet El parámetro rutaDataSet es la ruta en la cual se encuentran los datos
     * @param archivos El parámetro archivos es el conjunto de nombres de los archivos a buscar (sin la extención)
     *@return los arreglos con la pregunta, la respuesta con mejor gini y el gini
     */
    public static void crearArchivos(String rutaCSV,String[]archivos,String rutaDataSet){
        for(String n:archivos){
            crearArchivo(rutaCSV+"Ginis de "+n+".csv",rutaDataSet+n+".csv");
            System.out.println("Terminó arhivo"+n);
        }

    } 
       
    }    

