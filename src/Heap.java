
public class Heap {
	int[] array;
	int capacity;
	int heap_size;
	public Heap(int capacity){
		this.capacity = capacity;
		this.heap_size = 0;
		this.array = new int[capacity];
	}
	public int getParent(int i){
		if(i == 0 || i >= this.heap_size) return -1;
		else return (i-1)/2;
	}
	
	public int getLeftChild(int i){
		int leftChild = (i * 2) + 1;
		if(leftChild >= heap_size) return -1;
		return leftChild; 
	}
	public void swap(int i, int j){
		int temp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = temp;
	}
	public int getRightChild(int i){
		int rightChild = (i * 2) + 2;
		if(rightChild >= heap_size) return -1;
		return rightChild;
	}
	public int getMaximum(){
		if(this.heap_size == 0) return Integer.MIN_VALUE;
		else return this.array[0];
	}
	public void max_heapify(int index){
		int left = getLeftChild(index);
		int right = getRightChild(index);
		int largest = index;
		if(left != -1 && this.array[left] > this.array[largest]) largest = left;
		if(right != -1 && this.array[right] > this.array[largest]) largest = right;
		if(largest != index){
			swap(largest, index);
			max_heapify(largest);
		}
	}
	public void insertKey(int key){
		if(this.capacity == this.heap_size) resizeHeap();
		this.array[this.heap_size] = key;
		this.heap_size++;
		int i = this.heap_size - 1;
		while(i > 0 && this.array[i] > this.array[getParent(i)]){
			swap(i, getParent(i));
			i = getParent(i);
		}
	}
	public int deleteMaximum(){
		if(this.heap_size <= 0) return -1;
		int max = this.array[0];
		swap(0, heap_size - 1);
		heap_size -= 1;
		max_heapify(0);
		return max;
	}
	private void resizeHeap() {
		int temp[] = new int[this.capacity * 2];
		for(int i = 0; i < this.capacity; i++){
			temp[i] = this.array[i];
		}
		this.array = temp;
		this.capacity *= 2;
	}
	public void buildHeap(int[] array){
		this.array = array;
		this.capacity = array.length;
		this.heap_size = array.length;
		for(int i = (this.heap_size / 2); i >= 0; i--) max_heapify(i);
	}
	public void heapSort(int[] array){
		buildHeap(array);
		for(int i = this.capacity - 1; i >= 0; i--){
			int max = deleteMaximum();
			this.array[i] = max;
		}
		this.heap_size = this.capacity;
	}
	public void printHeap(){
		for(int i = 0; i < this.heap_size; i++){
			System.out.print(this.array[i] + " | ");
		}
		System.out.println();
	}
}
