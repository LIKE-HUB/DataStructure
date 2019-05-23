import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> 
{
	private class Node
	{
		Node right,left;
		E e;
		public Node(E e)
		{			
			this.e=e;
			this.right=null;
			this.left=null;
		}		
	}
	private int size;
	private Node root;
	public BST()
	{
		root=null;
		size=0;
	}
	public  int getSize() 
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public void add(E e)
	{
		
		root=add(root,e);
		
	}
	//向以NODE为根的二分搜索树插入元素
	private Node add(Node node,E e)
	{
		if(node==null)
		{
			size++;
			return new Node(e);
		}
		if(e.compareTo(node.e)<0)
		node.left=add(node.left,e);
		else
			if(e.compareTo(node.e)>0)
			node.right=add(node.right,e);
			
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
		if(e.compareTo(node.e)==0)
			return true;
		else 
			if(e.compareTo(node.e)<0)
				return contains(node.left,e);
			else
				return contains(node.right,e);
	}
	public void preOrder()
	{
		preOrder(root);
	}
	private void preOrder(Node node)
	{
		if(node==null)
		return;
		System.out.println(node.e);		
			preOrder(node.left);
			preOrder(node.right);
			
	}
	public void preOrderNR()
	{
		Stack<Node> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node cur=stack.pop();
			System.out.println(cur.e);
			if(cur.right!=null)
				stack.push(cur.right);
			if(cur.left!=null)
				stack.push(cur.left);
		
		}
	}
	public void inOrder()
	{
		inOrder(root);
	}
	public void inOrder(Node node)
	{
		if(node==null)
			return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	public void postOrder()
	{
		postOrder(root);
	}
	private void postOrder(Node node)
	{
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	public void levelOrder()
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node cur=q.remove();
			System.out.println(cur.e);
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
	}
	public E minnum()
	{
		if(size==0)
			throw new IllegalArgumentException("BST is empty");
		return minnum(root).e;
	}
	public Node minnum(Node node)
	{
		if(node.left==null)
			return node;
			return minnum(node.left);
	}
	public E maxnum()
	{
		if(size==0)
			throw new IllegalArgumentException("empty");
		return maxnum(root).e;
	}
	public Node maxnum(Node node)
	{
		if(node.right==null)
			return node;
		return maxnum(node.right);
	}
	public E removeMax()
	{
		E ret=maxnum();
		root=removeMax(root);
		return ret;
	}
	public Node removeMax(Node node)
	{
		if(node.right==null)
		{
			Node leftNode=node.left;
			node.left=null;
			size--;
			return leftNode;
		}
		removeMax(node.right);
		return node;
	}
	
	public E removeMin()
	{
		E ret=minnum();
		//从以root为根的二分搜索树中删除了最小值
		//最后又返回删除掉最小值之后二分搜索树的根节点
		root=removeMin(root);
		return ret;
		
	}
	//删除二分搜索树中最小节点 
	//返回删除节点后二分搜索树的跟
	public Node removeMin(Node node)
	{
		if(node.left==null)
		{
			Node rightNode=node.right;
			node.right=null;
			size--;
			return rightNode;
		}
		node.left=removeMin(node.left);
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
			node.left=remove(node.left,e);
			return node;
		}else
		{
			if(e.compareTo(node.e)>0)
			{
				node.right=remove(node.right,e);
				return node;
			}
			else {
				//相等
				if(node.left==null)
				{
					Node rightNode=node.right;
					node.right=null;
					size--;
					return rightNode;
				}
				if(node.right==null)
				{
					Node leftNode=node.left;
					node.left=null;
					size--;
					return leftNode;
				}
				else
				{
					Node successor=minnum(node.right);
					successor.right=removeMin(node.right);
					successor.left=node.left;
					node.left=node.right=null;
					return successor;
				}
			}
		}
	
	}
	
	@Override
	public String toString()
	{
		StringBuilder res=new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	//生成深度为depth的二叉树字符串
	private void generateBSTString(Node node,int depth,StringBuilder res)
	{
		if(node==null)
		{
			res.append(generateDepthString(depth)+"null\n");
			return;
		}
		res.append(generateDepthString(depth)+node.e+"\n");
		generateBSTString(node.left,depth+1,res);
		generateBSTString(node.right,depth+1,res);
	}
	private String generateDepthString(int depth)
	{
		StringBuilder res=new StringBuilder();
		for(int i=0;i<depth;i++)
		{
			res.append("--");
		}
		return res.toString();
	}
}
