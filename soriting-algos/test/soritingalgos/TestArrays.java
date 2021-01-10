package soritingalgos;
import java.util.Arrays;
import java.util.Random;
import java.lang.System;

public class TestArrays {
	
	static Random rd = new Random();
	private static long lastTime; 
	
	public static int[] randomArr(int l) {
		int[] a = new int[l];
		for(int i=0; i<l; i++) {
			a[i]=rd.nextInt(l);
		}
		return a;
	}
	
	public static String testMess(String mname, boolean success,int[] s, int[] b) {
		return (success) ? mname + " passed. " : mname + " failed \n \t The output is: \n \t" + Arrays.toString(b) + "\n \t instead of \n \t" + Arrays.toString(s) +"\n";
	}
	
	public static String testMethod(int[] s, String mname, int[] b) { 
		return testMess(mname,Arrays.equals(s, b),s,b);
	}
	
	public static void printTime() {
		long t = microSec();
		double delta = ((double) (t-lastTime))/10E3;
		System.out.println("Milliseconds: "+delta);
		lastTime=t;
	}
	
	public static long microSec() {
		return System.nanoTime()/1000;
	}
	
	public static void testMethods(int[] a) {
		System.out.println();
		System.out.print("Array of length "+a.length);
		System.out.println();
		int[] aSorted = a.clone();
		Arrays.sort(aSorted);
		Algos algo = new Algos(a);
		lastTime = microSec();
		System.out.print(testMethod(aSorted,"Bubble sort",algo.bubbleSort()));
		printTime();	
		System.out.print(testMethod(aSorted,"Selection sort",algo.selectionSort()));
		printTime();
		System.out.print(testMethod(aSorted,"Insertion sort simple",algo.insertionSort()));
		printTime();
		System.out.print(testMethod(aSorted,"Insertion sort binary",algo.insertionSort(true)));
		printTime();
		System.out.print(testMethod(aSorted,"Heap sort",algo.heapSort()));
		printTime();
		System.out.print(testMethod(aSorted,"Merge sort",algo.mergeSort()));
		printTime();
		System.out.print(testMethod(aSorted,"Quick sort",algo.quickSort()));
		printTime();
		System.out.println();
	}
	
	public static void rawTest(int[] a, int[] b) {
		
		Arrays.sort(a);
		System.out.println();
		System.out.println();
		System.out.println(Arrays.toString(a));
		System.out.println();
		System.out.println(Arrays.toString(b));
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {0,1};
		testMethods(a);
		a[0]=1;
		a[1]=0;
		testMethods(a);
		for(int i=3; i<=10000; i=(i*(1+rd.nextInt(2)))+rd.nextInt(3)) {
			a = randomArr(i);
			testMethods(a);
		}
	}
}
