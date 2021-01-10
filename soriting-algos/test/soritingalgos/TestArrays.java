package soritingalgos;
import java.util.Arrays;
import java.util.Random;

public class TestArrays {
	
	static Random rd = new Random();
	
	public static int[] randomArr(int l) {
		int[] a = new int[l];
		for(int i=0; i<l; i++) {
			a[i]=rd.nextInt(l);
		}
		return a;
	}
	
	public static String testMess(String mname, boolean success,int[] s, int[] b) {
		return (success) ? mname + " passed" : mname + " failed \n \t The output is: \n \t" + Arrays.toString(b) + "\n \t instead of \n \t" + Arrays.toString(s);
	}
	
	public static String testMethod(int[] s, String mname, int[] b) { 
		return testMess(mname,Arrays.equals(s, b),s,b);
	}
	
	public static void testMethods(int[] a) {
		System.out.println();
		System.out.println("\t\t\t\t\t"+Arrays.toString(a));
		System.out.println();
		int[] aSorted = a.clone();
		Arrays.sort(aSorted);
		Algos algo = new Algos(a);
//		System.out.println(testMethod(aSorted,"Bubble sort",algo.bubbleSort()));
//		System.out.println(testMethod(aSorted,"Selection sort",algo.selectionSort()));
//		System.out.println(testMethod(aSorted,"Insertion sort simple",algo.insertionSort()));
//		System.out.println(testMethod(aSorted,"Insertion sort binary",algo.insertionSort(true)));
		System.out.println(testMethod(aSorted,"Heap sort",algo.heapSort()));
		System.out.println(testMethod(aSorted,"Merge sort",algo.mergeSort()));
		System.out.println(testMethod(aSorted,"Quick sort",algo.quickSort()));
	}
	
	public static void main(String[] args) {
		int[] a = {0,1};
		testMethods(a);
		for(int i=2; i<=100;i=i*2+1 ) {
			a = randomArr(i);
			testMethods(a);
		}
	}
}
