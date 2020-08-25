
public class Laboratory1 {
    
    /**
     * This method calculates the longest common sequence between two strings
     * @param string1 First string
     * @param string2 Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
    }
    /**
     * This method is an auxiliar for lcsDNA
     * @param string1 first characters string
     * @param string2 second characters string
     * @param m length of cadena1
     * @param n length of cadena 2
     * @return length of the largest common sequence between two strings
     */
    private static int lcsDNAAux(String string1, String string2, int m, int n) {
        if(n==0 || m==0){
            return 0; // c1 = 5
        }
        if(string1.charAt(m-1)==string2.charAt(n-1)){ //C2 =6
            return 1 + lcsDNAAux(string1,string2,m-1,n-1); 
        }
        return Math.max(lcsDNAAux(string1,string2,m-1,n), lcsDNAAux(string1,string2,m,n-1)); //
        /* 
        T(I) = m+n = n+m         
                m = n+m-n
       
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
