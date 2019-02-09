package Sorting;

public class Sorting {
	
	int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high]; //last value of array is taken as pivot
		int i = low-1;
		for(int j = low; j < high; j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[high] = arr[i+1];
		arr[i+1] = pivot;
		
		return i+1;
	}
	void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
			
			return;
		}
	}
	int[] mergeSort(int[] arr, int start, int end) {
		
		if(start == end) {
			int[] newArr = new int[1];
			newArr[0] = arr[start];
			return newArr;
		}
		int mid = (start + end)/2;
		int[] left, right;
		left = mergeSort(arr, start, mid);
		right = mergeSort(arr, mid+1, end);
		return merge(left, right);
	}
	
	int[] merge(int[] left, int[] right) {
		int len = left.length + right.length;
		int[] result = new int[len];
		int i = 0, k = 0, j = 0;
		
		while(k < len && i < left.length &&  j < right.length) {
			if(left[i] > right[j]) {
				result[k++] = right[j++];
			} else {
				result[k++] = left[i++];
			}
		}
		while(i < left.length) {
			result[k++] = left[i++];
		}
		while(j < right.length) {
			result[k++] = right[j++];
		}
		return result;
	}
	
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {38,27,43,3,9,82,10, -1}; 
		
		System.out.println("Given Array"); 
        printArray(arr);
        
        Sorting sort = new Sorting();
//        arr = sort.mergeSort(arr, 0, arr.length-1);
        sort.quickSort(arr, 0, arr.length-1);
        
        System.out.println("\nSorted array"); 
        printArray(arr); 
	}

}
