package practico01;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> listaEnteros1 = new LinkedList<>();
        LinkedList<Integer> listaEnteros2 = new LinkedList<>();
        listaEnteros1.insertFront(4);
        listaEnteros1.insertFront(3);
        listaEnteros1.insertFront(7);
        listaEnteros1.insertFront(1);
        listaEnteros2.insertFront(3);
        listaEnteros2.insertFront(7);
        listaEnteros2.insertFront(15);
        listaEnteros2.insertFront(20);

        LinkedList<Integer> listaEnteros3 = new LinkedList<>();
        listaEnteros3.insert(4);
        listaEnteros3.insert(2);
        listaEnteros3.insert(7);
        listaEnteros3.insert(1);
        System.out.println(listaEnteros3);

        DoubleLinkedList<Integer> listaEnterosDoble = new DoubleLinkedList<>();
        listaEnterosDoble.insertFront(3);
        listaEnterosDoble.insertFront(5);
        listaEnterosDoble.insertFront(7);
        listaEnterosDoble.insertFront(11);
        System.out.println(listaEnterosDoble);
        System.out.println(listaEnterosDoble.get(0));


        System.out.println(isPalindrome("rotor"));
        int [] arr = {1,2,3,4,5};
        int [] arr2 = {1,2,3,1};
        System.out.println("Esta ordenado: " + isOrdered(arr,0));
        System.out.println("Esta ordenado: " + isOrdered(arr2,0));

        System.out.println("Busqueda binaria: " + binarySearch(arr,0,arr.length - 1,2));
        System.out.println("Busqueda binaria: " + binarySearch(arr,0,arr.length - 1,5));
        System.out.println("Busqueda binaria: " + binarySearch(arr,0,arr.length - 1,10));

        System.out.println("Decimal a binario: " + decimalToBinary(26));

        for (int i = 0;i < 6;i++){
            System.out.print(" Fib: " + fibonacci(i));
        }

    }
    /*
        * Ejercicio 6.
    Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
    suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar
    ordenada. b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    *
    * */
    public static  <T extends Comparable> LinkedList createCommonLinkedList(LinkedList<T> list1, LinkedList<T> list2){
        LinkedList<T> newList = new LinkedList<>();
        IteratorLinkedList iterator1 = list1.iterator();
        IteratorLinkedList iterator2 = list2.iterator();
        if (iterator1.getCurrent().compareTo(iterator2.getCurrent()) >= 1){
            iterator2.next();
        }else if (iterator2.getCurrent().compareTo(iterator1.getCurrent()) >= 1){
            iterator1.next();
        }else if (iterator1.getCurrent().compareTo(iterator2.getCurrent()) == 0) {
            newList.insertFront((T) iterator1.getCurrent());
            iterator1.next();
            iterator2.next();
        }
        return newList;
    }
    /*
    * Ejercicio 7.
    Escriba una función que dadas dos listas construya otra con los elementos que están en la
    primera pero no en la segunda.
    * */
    public static  <T extends Comparable> LinkedList createNotCommonLinkedList(LinkedList<T> list1, LinkedList<T> list2){
        LinkedList<T> newList = new LinkedList<>();
        for (T i:list1){
            for(T j:list2){
                if (i != j){
                    newList.insert(i);
                }
            }
        }
        return newList;
    }
    /*
    * Ejercicio 9.
    Implemente un algoritmo recursivo que verifique si una cadena de texto es palindroma
    (capicua).
    * */
    public static boolean isPalindrome(String value){
        if (value.length() == 0 || value.length() == 1){
            return true;
        }
        if(value.charAt(0) == value.charAt(value.length()-1))
            return isPalindrome(value.substring(1, value.length()-1));
        return false;
    }
    /*
    * Ejercicio 10.
    Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
    1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
    2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
    * 1. O(n) ya que siempre debe hacer n accesos de memoria por cada elemento del arreglo
    * 2. Hacerlo recursivo podria hacer que llene la pila de ejecucion del programa en el sistema
    * 3. 
    * */
    public static boolean isOrdered(int [] arr,int pos){
        if (pos == arr.length - 1){
            return true;
        }
        if (arr[pos] < arr[pos+1]){
            return isOrdered(arr,pos+1);
        }
        return false;
    }
    /*
    * Ejercicio 11.
    Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
    ascendentemente.
    * */
    public static int binarySearch(int [] arr,int start,int end,int target){
        if (!(start <= end)){
            return -1;
        }
        int mid = (int) Math.floor((start + end) / 2);
        if (arr[mid] == target)
        {
            return mid;
        }
        if (arr[mid] > target)
        {
            return binarySearch(arr,start,mid-1,target);
        }else
        {
            return binarySearch(arr,mid+1,end,target);
        }
    }
    /*
    * Ejercicio 12.
    Implemente un algoritmo recursivo que convierta un número en notación decimal a su
    equivalente en notación binaria.
    * */
    public static String decimalToBinary(Integer num){
        if (num == 0){
            return "";
        }
        int aux = num % 2;
        return decimalToBinary(num / 2) + aux;
    }
    /*
    * Ejercicio 13.
    Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
    Fibonacci.
    Por ej. los 6 primeros términos son: 0 1 1 2 3 5
    * */
    public static int fibonacci(int num){
        if (num == 0){
            return 0;
        }
        if (num == 1 || num == 2){
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
