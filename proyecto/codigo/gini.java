import java.util.ArrayList;
/**

 * eEsta clase contiene los metodos necesarios para obteneer el gini de diferentes datos
 * @author: Juan José Zuluaga and Juan José Wilches

 * @version: 8/10/2020

 */


public class gini {    

     /**

     * Método que separa un conjunto de datos NO numéricos, en aquellos que cumplen con una condición de respuesta 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar, con los indicativos de cada pregunta en la posicion 0  
     *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@param respuesta El parámetro respuesta define cual será la respuesta que dividirá el grupo de datos
     * @return Aquellas secciones de datos que cumplan con la condición

     */
    public  ArrayList<String[]> separarTrue(int pregunta, String respuesta,ArrayList<String[]> grupo){
        ArrayList<String[]> retorno = new ArrayList<String[]>();
        for(int i  =0; i<grupo.size();++i) {
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
    public  ArrayList<String[]>  separarFlase(int pregunta, String respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
        for(int i  =0; i<grupo.size();++i) {
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
    public  ArrayList<String[]>  separarMenor(int pregunta, int respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
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
    public  ArrayList<String[]>  separarMenorIgual(int pregunta, int respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
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
    public  ArrayList<String[]>  separarMayor(int pregunta, int respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
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
    public  ArrayList<String[]>  separarMayorIgual(int pregunta, int respuesta, ArrayList<String[]>  grupo){
        ArrayList<String[]>  retorno = new ArrayList<String[]>();
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
    public  float sacarGini(ArrayList<String[]>  lista){
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
    * Método que calcula el gini ponderado de dos conjuntos uno que cumple un condición y otro que no
     * @param cumple El parámetro cumple es el conjunto de datos que cumple con la condición 
     * @param noCumple El parámetro noCumple es el conjunto de datos que no cumple con la condición   
     *@return El coeficiente gini del conjunto de datos 

     */
    public   float calcularElGiniPonderado(ArrayList<String[]>  cumple,ArrayList<String[]>  noCumple){
        float elGiniDeCumple = sacarGini(cumple);
        float elGiniDeNoCumple = sacarGini(noCumple);
        float elGiniPonderado = (elGiniDeCumple*cumple.size() + 
                elGiniDeNoCumple*noCumple.size()) /  (cumple.size() + noCumple.size());
        return elGiniPonderado;
    }
    /**
    * Método mira el conjunto de respuestas de una pregunta 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@return el conjunto de respuestas para una pregunta 
     */
    public  ArrayList<String> respuestas(ArrayList<String[]> grupo, int pregunta ){
        ArrayList<String> respuestas = new  ArrayList<String>();
        for(int i = 0; i < grupo.size();++i){
            String [] line = grupo.get(i);
            if(!respuestas.contains(line[pregunta])){
                respuestas.add(line[pregunta]);
            }
        }

        return respuestas;
    }
    /**
    * Método genera el conjunto con la respuesta con mejor gini  para  una pregunta con respuestas NO numéricas 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param pregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     *@return El arreglo con la pregunta que se analizó, la respuesta con mejor  gini y el gini  de la respuesta
     */
    public   String[] mejorRespuesta(ArrayList<String[]> grupo, int pregunta){
        ArrayList<String> respuestas = respuestas( grupo, pregunta);
        float mejorGini  = 1 ;
        String variable = " ";
        String[] preguntas = grupo.get(0);
        String [] retorno = new String[3]; 
        for(String g : respuestas){
           float  gini = calcularElGiniPonderado(separarFlase(pregunta, g , grupo), separarTrue(pregunta, g , grupo));

            if( gini < mejorGini ){
                variable = g;
                mejorGini = gini; 
            }    
        }  
        retorno[0] = preguntas[pregunta];
        retorno[1] = variable;
        retorno[2] = Float.toString(mejorGini);
        return retorno;
    }
    /**
    * Método genera el conjunto con el rango  para el  mejor gini de   una pregunta con respuestas  numéricas  
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param Numpregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar
     * @param metodo El parámetro metodo hace referencia a como se analizarán los datos ≤ ,≥,<,>
     *@return El arreglo con la pregunta que se analizó, el mejor rango con un metod en especifico y el gini  de la respuesta  
     */
    private  String[] mejorRango(ArrayList<String[]> grupo, int Numpregunta,String metodo){ 
        String[] preguntas = grupo.get(0);  
        float Mejorgini = 1;
        int  rango  =0;
        String [] retorno = new String[3];
        switch (metodo) {
            case "separarMenorIgual" :
                for(int j = 0; j < 100 ; ++j){
                    float   gini = calcularElGiniPonderado(separarMenorIgual(Numpregunta, j , grupo), separarMayor(Numpregunta, j , grupo));
                    if(gini < Mejorgini){
                        Mejorgini = gini;                    
                        rango = j;
                    }

                }
                
                break;

            case "separarMayorIgual":
                for(int j = 0; j < 100 ; ++j){
                    float   gini = calcularElGiniPonderado(separarMenor(Numpregunta, j , grupo), separarMayorIgual(Numpregunta, j , grupo));
                    if(gini < Mejorgini){
                        Mejorgini = gini;                    
                        rango = j;
                    }
                }
                break;
            
            case "separarMayor/separarMenor":
            
                for(int j = 0; j < 100 ; ++j){
                    float   gini = calcularElGiniPonderado(separarMenor(Numpregunta, j , grupo), separarMayor(Numpregunta, j , grupo));
                    if(gini < Mejorgini){
                        Mejorgini = gini;                    
                        rango = j;
                    }

                }
            
                break;
        }
            
        
        retorno[0] = preguntas[Numpregunta];
        retorno[1] = Integer.toString(rango);
        retorno[2] = Float.toString(Mejorgini);
            return retorno;


    }
    /** 
    * Método genera el conjunto con el rango  para el  mejor gini de   una pregunta con respuestas  numéricas, analizando cada uno de los posibles metodos de analisis 
     * @param grupo El parámetro grupo es el conjunto de datos a analizar  
     * *@param Numpregunta  El parámetro pregunta define en que posición del arreglo estan los datos a analizar     
     *@return El arreglo con la pregunta que se analizó, el mejor rango entre todos los metodos y el gini  de la respuesta 
     */
    public  String[] mejorRango(ArrayList<String[]> grupo, int Numpregunta){
        String[] preguntas = grupo.get(0);  
        String[] metodos = {"separarMayor/separarMenor","separarMayorIgual","separarMenorIgual"};
        String [] aux; 
        float mejorGini = 1;
        String rango = "";
        String mtodo = "";
        String[] retorno = new String[4];
        for(String metodo: metodos ){
            aux = mejorRango(grupo, Numpregunta, metodo);
            if(Float.parseFloat(aux[2]) < mejorGini ){
                mejorGini = Float.parseFloat(aux[2]);
                rango = aux[1];
                mtodo = metodo;
            }


        }
        retorno[0] = preguntas[Numpregunta];
        retorno[1] = rango;
        retorno[2] = Float.toString(mejorGini);
        retorno[3] = mtodo;

        return retorno;


    }
}