import java.util.*;


public class Taller8 {
 
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca(String string){
         Stack<Integer> pila = new Stack();
         String simbolos = "+-/*";
         if(string.length() > 2){     
        for(String c : string.split(" ") ){
              if(simbolos.contains(c)){
                if(c.equals("+")){
                  pila.push(pila.pop() + pila.pop());
                }                  
                if(c.equals("-")){
                    pila.push(-1*pila.pop() + pila.pop());
                }
                if(c.equals("*")){
                    pila.push(pila.pop()* pila.pop());
                }
                if(c.equals("/")){
                    pila.push(pila.pop()/pila.pop());
                }
            }
            else{
                pila.push(Integer.parseInt(c));


            }

        }
        }
        return pila.pop();
    }

    /**
    * @param neveras es una estructura de datos para representar el almacen con las neveras
    * @param solicitudes es una estructura de datos para representar las solicitudes
    */
    public static void asignarSolicitudes(Stack<Nevera> neveras , Queue<Solicitud> solicitudes ){
        for(Solicitud solicitud : solicitudes ){            
            for(Nevera nevera : neveras ){
                if(nevera.getmarca().equals(solicitud.getmarca())){
                    System.out.println("nevera"+nevera.getcodigo()+"asignada a "+solicitud.gettienda());
                    break;
                }
                
            }
        }
    }
	
    
    
   
}

