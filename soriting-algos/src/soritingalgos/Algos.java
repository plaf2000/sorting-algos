package soritingalgos;

public class Algos {
	
	private int[] a;
	private int len;
	private int[] b;
	
	public Algos(int[] a) {
		this.a = a;
		this.len=a.length;
	}
	
	private void swap(int i, int j) {
		int t = b[i];
		b[i] = b[j];
		b[j] = t;
	}
	
	
	//================================
	// BUBBLE SORT
	//================================
	
	public int[] bubbleSort() {
		b = a.clone();
		for(int i=0; i<len; i++) {
			for(int j=1; j<len; j++) {
				if(b[j]<b[j-1])
					swap(j,j-1);
			}
		}
		return b;
	}
	
	//================================
	// SELECTION SORT
	//================================
	
	public int[] selectionSort() {
		b = a.clone();
		int argmax = 0;
		for(int i=len-1; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				if(b[j]>b[argmax]) {
					argmax=j;
				}
			}
			swap(argmax,i);
			argmax = 0;
		}
		return b;
	}
	
	//================================
	// INSERTION SORT
	//================================
	
	private int binarySearch(int value, int left, int right) {
		
		int m = (right+left)/2;
		if(value==b[m]) {
			return m;
		}
		else if(value>b[m]) {
			if(m+1==len-1 || value<=b[m+1])
				return m+1;
			else 
				return binarySearch(value,m+1,right);
		}
		else {
			if(m-1<0 || value>=b[m-1])
				return m;
			else 
				return binarySearch(value,left,m);
		}
	}
	
	private void insert(int from, int to) {
		int tmp = b[from];
		for(int i=from; i>to; i--) {
			b[i]=b[i-1];
		}
		b[to] = tmp;
	}
	

	
	public int[] insertionSort(boolean binarySearch) {
		b = a.clone();
		for(int i=1; i<len; i++) {
			
			
			if(binarySearch) {
				int pos = binarySearch(b[i],0,i-1);
				insert(i,pos);
			}
			
			
			
			
			else {
				int j=i;
				while(j>0 && b[j]<b[j-1])  {
					swap(j,j-1);
					j--;
				}
			}
			
			
		}
		return b;
	}
	
	public int[] insertionSort() {
		return insertionSort(false);
	}
	
	
	//================================
	// HEAPSORT
	//================================
	
	
	private void restoreHeapCondition(int i) {
		int j = i*2+1;
		int k = i;
		while(j<len) {
			
			if(j+1<len && b[j+1]>b[j]) j++;
			
			swap(k,j);
			k=j;
			j=k*2+1;
			
			
		}
	}
	

	
	public int[] heapSort() {
		b=a.clone();
		for(int i=(len-1)/2; i>=0; i--) {
			restoreHeapCondition(i);
		}
		for(int i=len-1; i>0; i--) {
			swap(0,i);
			restoreHeapCondition(0);
		}
		return b;
	}
	
	
	//================================
	// MERGESORT
	//================================
	
	private void merge(int l,int m, int r) {
		int i=l;
		int j=m+1;
		int p=0;
		int clen=l-r+1;
		int[] c = new int[clen];
		while (p<clen) {
			if (i==m+1) 
				c[p] = b[j++];
			else if (j==r+1)
				c[p] = b[i++];
			else 
				if(b[i]<=b[j]) 
					c[p]=b[i++];
				else 
					c[p]=b[j++];			
			p++;
		}
		
		for (i=l; i<l+c.length;i++) b[i]=c[i-l];
	}
	
	private void mergeSort(int l, int r) {
		int m = (r+l)/2;
		if(l>r+1) {
			mergeSort(l,m);
			mergeSort(m+1,r);
			merge(l,m,r);
		}
			
		
		
		
	}
	
	public int[] mergeSort() {
		b=a.clone();
		mergeSort(0,len-1);
		return b;
	}
	
	//================================
	// QUICKSORT
	//================================
	
	public void quickSort(int l, int r) {
		int i=l;
		int j=r-1;
		
		while(i<j) {
			while(i<r && b[i]<=b[r]) i++;
			while(j>0 && b[j]>=b[r]) j--;
				  
			swap(i,j);
		 
		}
		swap(r,i);
		if(l-r>1) {
			quickSort(l,i-1);
			quickSort(i+1,r);
		}
	}
	
	public int[] quickSort() {
		b=a.clone();
		quickSort(0,len-1);
		return b;
	}
	
}
