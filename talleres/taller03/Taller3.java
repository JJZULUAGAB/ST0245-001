
public class Taller3 {

  public static void torresDeHannoi(int topN){
    hanoi(topN, "Tower1", "Tower2", "Tower3");
 }

 

 public static void hanoi(int topN, String a  , String b , String c  ){
    //""" El caso de Isabel """
    if (topN == 1){
        System.out.println(a + "->" + c);
    }
    else{ //#El caso de Luis Fernando
        hanoi(topN-1, a, c, b);
        hanoi(1, a , b, c    );
        hanoi(topN-1, b, a, c);
    }
 }

 


     /*

     * El método permutation es un auxiliar del proceso

     * @param str es la cadena a permutar

     */

     public static void permutation(String str){

         permutationAux("", str);
         
     }


     /**

     *

     * El método permutationAux es el core del proceso, en el se busca conseguir

     * las posibles permutaciones que puede tener la cadena str

     * @param str es la cadena a permutar

     * @param prefix cadena auxiliar donde se guarda la cadena de salida

     *

     * Las cadenas de salida tienes una longitud de lenght de la cadena s

     * Ej: para la cadena ABC se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }

     * donde los caracteres no se repiten pero el orden tiene un papel importante.

     *

     */

     private static void permutationAux(String respuesta, String pregunta) {

         if (pregunta.length() == 0){
          System.out.println(respuesta);
       // System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(respuesta)); solo uso para desencriptar 
          
         }
         else{

            for (int i = 0; i < pregunta.length(); i++){               
             permutationAux(respuesta + Character.toString(pregunta.charAt(i)),pregunta.replace(Character.toString(pregunta.charAt(i)),""));
                        }
             }
     }


     
    

   public static void main(String[] args) {
   permutation("abcd");


   }
   
   
   
    } 


     