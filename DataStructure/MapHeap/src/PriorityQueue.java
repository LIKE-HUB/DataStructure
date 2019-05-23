
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;
	public PriorityQueue()
	{
		maxHeap=new MaxHeap<>();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return maxHeap.extractMax();
	}
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return maxHeap.findMax();
	}

}
