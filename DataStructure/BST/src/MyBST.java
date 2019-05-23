import java.util.LinkedList;
import java.util.Queue;

public class MyBST<E extends Comparable> {
	private class Node
	{
		E e;
		Node leftNode;
		Node rightNode;
		Node(E e)
		{
			this.e=e;
		}
	}
	Node root;
	int size;
	public int getSize()
	{
		return size;
	}
	public Boolean isEmpty()
	{
		return size==0;
	}
	public void add(E e)
	{
		root=add(root,e);
	}
	private Node add(Node node,E e)
	{
		if(node==null)
			{
			node=new Node(e);
			size++;
			return node;
			}
		else
		{
			if(e.compareTo(node.e)<0)
				node.leftNode=add(node.leftNode,e);
			if(e.compareTo(node.e)>0)
				node.rightNode=add(node.rightNode,e);
		}
		return node;
	}	
	public boolean contains(E e)
	{
		return contains(root,e);
	}
	private boolean contains(Node node,E e)
	{
		if(node==null)
			return false;
			if(e.compareTo(node.e)<0)
				return contains(node.leftNode,e);
			else if(e.compareTo(node.e)>0)
				return contains(node.rightNode,e);
			else 
				return true;
			
	}
	public void preOrder()
	{
		preOrder(root);
	}
	public void preOrder(Node node)
	{
		if(node==null)
			System.out.println(node.e);
		preOrder(node.leftNode);
		preOrder(node.rightNode);
	}
	public void levelOrder()
	{
		Queue<Node> q=new LinkedList();
		if(root!=null)
			q.add(root);
		while(q!=null)
		{
			Node cur=q.remove();
			System.out.println(cur.e);
			if(cur.leftNode!=null)
				q.add(cur.leftNode);
			if(cur.rightNode!=null)
				q.add(cur.rightNode);
		}
	}
	public E minmun()
	{
		if(size==0)
			throw new IllegalArgumentException("size=0");
		return minnum(root).e;
	}
	private Node minnum(Node node)
	{
		if(node.leftNode==null)
			return node;
		return minnum(node.leftNode);
	}
	public E removeMin()
	{	
		E ret=minmun();		
		removeMin(root);
		return ret;
	}
	private Node removeMin(Node node)
	{
		if(node.leftNode==null)
		{
			Node ret=node.rightNode;
			node.rightNode=null;
			size--;
			return ret;
		}
		node.leftNode=removeMin(node);
		return node;
	}
	public void remove(E e)
	{
		root=remove(root,e);
	}
	private Node remove(Node node,E e)
	{
		if(node==null)
			return null;
		if(e.compareTo(node.e)<0)
		{
			node.leftNode=remove(node.leftNode,e);
			return node;
		}
		else if(e.compareTo(node)>0)
			{
				node.rightNode=remove(node.rightNode,e);
				return node;
			}
		else
			{
				Node successor=minnum(node);
				successor.leftNode=node.leftNode;
				successor.rightNode=removeMin(node);
				size--;
			}
		return node;
		
		
	}
}
