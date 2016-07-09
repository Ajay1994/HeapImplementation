import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class HeapNode{
	int data;
	int row;
	int col;
	public HeapNode(int data, int row, int col){
		this.data = data;
		this.row = row;
		this.col = col;
	}
}
public class MergeKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = { {1, 3, 5, 7},
	            		{2, 4, 6, 8},
	            		{0, 9, 10, 11}
	            	  };
		int rows = array.length;
		int cols = array[0].length;
		//Rows indicate #of arrays
		Queue<HeapNode> heap = new PriorityQueue<HeapNode>(rows, new Comparator<HeapNode>(){
							public int compare(HeapNode num1,HeapNode  num2){
								if(num1.data > num2.data) return 1;
								else if(num1.data < num2.data) return -1;
								else return 0;
							}

		});
		
		int[] result = new int[rows * cols];
		for(int i = 0; i < rows; i++){
			heap.add(new HeapNode(array[i][0], i, 0));
		}
		for(int i = 0; i < result.length; i++){
			HeapNode node = heap.remove();
			result[i] = node.data;
			
			if(node.col + 1 >= cols) heap.add(new HeapNode(Integer.MAX_VALUE, node.row, node.col));
			else{
				heap.add(new HeapNode(array[node.row][node.col + 1], node.row, node.col + 1));
			}
		}
		for(int i = 0; i< result.length; i++){
			System.out.print(result[i]+ " | ");
		}
		
	}

}
