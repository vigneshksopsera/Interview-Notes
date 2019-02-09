package Heap;
public class MinHeap {
	
	int heap_size;
	int capacity;
	int[] arr;
	
	MinHeap(int c) {
		capacity = c;
		arr = new int[capacity];
	}
	
	int parent(int idx) {
		return (idx-1)/2; 
	}
	int left(int idx) {
		return 2*idx + 1; 
	}
	int right(int idx) {
		return 2*idx + 2; 
	}
	void insertKey(int val) {
		if(heap_size == capacity) {
			System.out.println("Queue overflow....");
		}
		heap_size++;
		int i = heap_size -1;
		arr[i] = val;
		
		while(i!=0 && arr[parent(i)] > arr[i]) {
			int temp_idx = parent(i);
			int temp = arr[i];
			arr[i] = arr[temp_idx];
			arr[temp_idx] = temp;
			i = temp_idx;
		}
	}
	void deleteKey(int idx) {
		decreaseKey(idx, Integer.MIN_VALUE);
		extractMin();
	}
	void decreaseKey(int idx, int new_val) {
		
		arr[idx] = new_val;
		int i = idx;
		while(i!=0 && arr[parent(i)] > arr[i]) {
			int temp_idx = parent(i);
			int temp = arr[i];
			arr[i] = arr[temp_idx];
			arr[temp_idx] = temp;
			i = temp_idx;
		}
		
	}
	int getMin() {
		return arr[0];
	}
	int extractMin() {
		System.out.println("Coming isnide extract min...");
		if(heap_size <= 0) {
			return Integer.MAX_VALUE;
		}
		if(heap_size == 1) {
			heap_size--;
			return arr[0];
		}
		int root = arr[0];
		System.out.println("root value: " + root);
		arr[0] = arr[heap_size-1];
		heap_size--;
		minHeapify(0);
		return root;
	}
	void minHeapify(int idx) {
		
		System.out.println("Index value: " + idx + ", Heap size: " + heap_size);
		int l = left(idx);
		int r = right(idx);
		int smallest = idx;
		
		System.out.println("left: " + l + ", right: " + r);
		
		if(l < heap_size && arr[l] < arr[idx]) {
			smallest = l;
		}
		if(r < heap_size && arr[r] < arr[smallest]) {
			smallest = r;
		}
		System.out.println("smallest: " + smallest);
		if(smallest != idx) {
			int temp = arr[smallest];
			arr[smallest] =  arr[idx];
			arr[idx] = temp;
			minHeapify(smallest);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap h = new MinHeap(11); 
	    h.insertKey(3); 
	    h.insertKey(2); 
	    h.deleteKey(1); 
	    h.insertKey(15); 
	    h.insertKey(5); 
	    h.insertKey(4); 
	    h.insertKey(45);
	    
	    for(int i = 0; i < h.arr.length; i++) {
	    	System.out.print(h.arr[i] + ",");
	    }
	    System.out.println();
	    System.out.println(h.extractMin() + "<< "); 
	    System.out.println(h.getMin() + "<< "); 
	    h.decreaseKey(2, 1); 
	    System.out.println(h.getMin() + "<< ");
	}

}
