package practico02;

public class MergeSort {
    private int[] numbers;
    private int[] helper;
    private int size;

    public void sort(int[] values){
        this.numbers = values;
        size = numbers.length;
        this.helper = new int[size];
        mergeSort(0,size - 1);
    }

    private void mergeSort(int low,int high){

        if (low < high){
            int mid = (low + high) / 2;

            mergeSort(low,mid);

            mergeSort(mid+1,high);

            merge(low,mid,high);
        }
    }
    private void merge(int low, int middle, int high) {
    // copiar ambas partes al array helper
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
    // copiar de manera ordenada al array original los valores de la
    // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper[ i ] <= helper[ j ]) {
                numbers[ k ] = helper[ i ];
                i++;
            } else {
                numbers[ k ] = helper[ j ];
                j++;
            }
            k++;
        }
        // si quedaron elementos copiarlos al array original
        while (i <= middle) {
            numbers[ k ] = helper[ i ];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[ k ] = helper[ j ];
            k++;
            j++;
        }
    }
}
