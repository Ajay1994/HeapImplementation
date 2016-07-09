import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap(10);
		int[] array = {4, 1, 9, 10, 25, 47, 13, 18, 8, 12};
		//heap.buildHeap(array);
		//heap.printHeap();
		/*heap.deleteMaximum();
		heap.printHeap();
		heap.insertKey(100);
		heap.printHeap();
		heap.insertKey(150);
		heap.printHeap();*/
		heap.heapSort(array);
		heap.printHeap();
		
		Queue<Integer> queue = new PriorityQueue<Integer>(2, 
					new Comparator<Integer>() {
						@Override
						public int compare(Integer num1, Integer num2) {
							// TODO Auto-generated method stub
							if(num1 > num2) return 1;
							else if (num2 > num1) return -1;
							return 0;
						}});
		for(int i = 0; i < 10; i++){
			queue.add(i);
		}
		System.out.println("Min : "+ queue.peek());
	}

}
