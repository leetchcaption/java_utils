package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//�����Զ�����һ��ͼ�Ľṹ
public class FA extends Graph {

	// �õ������Զ��������еĽڵ㣬�ҵ���ʼ���
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

	
	// �����Զ�����һ��״̬ͨ�����ɸ��մ��õ�������״̬�ļ���
	public Set<Node> getStateSetcrossAnyEmpty(int index) {
		Set<Node> initialNodes = new HashSet<Node>();

		// ÿ���ڵ㶼��ʼ��Ϊû����
		boolean visited[] = new boolean[getNodes().size() + 1];
		for (int i = 0; i < getNodes().size()+1; i++)
			visited[i] = false;

		// ��ʼ״̬�ǳ�̬
	    Node beginNode=this.getNodeById(index);
		initialNodes.add(beginNode);
		visited[beginNode.getIndex()] = true;

		// ��ʼ��ջ
		Stack<Integer> visitStack = new Stack<Integer>();
		visitStack.push(beginNode.getIndex());

		// ͨ����ʼ�ڵ㾭���������ɸ��մ��õ���״̬���ǳ�̬
		while (!visitStack.isEmpty()) {
			int v = visitStack.pop().intValue();
			for (int i = 0; i < getEdges().size(); i++) {
				// ���һ���ڵ�û�����ʣ����ұ�Ϊ�մ�ʱ�����ջ
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
	
	//һ��״̬��stateSetͨ��һ������a�������һ��״̬�ļ���
	public Set<Node> getStateSetcrossA(Set<Node> input,String name){
		
		//�õ���״̬��
		Set<Node> output=new HashSet<Node>();
		Iterator<Node> iterator=input.iterator();
		while(iterator.hasNext()){
			Node n=iterator.next().clone();
			for(int i=0;i<getEdges().size();i++){
				Edge e=getEdges().get(i);
				//���ͨ���ı���a���򽫽����뼯��
				if(e.getBeginIndex()==n.getIndex()&&e.getEdgeName().equals(name)){
					output.add(getNodeById(e.getEndIndex()));
				}
			}
		}
		return output;
	}
	
	//һ��״̬���������ɸ��մ���õ�������״̬�ļ���
	public Set<Node> getAllStateSetcrossAnyEmpty(Set<Node> input) {
		Set<Node> output=new HashSet<Node>();
		Iterator<Node> iterator=input.iterator();
		//��״̬���е�����״̬��������
		while(iterator.hasNext()){
			int index=iterator.next().getIndex();
			//ÿ������һ�����õ���һ���ڵ㾭�����ɸ��մ����ܵ����״̬������output��
			Set<Node> s=getStateSetcrossAnyEmpty(index);
			Iterator<Node> n=s.iterator();
			while(n.hasNext()){
				output.add(n.next());
			}
		}
		return output;
	}
	
	//һ��״̬���е�״̬����������&����һ��a����������&��������������״̬�ļ���
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
	
	//�õ����еıߵļ���
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
