
import java.util.LinkedList;
public class tecladoRoto{
    //Punto 2.1
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        for(int i=0; i < a.length(); ++i){
            if(a.charAt(i) != ']' && a.charAt(i) != '['){
                texto.addLast(a.charAt(i));
            }

        }
        while(texto.size()>0){
            System.out.print(texto.getFirst());
            texto.remove();
             
        }
    
    }
}
