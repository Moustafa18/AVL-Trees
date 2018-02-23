
public class AVLTreeMethods {
	
	NodeImp root ;
	public NodeImp insert(NodeImp n ,Comparable key){
		if(n==null){
			n= new NodeImp<>(key);
		}else if(n.value.compareTo(key)<0){
			n=insert(n.left,key);
		}else if(n.value.compareTo(key)>0){
			n=insert(n.right,key);
		}
		
		n.height = getHeight(n);
		n.balance = getBalance(n);
		if(n.balance==2&&n.left.balance==1){
			rightRotate(n);
			return n;
			
		}else if(n.balance==2&&n.left.balance==-1){
			leftRotate(n.left);
			rightRotate(n);
			return n;
		}else if(n.balance==-2&&n.left.balance==1){
			rightRotate(n.right);
			leftRotate(n);
			return n;
			
		}else if (n.balance==-2&&n.left.balance==-1){
			leftRotate(n);
			return n;
			
		}else{
			//do nothing
		}
		
		
		
		
		return n;
		
	}
	public int getHeight(NodeImp n){
		if(n.left==null&&n.right==null){
			return 0;
		}else if(n.left==null){
			return n.left.height+1;
		}else if(n.right==null){
			return n.right.height+1;
		}else{
			return Math.max(n.left.height,n.right.height);
		}
		
		
	}
	public int getBalance(NodeImp n){
		if(n.left==null&&n.right==null){
			return 0;
		}else if(n.left==null){
			return n.left.height;
		}else if(n.right==null){
			return -n.right.height;
		}else{
			return n.left.height-n.right.height;
		}
		
	}
	public void leftRotate(NodeImp p){
		NodeImp q = p.right;
		NodeImp B = q.left;
		q.left = p;
		p.right=B;
		q.height= getHeight(q);
		p.height =getHeight(p);
		q.balance=getBalance(q);
		p.balance = getBalance(p);
		
	}
	public void rightRotate(NodeImp q){
		NodeImp p = q.left;
		NodeImp B = p.right;
		p.right = q;
		q.left=B;
		p.height= getHeight(q);
		q.height =getHeight(p);
		p.balance=getBalance(q);
		q.balance = getBalance(p);
		
	}
	

}
