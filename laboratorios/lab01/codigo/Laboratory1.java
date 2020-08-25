/**
 *
 * @author Isabella Quintero, Sofia Vega
 * This class contains the methods that solve points 1.1 and 1.2 of laboratory 
 * practice 1
 */



public class Laboratory1 {
    
    /**
     * This method calculates the longest common sequence between two strings
     * @param string1 First string
     * @param string2 Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String string1, String string2){
        if( string1.equals("") || string2.equals("") ){
            return 0; // c1 = 5
        }
        else if(string1.charAt(0)==string2.charAt(0)){ //C2 =6
            return 1 + lcsDNA(string1.substring(1),string2.substring(1)); 
            // T(I) = T(I-2) + C_2
        }
        return Math.max(lcsDNA(string1.substring(1),string2), lcsDNA(string1,string2.substring(1)));
        /*
        I = m + n 
        T(I) = T(I-1)+T(I+1)+ C_3
        T(I) = C3^
        */
    }
    public static int ways(int n){
        if(n<=2) return n;
        return ways(n-1) + ways(n-2);



    }
        
    public static void main(String[] args) {
        String a ="a";
        String b = "b";
        for (int n = 0; n < 20; n++){
            a= a +"a";
            b = b+ "b";
            long ti = System.currentTimeMillis();
            lcsDNA(a,b);
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        
    }

    }
}
