import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 1000000;

	        MapHeap<Integer> maxHeap = new MapHeap<>();
	        Random random = new Random();
	        for(int i = 0 ; i < n ; i ++)
	            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

	        int[] arr = new int[n];
	        for(int i = 0 ; i < n ; i ++)
	            arr[i] = maxHeap.extractMax();

	        for(int i = 1 ; i < n ; i ++)
	            if(arr[i-1] < arr[i])
	                throw new IllegalArgumentException("Error");

	        System.out.println("Test MaxHeap completed.");
	}

}
