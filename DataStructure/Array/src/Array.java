public class Array<T> {
	private int size;
	private T [] data ;
	public Array(int capaCity)	
	{
		data=(T[])new Object[capaCity];
		size=0;
	
	}
	public Array() 
	{
	   this(10);
	}
	public void addLast(T i)
	{	if(size==data.length)
		resize(2*size);
		add(size,i);
	
	}
	public void add(int index,T e)
	{	
		if(size==data.length)
			resize(2*size);
		for(int i=size-1;i>=index;i--)
		{
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}
	public void addFirst(T e)
	{	if(size==data.length)
		resize(2*size);
		add(0,e);
	}
	public int getSize()
	{
		return size;
	}
	public int getCapaCity()
	{
		return data.length;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public T get(int index)
	{	if(index<0||index>=size)
		throw new IllegalArgumentException("failed");
		return data[index];
	}
	public boolean contains(T e)
	{ 
		for(int i=0;i<size;i++)
		{
			if(e.equals(data[i]))
			return true;
			
		}
			return false;
	}
	public void remove(int index)
	{	
		if(size==data.length/4)
			resize(data.length/2);
		for(int i = 0;i<data.length;i++)
		{
			data[i-1]=data[i];
			size--;
		}
	}
	public void removeFirst()
	{
		remove(size);
	}
	public void removeLast()
	{
		remove(size);
	}
	public void resize(int capaCity)
	{
		T [] newData=(T [])new Object[capaCity];
		for(int i=0;i<data.length;i++)
		{
			newData[i]=data[i];
		}
		data=newData;
	}
	@Override
	public String toString()
	{
		StringBuilder res=new StringBuilder();
		res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
		res.append('[');
		for(int i=0;i<size;i++)
		{
			res.append(data[i]);
			if(i!=size-1)
				res.append(",");
		}
		res.append("]");
		return res.toString();
	}
	public static void main(String args[])
	{
		Array<Integer> arr=new Array<>(20);
		for(int i=0;i<30;i++)
		{
			arr.addLast(i);
		}
		System.out.println(arr);
	}
}
