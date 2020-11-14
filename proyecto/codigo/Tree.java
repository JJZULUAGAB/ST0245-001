import java.util.ArrayList;
import java.util.Hashtable;
/**
* @author: Juan José Zuluaga and Juan José Wilches

 * @version: 13/11/2020

 */


public class Tree {
  Tree left;
  Tree rigth;
  int exito;
  String Pregunta;
  String respuesta;
  int NumPregunta;
  static Hashtable<String,String> has = new Hashtable<String,String>();

  /** 
    * Método crea la tabla de Hash que   se va a usar para  crear el Tree
    */
  public static void has(){
    for(String m : new String[]{"estu_tomo_cursopreparacion","desemp_ingles","fami_numlibros","estu_areareside","fami_estratovivienda.1","fami_pisoshogar","fami_tieneinternet.1","fami_tienecomputador.1","fami_tiene_nevera.1","fami_tiene_celular.1","estu_trabajaactualmente","cole_caracter","cole_jornada"}){
      has.put(m,"texto");
    } 
    for(String m: new String[]{"punt_lenguaje","punt_matematicas","punt_biologia","punt_quimica","punt_fisica","punt_ciencias_sociales","punt_filosofia","punt_ingles","exito","edad"}){
      has.put(m,"numero");
    }
  }
  /**
     * Constructor del arbol de decisión 
     * @param lista conjunto de datos  
     * 
     */
  
  public Tree(ArrayList<String[]> lista){    
    boolean[] disponibles = new boolean[lista.get(0).length-1];
    has();
    gini Gini = new gini();
    String []pregunta = gini.mejorGini(Gini.GiniPorPregunta(lista, disponibles));
    exito = gini.exito(lista);    
    if(pregunta == null){
      return;
    }
    else if( pregunta[2].equals("0.0")){
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
    
    }
    else if(has.get(pregunta[0]).equals("numero") ){
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
      disponibles[NumPregunta] = true;         
      left = new  Tree(gini.separarMenor(Integer.parseInt(pregunta[3]),Integer.parseInt(pregunta[1]), lista),disponibles.clone());
      rigth = new Tree(gini.separarMayorIgual(Integer.parseInt(pregunta[3]),Integer.parseInt(pregunta[1]), lista),disponibles.clone());
        
      }
    else{
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
      disponibles[NumPregunta] = true;      
      left = new Tree(gini.separarFlase(Integer.parseInt(pregunta[3]),pregunta[1], lista),disponibles.clone());
      rigth = new Tree(gini.separarTrue(Integer.parseInt(pregunta[3]),pregunta[1], lista),disponibles.clone());
    
    }
  
  }    

   /**
     * Constructor crea el arbol de decisión 
     * @param lista conjunto de datos  
     * @param disponibles lista que cuenta las preguntas que ya se han tomado en cuenta para el analisis 
     * 
     */
  
  public Tree(ArrayList<String[]> lista, boolean[] disponibles){   
    gini Gini = new gini();
    String []pregunta = gini.mejorGini(Gini.GiniPorPregunta(lista, disponibles));
    exito = gini.exito(lista);    
    if(pregunta == null){
      return;
    }
    else if( pregunta[2].equals("0.0")){
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
    
    }
    else if(has.get(pregunta[0]).equals("numero") ){
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
      disponibles[NumPregunta] = true;         
      left = new  Tree(gini.separarMenor(Integer.parseInt(pregunta[3]),Integer.parseInt(pregunta[1]), lista),disponibles.clone());
      rigth = new Tree(gini.separarMayorIgual(Integer.parseInt(pregunta[3]),Integer.parseInt(pregunta[1]), lista),disponibles.clone());
        
      }
    else{
      Pregunta = pregunta[0];
      respuesta = pregunta[1];
      NumPregunta = Integer.parseInt(pregunta[3]);
      disponibles[NumPregunta] = true;      
    left = new Tree(gini.separarFlase(Integer.parseInt(pregunta[3]),pregunta[1], lista),disponibles.clone());
    rigth = new Tree(gini.separarTrue(Integer.parseInt(pregunta[3]),pregunta[1], lista),disponibles.clone());
    
    }

  
  }
  
 }