/**
 * Taller5
 */
public class Taller5 {

    public static int sumaArray(int[] a){
        int aux  =0; // c1
        for(int i = 0; i < a.length; i++){ //C2 +C3 n
            aux = aux + a[i];//C4
        }   
                return aux; //T(n) = C1+C2+C3n+C4  es O(n)    
            }
    public static void InsertionSort(int arr[]) 
        { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
          
            /* Move elements of arr[0..i-1], that are 
             greater than key, to one position ahead 
                of their current position */
                while (j >= 0 && arr[j] > key) { 
                   arr[j + 1] = arr[j]; 
                        j = j - 1; 
                    } 
                    arr[j + 1] = key; 
                } 
            } 
         


 public static void main(String[] args) {
    System.out.println("SumArray");
for(int i = 10000000 ;i <= 200000000; i = 10000000+ i) {
    long tp  = System.currentTimeMillis();        
    sumaArray(new int[i]);
    long tf  = System.currentTimeMillis();
    System.out.println(tf-tp);}


    System.out.println("Insertion Sort");
    for(int i = 1000;i <= 20000; i = 1000+ i) {
      int[] a = new int[i];
      int l = 0;
        for(int k = a.length-1; k>0;--k){
              a[l] = k;
              l++;
        }
        long tp  = System.currentTimeMillis();                             
          InsertionSort(a);
          long tf  = System.currentTimeMillis();
          System.out.println(tf-tp);
      }
      }
}

