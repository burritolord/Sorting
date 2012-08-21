package algorithms;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author zesty
 */
public class SortTest {
    private Integer[] one;
    private Integer[] many;
    private Random rand;
    private static final int SIZE = 100;
    private static final int ONEVAL = 3;
    
    public SortTest() {
        one = new Integer[1];
        many = new Integer[10];
        rand = new Random();
        one[0] = new Integer(ONEVAL);
    }
    
    public void positiveSetup(){
        for(int i = 0; i < many.length; i++){
            many[i] = rand.nextInt(SIZE);
        }
    }
    public void negativeSetup(){
        for(int i = 0; i < many.length; i++){
            many[i] = -rand.nextInt(SIZE);
        }
    }
    public void mixedSetup(){
        for(int i = 0; i < many.length; i++){
            many[i] = rand.nextInt(SIZE) - 50;
        }
    }
    
    private void sorted(Integer[] list){
        for(int i = 0; i < list.length-1; i++){
            if(list[i].compareTo(list[i+1]) > 0)
                fail("List not sorted");
        }
    }

    /**
     * Test of insertionSort method, of class Sort.
     */
    public void testInsertionSortOne() {
        Sort.insertionSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testInsertionSortPositive() {
        positiveSetup();
        Sort.insertionSort(many);
        sorted(many);
    }
    @Test
    public void testInsertionSortNegative() {
        negativeSetup();
        Sort.insertionSort(many);
        sorted(many);
    }
    @Test
    public void testInsertionSortMixed() {
        mixedSetup();
        Sort.insertionSort(many);
        sorted(many);
    }
    
    /**
     * Test of mergeSort method, of class Sort.
     */
    public void testMergeSortOne() {
        Sort.mergeSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testMergeSortPositive() {
        positiveSetup();
        Sort.mergeSort(many);
        sorted(many);
    }
    @Test
    public void testMergeSortNegative() {
        negativeSetup();
        Sort.mergeSort(many);
        sorted(many);
    }
    @Test
    public void testMergeSortMixed() {
        mixedSetup();
        Sort.mergeSort(many);
        sorted(many);
    }

    /**
     * Test of selectionSort method, of class Sort.
     */
    public void testSelectionSortOne() {
        Sort.selectionSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testSelectionSortPositive() {
        positiveSetup();
        Sort.selectionSort(many);
        sorted(many);
    }
    @Test
    public void testSelectionSortNegative() {
        negativeSetup();
        Sort.selectionSort(many);
        sorted(many);
    }
    @Test
    public void testSelectionSortMixed() {
        mixedSetup();
        Sort.selectionSort(many);
        sorted(many);
    }

    /**
     * Test of bubbleSort method, of class Sort.
     */
    public void testBubbleSortOne() {
        Sort.bubbleSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testBubbleSortPositive() {
        positiveSetup();
        Sort.bubbleSort(many);
        sorted(many);
    }
    @Test
    public void testBubbleSortNegative() {
        negativeSetup();
        Sort.bubbleSort(many);
        sorted(many);
    }
    @Test
    public void testBubbleSortMixed() {
        mixedSetup();
        Sort.bubbleSort(many);
        sorted(many);
    }

    /**
     * Test of quickSort method, of class Sort.
     */
    public void testQuickSortOne() {
        Sort.quickSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testQuickSortPositive() {
        positiveSetup();
        Sort.quickSort(many);
        sorted(many);
    }
    @Test
    public void testQuickSortNegative() {
        negativeSetup();
        Sort.quickSort(many);
        sorted(many);
    }
    @Test
    public void testQuickSortMixed() {
        mixedSetup();
        Sort.quickSort(many);
        sorted(many);
    }

    /**
     * Test of heapSort method, of class Sort.
     */
    public void testHeapSortOne() {
        Sort.heapSort(one);
        assertEquals("Value change",ONEVAL,(int)one[0]);
    }
    @Test
    public void testHeapSortPositive() {
        positiveSetup();
        Sort.heapSort(many);
        sorted(many);
    }
    @Test
    public void testHeapSortNegative() {
        negativeSetup();
        Sort.heapSort(many);
        sorted(many);
    }
    @Test
    public void testHeapSortMixed() {
        mixedSetup();
        Sort.heapSort(many);
        sorted(many);
    }
}
