import java.util.Hashtable;
import java.util.ArrayList;
/**
* @author: Juan José Zuluaga and Juan José Wilches

 * @version: 13/11/2020

 */
public class Test {
    Hashtable<String,String> has = new Hashtable<String,String>();
    int acierto = 0;
    /** 
    * Constructor de clase, crea la tabla de Hash que  se va a usar para  crear el Test
    */
    public Test(){
        for(String m : new String[]{"estu_tomo_cursopreparacion","desemp_ingles","fami_numlibros","estu_areareside","fami_estratovivienda.1","fami_pisoshogar","fami_tieneinternet.1","fami_tienecomputador.1","fami_tiene_nevera.1","fami_tiene_celular.1","estu_trabajaactualmente","cole_caracter","cole_jornada"}){
            has.put(m,"texto");
        }
        for(String m: new String[]{"punt_lenguaje","punt_matematicas","punt_biologia","punt_quimica","punt_fisica","punt_ciencias_sociales","punt_filosofia","punt_ingles","exito","edad"}){
        has.put(m,"numero");
        }
    }
    /** 
    * Método crea el test dandole valores a aciertos
     * @param lista conjunto de datos para el test
     * *@param root arbol ya creado al cual se el generara el test 
     */
    public void Fill(ArrayList<String[]>lista, Tree root) {
        
        ArrayList<String[]> cumple = new  ArrayList<String[]>();
        ArrayList<String[]> Nocumple = new  ArrayList<String[]>();       
        if(root.left == null && root.rigth == null){
            for(int i =1; i<lista.size();++i){
                String[] fila = lista.get(i);
                if(Integer.parseInt(fila[fila.length-1]) == root.exito)
                 acierto++;
            }
            return;
           }
        else if(root.left != null && root.rigth == null){
            for(int i =1; i<lista.size();++i){
                String[] fila = lista.get(i);
                if(has.get(root.Pregunta).equals("texto")){
                    if(fila[root.NumPregunta].equals(root.respuesta))
                        cumple.add(fila);
                    else 
                    if(Integer.parseInt(fila[fila.length-1]) == root.exito)
                    acierto++;
                }
                else{
                    if(Float.parseFloat(fila[root.NumPregunta])>Float.parseFloat(root.respuesta))
                        cumple.add(fila);
                    else 
                    if(Integer.parseInt(fila[fila.length-1]) == root.exito)
                    acierto++;
                }

            }
            Fill(Nocumple, root.left);
        }

        else if(root.left == null && root.rigth != null){
            for(int i =1; i<lista.size();++i){
                String[] fila = lista.get(i);
                if(has.get(root.Pregunta).equals("texto")){
                    if(fila[root.NumPregunta].equals(root.respuesta)){
                        if(Integer.parseInt(fila[fila.length-1]) == root.exito){
                            acierto++;}
                    }
                    else
                        Nocumple.add(fila);                    
                }
                else{
                    if(Float.parseFloat(fila[root.NumPregunta])>Float.parseFloat(root.respuesta)){
                        if(Integer.parseInt(fila[fila.length-1]) == root.exito){
                            acierto++;}
                        }
                    else 
                        Nocumple.add(fila);  
                    }

            }
            Fill(cumple, root.rigth);
         }
    
        else{
        for(int i =1; i<lista.size();++i){
            
             String[] fila = lista.get(i);
            
            if(has.get(root.Pregunta).equals("texto")){
                if(fila[root.NumPregunta].equals(root.respuesta))
                    cumple.add(fila);
                else 
                Nocumple.add(fila);
            }
            else{
                if(Float.parseFloat(fila[root.NumPregunta])>Float.parseFloat(root.respuesta))
                    cumple.add(fila);
                else 
                Nocumple.add(fila);
            }
        }
        Fill(cumple, root.rigth);
        Fill(Nocumple, root.left);
        }
    }
 /** 
    * Método qda resultado saber pro
     * @param lista conjunto de datos para el test
     * *@param root arbol ya creado al cual se el generara el test 
     * @return 1 si pasa y 0 si no pasa 
     */
    public int resultado(ArrayList<String[]>lista, Tree root){
        String[] fila = lista.get(1);         
        if(root.Pregunta == null){
            return root.exito;
        }
        if(!has.get(root.Pregunta).equals("texto")){
            if(Float.parseFloat(fila[root.NumPregunta])>Float.parseFloat(root.respuesta)){
                if(root.rigth == null)
               return  root.exito;
                return resultado(lista, root.rigth);
               
            }
            else{
                if(root.left == null)
                return  root.exito;
                return resultado(lista, root.left);

            }
        }
        else{
        if(fila[root.NumPregunta].equals(root.respuesta)){
            if(root.rigth == null)
            return root.exito;
            return resultado(lista, root.rigth);
           
        }
        else{
            if(root.left == null)
            return root.exito;
            return resultado(lista, root.left);

        }
    }
    }
    /** 
    * Método que da el procentaje de exito de una prueba 
     * @param rutaTrain ruta del  conjunto de datos con el cual se entrena el arbol
     * *@param rutaTest ruta del  conjunto de datos con el cual se entrena el arbol
     * @param preguntas los numeros de las preguntas que se desean analizar 
     * @return porcentaje que acertó el arbol 
     */


    public static  double  pAciertos(String rutaTrain, String rutaTest, int[] preguntas){
        ArrayList<String[]> lista = importar.Lector(rutaTrain,preguntas);
        ArrayList<String[]> lista2 = importar.Lector(rutaTest,preguntas);
        Tree root = new Tree(lista);        
        Test nuevo = new Test();
        nuevo.Fill(lista2, root);
        double retorno = lista2.size()-1;
        return  nuevo.acierto/retorno;
    }

    public static void main(String[] args) {
    }
}
