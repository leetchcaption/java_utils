package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//有穷自动机是一种图的结构
public class FA extends Graph {

	// 得到有穷自动机中所有的节点，找到开始结点
	public Node getBeginNode() {
		Node beginNode = null;
		List<Node> allNodes = getNodes();
		for (int i = 0; i < allNodes.size(); i++) {
			if (allNodes.get(i).isBeginNode()) {
				beginNode = allNodes.get(i).clone();
				break;
			}
		}
		return beginNode;
	}

	
	// 有穷自动机的一个状态通过若干个空串得到的所有状态的集合
	public Set<Node> getStateSetcrossAnyEmpty(int index) {
		Set<Node> initialNodes = new HashSet<Node>();

		// 每个节点都初始化为没访问
		boolean visited[] = new boolean[getNodes().size() + 1];
		for (int i = 0; i < getNodes().size()+1; i++)
			visited[i] = false;

		// 开始状态是初态
	    Node beginNode=this.getNodeById(index);
		initialNodes.add(beginNode);
		visited[beginNode.getIndex()] = true;

		// 初始化栈
		Stack<Integer> visitStack = new Stack<Integer>();
		visitStack.push(beginNode.getIndex());

		// 通过开始节点经过经过若干个空串得到的状态都是初态
		while (!visitStack.isEmpty()) {
			int v = visitStack.pop().intValue();
			for (int i = 0; i < getEdges().size(); i++) {
				// 如果一个节点没被访问，并且边为空串时则加入栈
				Edge edge=getEdges().get(i);
				if (visited[edge.getEndIndex()] == false
						&& edge.getBeginIndex() == v
						&& edge.getEdgeName().equals("&")) {
                    visited[edge.getEndIndex()]=true;
                    initialNodes.add(this.getNodeById(edge.getEndIndex()));
                    visitStack.push(edge.getEndIndex());
				}
			}
		}
		return initialNodes;
	}
	
	//一个状态集stateSet通过一个输入a到达的另一个状态的集合
	public Set<Node> getStateSetcrossA(Set<Node> input,String name){
		
		//得到的状态集
		Set<Node> output=new HashSet<Node>();
		Iterator<Node> iterator=input.iterator();
		while(iterator.hasNext()){
			Node n=iterator.next().clone();
			for(int i=0;i<getEdges().size();i++){
				Edge e=getEdges().get(i);
				//如果通过的边是a，则将结点加入集合
				if(e.getBeginIndex()==n.getIndex()&&e.getEdgeName().equals(name)){
					output.add(getNodeById(e.getEndIndex()));
				}
			}
		}
		return output;
	}
	
	//一个状态集经过若干个空串后得到的所有状态的集合
	public Set<Node> getAllStateSetcrossAnyEmpty(Set<Node> input) {
		Set<Node> output=new HashSet<Node>();
		Iterator<Node> iterator=input.iterator();
		//将状态集中的所有状态迭代出来
		while(iterator.hasNext()){
			int index=iterator.next().getIndex();
			//每迭代出一个，得到这一个节点经过若干个空串所能到达的状态集加入output中
			Set<Node> s=getStateSetcrossAnyEmpty(index);
			Iterator<Node> n=s.iterator();
			while(n.hasNext()){
				output.add(n.next());
			}
		}
		return output;
	}
	
	//一个状态集中的状态经过若干条&符和一条a符和若干条&条所经过的所有状态的集合
	public Set<Node> getAllStateCrossEmptyAEmpty(Set<Node> input,String a){
		Set<Node> output=new HashSet<Node>();
		Iterator<Node> iterator=input.iterator();
		while(iterator.hasNext()){
			Set<Node> s1=getStateSetcrossAnyEmpty(iterator.next().getIndex());
			Set<Node> s2=getStateSetcrossA(s1,a);
			Iterator<Node> iterator2=s2.iterator();
			while(iterator2.hasNext()){
				Set<Node> s3=getStateSetcrossAnyEmpty(iterator2.next().getIndex());
				Iterator<Node> iterator3=s3.iterator();
				while(iterator3.hasNext()){
					output.add(iterator3.next());
				}
			}
		}
		return output;
	}
	
	//得到所有的边的集合
	public Set<Edge> getAllDifferentEdge(FA fa){
		Set<Edge> set=new HashSet<Edge>();
		for(int i=0;i<fa.getEdges().size();i++){
			if(!fa.getEdges().get(i).getEdgeName().trim().equals("&")){
				set.add(fa.getEdges().get(i));
			}
		}
		return set;
	}
	
}
