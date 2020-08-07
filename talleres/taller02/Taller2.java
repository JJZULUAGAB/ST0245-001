/**
 * Taller2
 */
public class Taller2 {   

	public static int gcd(int p, int q){ // p > q
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}   


public static boolean existe(int[] nums, int target){
    return existe(0, nums, target);
}

 

public static boolean existe(int start, int[] nums, int target){
    if(start >= nums.length){
    if (target==0) // a + b + c = target. Equivale
        return true; // target - a - b - c = 0
    // Falta como un caso donde de falso...
    else
        return false;
    }
    else{
        boolean loLlevo = existe(start+1,nums,target-nums[start]);
        boolean noLoLlevo = existe(start+1,nums,target);
        boolean loLlevoONoLoLlevo = noLoLlevo || loLlevo;
        return loLlevoONoLoLlevo;
    }
}
/**
	* @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
	*
	* El método combinations se define para que solo se tenga que pasar el parametro s y no la cadena 
	* vacía necesaria para el metodo reursivo combinationsAux. Este metodo no se modifica.
	* 
	*/
	public static void combinations(String s) { 
		combinationsAux("", s); 
	}
	
	/**
	* @param prefix, se utiliza como una variable auxiliar para guardar datos sobre el proceso.
	* @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
	*
	*
	* El método combinationsAux se encarga de encontrar las posibles combinaciones en la cadena s
	* notese que el método es "private" de modo que solo se puede llamar desde el interior de la clase pues
	* el método que lo representa es combinations.
	* Para más detalles sobre modificadores de acceso:
	* @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
	*
	*/
	
		private static void combinationsAux(String prefix, String s) { 
			if(s.length() == 0){
				System.out.println(prefix);       
			
				}
			else{
				combinationsAux(prefix + Character.toString(s.charAt(0)), s.substring(1));
				combinationsAux(prefix, s.substring(1));               
			}
		}
	public static void main(String[] args) {
	}
}