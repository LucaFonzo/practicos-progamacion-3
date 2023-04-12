package practico02;
    /*
    * Ejercicio 1.
    Implemente un algoritmo de ordenamiento por selección en un arreglo.
    Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
    * 1. ¿Qué complejidad O tienen estos algoritmos?
        1. Ambos algoritmos tienen una complejidad computacional de O(n^2)
    * */
    /*
    * Ejercicio 2.
    Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
    Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
    1. ¿Cuál es su complejidad en el peor caso?
    2. ¿Cuál es su complejidad promedio?
    * */

public class Main {
    public static void main(String[] args) {
        int[] arr = { 5,2,7,1,9,6 };
        //MergeSort mergeSort = new MergeSort();
        //mergeSort.sort(arr);
        quickSort(arr,0,arr.length - 1);
        printArr(arr);
    }

    public static void selectionSort(int [] arr){
        int aux,min;
        for (int i = 0;i < arr.length;i++){
            min = i;
            for (int j = i+1;j < arr.length;j++){
                if (arr[min] > arr[j]){
                    min = j;

                }
            }
            aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }
    public static void bubbleSort(int [] arr){
        boolean swapped = true;
        int j = 0;
        int aux;
        while (swapped){
            swapped = false;
            j++;
            for (int i = 0;i < arr.length - j;i++){
                if (arr[i] > arr[i + 1]){
                    aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swapped = true;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void printArr(int [] arr){
        for (int i:arr){
            System.out.println(i);
        }
    }
}
