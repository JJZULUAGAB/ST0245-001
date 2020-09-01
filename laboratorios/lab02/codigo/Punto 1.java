/**
 * Laboratorio 2 de Estructuras de Datos 1
 * 
 * @author Mauricio Toro 
 * @version 1
 */



public class Laboratorio2
{

  
  // Sorts an array using Insertion Sort
  /* Title: InsertionSort
    Date:25-07-2020
  Availability: https://www.geeksforgeeks.org/insertion-sort/
  */ 
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
 
      // Sorts an array using Merge Sort
	public static void mergeSort(int [ ] a)
	{
		mergeSort(a, 0,  a.length - 1);
	}

        // Sorts an array using Merge Sort
        public static void mergeSort(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }

    /* Title: mergeSort
    Autor: David landup
    Availability: https://stackabuse.com/merge-sort-in-java/ 
  */ 

    // Merges two sorted arrays
    private static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];
    
        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];
    
        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;
    
        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                   array[i] = leftArray[leftIndex];
                   leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
  
  public static void main(String[] args)
  {
      /*int[] A = {1,5,3,2,6};
      int[] B = {1,5,3,2};
      int[] C = {1,5,2,6};
      int[][] Arrays = {A,B,C};  
      for (int[] X : Arrays)
      {        
        mergeSort(X);
         InsertionSort(X);
         
      }
      */
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
      System.out.println("Merge Sort");
    
      for(int i = 1000000;i <= 21000000; i = 100000+ i) {
        int[] a = new int[i];
        int l = 0;
          for(int k = a.length-1; k>0;--k){
                a[l] = k;
                l++;
          }
          long tp  = System.currentTimeMillis();                             
            mergeSort(a);
            long tf  = System.currentTimeMillis();
            System.out.println(tf-tp);
    }

    
      

  }
  
  }