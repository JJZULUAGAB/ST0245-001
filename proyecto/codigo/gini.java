import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
/**

 * Esta clase contiene los metodos necesarios para obteneer el gini de diferentes datos
 * @author: Juan José Zuluaga and Juan José Wilches

 * @version: 13/11/2020

 */


public class gini {    
     static Hashtable<String,String> has = new Hashtable<String,String>();
     public static  void Gini(){
        for(String m : new String[]{"desemp_ingles","estu_tomo_cursopreparacion","desemp_ingles","fami_numlibros","estu_areareside","fami_estratovivienda.1","fami_pisoshogar","fami_tieneinternet.1","fami_tienecomputador.1","fami_tiene_nevera.1","fami_tiene_celular.1","estu_trabajaactualmente","cole_caracter","cole_jornada"}){
            has.put(m,"texto");
        }
        for(String m: new String[]{"punt_lenguaje","punt_matematicas","punt_biologia","punt_quimica","punt_fisica","punt_ciencias_sociales","punt_filosofia","punt_ingles","exito","edad"}){
        has.put(m,"numero");
        }
     }
     /**

     * Método que separa un conjunto de datos NO numéricos, en aquellos que cumplen con una condición de respuesta 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será la respuesta que dividirá el grupo de datos
     * @return Aquellas secciones de datos que cumplan con la condición

     */
    public static   ArrayList<String[]> separarTrue(int pregunta, String respuesta,ArrayList<String[]> grupo){
        
        ArrayList<String[]> retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  =1; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(datos[pregunta].equals(respuesta)){
                retorno.add(datos);
            }
        }
        return retorno;
    } 
    /**
    * Método que separa un conjunto de datos NO numéricos, en aquellos que no cumplen con una condición de respuesta 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será la respuesta que dividirá el grupo de datos
     * @return Aquellas secciones de datos que no cumplan con la condición

     */
    public static  ArrayList<String[]>  separarFlase(int pregunta, String respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  =1; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(!datos[pregunta].equals(respuesta)){
                retorno.add(grupo.get(i));
            }
        }
        return retorno;
    } 
    /**
    * Método que separa un conjunto de datos numéricos, en aquellos que se encunetran por debajo de un rango 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será el número a tomar en cuenta para el analisís
     * @return Aquellos elementos que se encuentren por debajo de la respuesta

     */
    public static   ArrayList<String[]>  separarMenor(int pregunta, float respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  =1 ; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(Float.parseFloat(datos[pregunta]) <  respuesta ) {
                retorno.add(grupo.get(i));
            }
        }
        return retorno;

    } 
    /**
    * Método que separa un conjunto de datos numéricos, en aquellos que se encunetran por debajo o iguales de un rango 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será el número a tomar en cuenta para el analisís
     * @return Aquellos elementos que se encuentren por debajo o son iguales de la respuesta

     */
    public  static ArrayList<String[]>  separarMenorIgual(int pregunta, float respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  =1 ; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(Float.parseFloat(datos[pregunta]) <=  respuesta ) {
                retorno.add(grupo.get(i));
            }
        }
        return retorno;

    } 
    /**
    * Método que separa un conjunto de datosnuméricos, en aquellos que se encunetran sobre  de un rango 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será el número a tomar en cuenta para el analisís
     * @return Aquellos elementos que se encuentren sobre de la respuesta

     */
    public  static ArrayList<String[]>  separarMayor(int pregunta, float respuesta, ArrayList<String[]>  grupo){
         ArrayList<String[]>  retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  = 1; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(Float.parseFloat(datos[pregunta]) > respuesta ) {
                retorno.add(grupo.get(i));
            }
        }
        return retorno;

    } 
    /**
    * Método que separa un conjunto de datos numéricos, en aquellos que se encunetran sobre un rango  o son iguales a él 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será el número a tomar en cuenta para el analisís
     * @return Aquellos elementos que se encuentren sobre la respuesta o son iguales a ella 

     */
    public static ArrayList<String[]>  separarMayorIgual(int pregunta, float respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
        retorno.add(grupo.get(0));
        for(int i  = 1; i<grupo.size();++i) {
            String [] datos = grupo.get(i);
            if(Float.parseFloat(datos[pregunta]) >= respuesta ) {
                retorno.add(grupo.get(i));
            }
        }
        return retorno;

    } 
    /**
    * Método que calcula el coeficiente gini de un conjunto de datos
     * @param lista El parámetro lista es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@return El coeficiente gini del conjunto de datos 

     */
    public static  float sacarGini(ArrayList<String[]>  lista){
        float P0 = 0;
        float P1 = 0;   
        for(int i = 0; i < lista.size(); ++i){
            String[] line = lista.get(i);
            if(line[lista.get(0).length-1].equals("1")){
                ++P1;
            }
            else
                ++P0;
        }
        P0 = P0/lista.size();
        P1 = P1/lista.size();    
        return 1-((P0*P0)+(P1*P1));

    }
    /**
    * Método que calcula el coeficiente gini el total de casos y los exitos o fallos 
     * @param P1 casos exitoso o fallos
     * @param total el total de elemntos en el nodo  
     *@return El coeficiente gini del conjunto de datos 

     */
    public static  float sacarGini(float P1, int total){
        float P0 = total-P1;   
        P0 = P0/total;
        P1 = P1/total;    
        return 1-((P0*P0)+(P1*P1));

    }
    /**
    * Método que calcula el gini ponderado de dos conjuntos uno que cumple un condición y otro que no
     * @param cumple El parámetro cumple es el conjunto de datos que cumple con la condición 
     * @param noCumple El parámetro noCumple es el conjunto de datos que no cumple con la condición   
     *@return El coeficiente gini del conjunto de datos 

     */
    public  static float calcularElGiniPonderado(ArrayList<String[]>  cumple,ArrayList<String[]>  noCumple){
         float elGiniDeCumple = sacarGini(cumple);
        float elGiniDeNoCumple = sacarGini(noCumple);
        float elGiniPonderado = (elGiniDeCumple*cumple.size() + 
                elGiniDeNoCumple*noCumple.size()) /  (cumple.size() + noCumple.size());
        return elGiniPonderado;
    }
    /**
    * Método que calcula el gini ponderado
     * @param elGiniDeCumple gini del nodo que cumple con la condición  
     * @param elGiniDeNoCumple  gini del nodo que no cumple con la condición
     * @param totalCumple total de elementos del nodo que cumple la condición 
     * @param totalNocumple total de elementos del nodo que no cumple la condición 
     *@return El coeficiente gini del conjunto de datos 

     */
    public  static float calcularElGiniPonderado( float elGiniDeCumple,float elGiniDeNoCumple,float totalCumple,float totalNocumple){
        float total = totalCumple + totalNocumple;
        float elGiniPonderado = (elGiniDeCumple*totalCumple + elGiniDeNoCumple*totalNocumple) /  (total);
        return elGiniPonderado;
    }

    /**
    * Método genera el conjunto de las respuestas con mejor gini  para  una pregunta con respuestas NO numéricas 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@return El arreglo con la pregunta que se analizó, la respuesta con mejor  gini y el gini  de la respuesta
     */

    
    public static  String[] mejorRespuesta(ArrayList<String[]> grupo, int pregunta){
        Hashtable<String,ArrayList<Integer>> tabla = new Hashtable<String,ArrayList<Integer>>();
        String seleccion = grupo.get(0)[pregunta];
        ArrayList<String> orden = new ArrayList<String>();
        float Mejorgini = 1;         
        String respuesta = "";
        ArrayList<Integer> entrante = new ArrayList<Integer>(); entrante.add(0);
        tabla.put("exito",entrante);
        for(int i = 1; i<grupo.size();i++){            
            String[] j = grupo.get(i);
            if(tabla.containsKey(j[pregunta])){
                if(j[j.length-1].equals("1")){
                    ArrayList<Integer> datos = tabla.get(j[pregunta]); 
                    datos.set(1,1+datos.get(1)); // counta los exitos   
                    datos.set(0,1+datos.get(0)); // cuenta el total filas con esta respuesta  
                    tabla.put(j[pregunta],datos);
                    ArrayList<Integer> Exito =  tabla.get("exito");
                    Exito.set(0,1+Exito.get(0));
                    tabla.put("exito",Exito);
                    
                }
                else{
                    ArrayList<Integer> datos = tabla.get(j[pregunta]);
                    datos.set(0,1+datos.get(0)); // cuenta el total filas con esta respuesta  
                    tabla.put(j[pregunta],datos);
                    
                }
                
            }
               
            else {
                if(j[j.length-1].equals("1")){    
                    ArrayList<Integer> exito  = tabla.get("exito");
                    ArrayList<Integer> inicio  = new ArrayList<>(2);inicio.add(1); inicio.add(1);                             
                    tabla.put(j[pregunta],inicio);
                    exito.set(0,1+exito.get(0));              
                    tabla.put("exito",exito);
                    
                }
                else{
                   ArrayList<Integer> inicio  = new ArrayList<>(1);inicio.add(1);inicio.add(0);                  
                    tabla.put(j[pregunta],inicio);
                    
                }
                orden.add(j[pregunta]);
            }   
        }
        for(String k: orden ){
            float giniPaso = sacarGini(tabla.get(k).get(1),tabla.get(k).get(0));
            float giniNopaso = sacarGini(tabla.get("exito").get(0)-tabla.get(k).get(1),grupo.size()-1-tabla.get(k).get(0));
            float giniaux = calcularElGiniPonderado(giniPaso, giniNopaso, tabla.get(k).get(0),grupo.size()-2- tabla.get(k).get(0));
            if(giniaux < Mejorgini){
                Mejorgini = giniaux;
               respuesta = k;

            }
        }


        
        return new String[]{seleccion,respuesta,Float.toString(Mejorgini)};
    }
     /**
    * Método genera el conjunto con el rango  para el  mejor gini de   una pregunta con respuestas  numéricas  
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param Numpregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     * @param metodo El parámetro metodo hace referencia a como se analizarán los datos ≤ ,≥,<,>
     *@return El arreglo con la pregunta que se analizó, el mejor rango con un metod en especifico y el gini  de la respuesta  
     */
    
    private static String[] mejorRango(ArrayList<String[]> grupo, int Numpregunta){ 
        String[] preguntas = grupo.get(0);  
         String [] retorno = new String[3];
        float [] datos = new float[grupo.size()-1];
        for(int i = 1; i<grupo.size();++i){
            datos[i-1] = Float.parseFloat(grupo.get(i)[Numpregunta]);
        }
        if(datos.length == 0){
        retorno[1] = "0";
        retorno[2] = "0.0";
        retorno[0] = preguntas[Numpregunta];
        return retorno;

        }
            
            
        Arrays.sort(datos);        
        retorno[1] =  Integer.toString((int)datos[(datos.length-1)/2]);
        retorno[2] = Float.toString(calcularElGiniPonderado(separarMenor(Numpregunta,datos[(datos.length-1)/2], grupo), separarMayor(Numpregunta, datos[(datos.length-1)/2], grupo)));
        retorno[0] = preguntas[Numpregunta];
        return retorno;


    }   
    
    /** 
    * Método que analiza la respuesta con mejor gini de cada una de las preguntas 
     * @param ruta El parámetro ruta es la ruta del archivo      * 
     *@return los arreglos con la pregunta, la respuesta con mejor gini y el gini
     */
    public static  ArrayList<String[]> GiniPorPregunta(String ruta,int [] datos){    
        ArrayList<String[]> retorno = new ArrayList<String[]>();           
        ArrayList<String[]> grupo = importar.Lector(ruta, datos);
        String[] preguntas = grupo.get(0);
        for(int i = 0; i<preguntas.length-1;++i){
            if(has.get(preguntas[i]).equals("texto"))               
                retorno.add(mejorRespuesta(grupo,i));     
            
            else           
               retorno.add(mejorRango(grupo,i));           
        }
       return retorno;
    }
    public  ArrayList<String[]> GiniPorPregunta(  ArrayList<String[]> grupo,boolean []datos){   
        Gini(); 
        ArrayList<String[]> retorno = new ArrayList<String[]>(); 
        String[] preguntas = grupo.get(0);
        String [] l = {"","","1"};
         for(int i = 0; i<preguntas.length-1;++i){
                if(has.get(preguntas[i]).equals("texto")){
                    if(datos[i] == false)
                        retorno.add(mejorRespuesta(grupo,i));
                    else
                        retorno.add(l);
                }
                else{
                    if(datos[i] == false)
                        retorno.add(mejorRango(grupo,i));
                    else
                        retorno.add(l);
                }
                
            }
           return retorno;
    }
     /**
    * Método analiza cual es la mejor pregunta de la base de datos 
     * @param lista datos de cada pregunta, [0] = nombre de  la pregunta, [1] = rango o respuesta con mejor gini , [2] = gini
     *@return arreglo con los datos de la pregunta con mejor gini  
     */
    public static String[] mejorGini(ArrayList<String[]> lista ){  
        String [] mejor = {"","","1",""} ; 
        
        for(int i = 0; i<lista.size();++i){
            String [] aux = lista.get(i);
            if(aux == null)
            break; 
            else if(Float.parseFloat(aux[2]) <  Float.parseFloat(mejor[2])){
                mejor[0] = aux[0];
                mejor[1] = aux[1];
                mejor[2] = aux[2];
                mejor[3] = Integer.toString(i);
            }
        }
        if(mejor[2].equals("1") && mejor[1].equals("")&& mejor[3].equals("")&&mejor[0].equals(""))
        return null;
        return mejor;
    }
    /**
    * Método que analiza si el conjunto tiende al exito o no 
     * @param a pregunta, [0] = nombre de  la pregunta, [1] = rango o respuesta con mejor gini , [2] = gini
     *@return si el congunto esta pro encima del promedio (1) o  no (2) 
     */
    public static int  exito(ArrayList<String[]> lista){
        int exito = 0;
        int fallo = 0;
        for(int i = 1; i< lista.size();++i){
            String[] a = lista.get(i);
            if(a[a.length-1].equals("0"))
                fallo++;
            else 
                exito++;
        }

        return (exito>fallo) ? 1 :0;
    }




    
}

