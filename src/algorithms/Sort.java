package algorithms;

public class Sort{
    public static<T extends Comparable<T>> void insertionSort(T[] list){
        T key;
        for (int i = 1,j; i < list.length; i++) {
            key = list[i];
            j = i-1;
            while(j >= 0 && list[j].compareTo(key) > 0){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = key;
        }
    }
    
    public static<T extends Comparable<? super T>> void mergeSort(T[] list){
        Comparable[] left = new Comparable[(int)Math.floor(list.length/2)];
        Comparable[] right = new Comparable[list.length-left.length];
        if(list.length > 1){
            // copy left
            for(int i = 0;i < left.length; i++){
                left[i] = list[i];
            }
            // copy right
            for(int i = 0,j = left.length; j < list.length; i++, j++){
                right[i] = list[j];
            }
            mergeSort(left);
            mergeSort(right);
            merge(left,right,list);
        }
    }
    private static <T extends Comparable<? super T>> void merge(T[] left, T[] right, T[] list){
        int i,j,k;
        i = j = k = 0;
        // copy elements in order to list
        while(i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <= 0){
                list[k] = left[i];
                i++;
            }
            else{
                list[k] = right[j];
                j++;
            }
            k++;
        }
        // copy remaining elements of right to list
        if(i == left.length){
            for(; j < right.length; j++,k++){
                list[k] = right[j];
            }
        }
        // copy remaining elements of left to list
        else{
            for(; i < left.length; i++,k++){
                list[k] = left[i];
            }
        }
        
    }
    
    public static<T extends Comparable<T>> void selectionSort(T[] list){
        int min = 0;
        for(int i = 0,length = list.length-1; i < length; i++){
            min = i;
            for(int j = i+1; j < list.length; j++){
                if(list[j].compareTo(list[min]) < 0)
                    min = j;
            }
            if(min != i)
                swap(list,i,min);
        }
    }
    
    public static<T extends Comparable<T>> void bubbleSort(T[] list){
        boolean swap = true;
        for(int i = 0; i < list.length-1 && swap; i++){
            swap = false;
            for(int j = 0; j < list.length - i -1; j++){
                if(list[j].compareTo(list[j+1]) > 0){
                    swap = true;
                    swap(list,j,j+1);
                }
            }
        }
    }
    
    public static<T extends Comparable<T>> void quickSort(T[] list){
        quickSort(list,0,list.length-1);
    }
    private static<T extends Comparable<T>> void quickSort(T[] list, int first, int last){
        if(first < last){
            int pivotPos = partition(list,first,last);
            quickSort(list,first,pivotPos-1);
            quickSort(list,pivotPos+1,last);
        }
    }
    private static<T extends Comparable<T>> int partition(T[] list, int first, int last){
        T pivot = list[last];
        int i = first-1;
        for(int j = first; j < last; j++){
            if(list[j].compareTo(pivot) <= 0){
                i++;
                swap(list,i,j);    
            }
        }
        swap(list,i+1,last);
        return i+1;
    }
    
    public static<T extends Comparable<T>> void heapSort(T[] list){
        heapify(list,list.length);
        for(int i = list.length-1; i > 0; i--){
            swap(list,0,i);
            heapify(list,i);    
        }
    }
    // Builds a max heap
    private static<T extends Comparable<T>> void heapify(T[] list, int len){
        T v;
        int j,k;
        boolean heap;
        for(int i = parent(len); i >= 0; i--){
            k = i;
            v = list[k];
            heap = false;
            while(!heap && left(k) < len){
                j = left(k);
                // check if has two children
                if(j < len-1 && list[j].compareTo(list[j+1]) < 0){
                    j++;
                }
                // check if child greater than parent
                if(v.compareTo(list[j]) >= 0)
                    heap = true;
                else{
                    list[k] = list[j];
                    k=j;
                }
            }
            list[k] = v;
        }
    }
    private static int parent(int i){            
        return (int)Math.floor((i-1)/2);
    }
    private static int left(int i){
        return i*2+1;
    }
    private static int right(int i){
        return i*2+2;
    }
    
    //--------------------------Helper Functions------------------------------
    private static<T>void swap(T[] list, int first, int second){
        T tmp = list[first];
        list[first] = list[second];
        list[second] = tmp;
    }
}
