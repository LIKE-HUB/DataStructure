import java.util.ArrayList;

public class BSTMap <K extends Comparable,V> implements Map<K,V>{
	private class Node
	{
		public Node right;
		public Node left;
		public K key;
		public V value;  
		public Node(K key,V value,Node left, Node right)
		{
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
		}
		public Node(K key,V value)
		{
			this(key,value,null,null);
		}
		public Node()
		{
			this(null,null,null,null);
		}
	}
	private Node root;
	private int size;
	public BSTMap()
	{
		root=new Node();
		size=0;
	}
	@Override
	public void add(K key, V value) {
		
		root=add(root,key,value);
	}
	private Node add(Node node,K key,V value)
	{
		if(node==null)
		{
			size++;
			return new Node(key,value);
		}
		if(key.compareTo(node.key)>0)
		{
			node.right=add(node.right,key,value);			
		}else if(key.compareTo(node.key)<0)
		{
			node.left=add(node.left,key,value);
		}
		else//相等
		node.value=value;
		return node;
	}

	@Override
	public V remove(K k) {
		Node node=getNode(root,k);
		if(node!=null)
		{
			root=remove(root,k);
		}
		return null;
	}
	private Node remove(Node node,K key)
	{
		if(node==null)
			return null;
		if(key.compareTo(node.key)<0)
			{
			node.left=remove(node.left,key);
			return node;
			}
			else if(key.compareTo(node.key)>0)
			{
				node.right=remove(node.right,key);
				return node;
			}
			else {
				//左子树为空
				if(node.left==null)
				{
					Node delNode=node.right;
					node.right=null;
					size--;
					return delNode;
				}
				if(node.right==null)
				{
					Node delNode=node.left;
					node.left=null;
					return delNode;
				}
				Node successor=minnum(node.right);
				successor.right=removeMin(node.right);
				successor.left=node.left;
				node.left=node.right=null;
				return successor;
			}
			
		
	}
	public V removeMin()
	{
		V ret=minnum();
		//从以root为根的二分搜索树中删除了最小值
		//最后又返回删除掉最小值之后二分搜索树的根节点
		root=removeMin(root);
		return ret;
		
	}
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
	public V minnum()
	{
		if(size==0)
			throw new IllegalArgumentException("BST is empty");
		return minnum(root).value;
	}
	public Node minnum(Node node)
	{
		if(node.left==null)
			return node;
			return minnum(node.left);
	}
	public V maxnum()
	{
		if(size==0)
			throw new IllegalArgumentException("empty");
		return maxnum(root).value;
	}
	public Node maxnum(Node node)
	{
		if(node.right==null)
			return node;
		return maxnum(node.right);
	}
	@Override
	public boolean contains(K k) {
		// TODO Auto-generated method stub
		return getNode(root,k)!=null;
	}

	@Override
	public V get(K k) {
		Node node=getNode(root,k);
		return node==null ? null: node.value;

	}

	@Override
	public void set(K k, V v) {
		Node node=getNode(root,k);
		if(node==null)
			throw new IllegalArgumentException(k+"dosent exit");
		node.value=v;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	private Node getNode(Node node,K key)
	{
		if(node==null)
			return null;
		if(key.compareTo(node.key)==0)
		return node;
		else if(key.compareTo(node.key)<0)
			return getNode(node.left,key);
		else
		{
			return getNode(node.right,key);
		}
	}
	public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
