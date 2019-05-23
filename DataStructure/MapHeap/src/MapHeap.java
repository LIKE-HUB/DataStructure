
public class MapHeap<E extends Comparable<E>> 
{	private Array<E> data;
	public MapHeap(int capacity)
	{
		data=new Array<>(capacity);		
	}
	public MapHeap()
	{
		data=new Array<>();
	}
	public MapHeap(E[] arr)
	{
		data=new Array<>(arr);
		for(int i=parent(arr.length)-1;i>=0;i--)
			siftDown(i);
	}
	
	public int size()	
	{
		return data.getSize();
	}
	public Boolean isEmpty()
	{
		return data.isEmpty();
	}
	private int parent(int index)
	{	if(index==0)
		throw new IllegalArgumentException("index");
		return (index-1)/2;
	}
	private int leftChild(int index)
	{
		return index*2+1;
	}
	private int rightChild(int index)
	{
		return index*2+2;
	}
	//鍚戝爢涓坊鍔犲厓绱�
	public void add(E e)
	{
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	private void siftUp(int k)
	{	while(k>0&&data.get(parent(k)).compareTo(data.get(k))<0)
		{
		data.swap(k, parent(k));
		k=parent(k);
		}
	}
	public E findMax()
	{
		if(data.getSize()==0)
			throw new IllegalArgumentException("can not find");
			return data.get(0);
	}
	//取出最大元素
	public E extractMax()
	{	E ret=findMax();
		data.swap(0, data.getSize()-1);
		data.removeLast();
		siftDown(0);
		return ret;		
	}
	private void siftDown(int k) 
	{
		
		while(leftChild(k)<data.getSize())
		{	int j=leftChild(k);
		//右节点存在且大于做节点 
			if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
				j++;
			//data[j]是最大值
			if(data.get(k).compareTo(data.get(j))>=0)
				break;
			//不符合堆性质 和最大节点交换
			data.swap(k, j);
			k=j;
		}
	}
	//取出堆中最大元素并且替换成源于e
	public E replace(E e)
	{
		E ret=findMax();
		data.set(0,e);
		siftDown(0);
		return ret;
	}
	
	
	
}
