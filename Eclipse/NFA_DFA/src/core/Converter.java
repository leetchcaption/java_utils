package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Converter {

	public static FA NFAConvertToDFA(FA nfa) {
        List<MySet> left=getLeftSetList(nfa);
        //Ϊÿһ����ߵļ���ȡһ������
        System.out.println("ת���ɵ�DFA���£�");
        System.out.print("״̬��Ϊ:     {");
        for(int i=0;i<left.size();i++){
        	left.get(i).setSetName("A"+i);
        	System.out.print("A"+i+"   ");
        }
        System.out.println("}");
        
        //��¼��̬��
        System.out.print("��̬��Ϊ:     {");
        for(int i=0;i<left.size();i++){
        	//��������а�����һ����̬����˼���Ϊ��̬
        	MySet mySet=left.get(i);
        	Iterator<Node> iterator1=mySet.iterator();
        	boolean hasFound=false;
        	while(iterator1.hasNext()){
        		String name1=iterator1.next().getNodeName();
        		for(int j=0;j<nfa.getNodes().size();j++){
        			if(nfa.getNodes().get(j).isEndNode()&&name1.trim().equals(nfa.getNodes().get(j).getNodeName().trim())){
        				hasFound=true;
        				break;
        			}
        		}
        		if(hasFound)
        			break;
        	}
        	if(hasFound){
        		System.out.print(left.get(i).getSetName()+"  ");
        	}
        }
        System.out.println("}");
        
        //������еı�
        System.out.println("���е�ת����ʽΪ��   ");
        for(int i=0;i<left.size();i++){
        	Set<Edge> e = nfa.getAllDifferentEdge(nfa);
			Iterator<Edge> edgeIterator = e.iterator();
			while(edgeIterator.hasNext()){
				Edge edge=edgeIterator.next();
				Set<Node> nodes = nfa.getAllStateCrossEmptyAEmpty(left.get(i),
						edge.getEdgeName());
				MySet myset=new MySet().SetConvertToMySet(nodes);
				//����ұߵļ��ϲ�Ϊ�գ������ȥ���Ǹ���ͬ�Ĳ�ȡ����
				if(!myset.isEmpty()){
					for(int k=0;k<left.size();k++){
						if(myset.equals(left.get(k))){
							myset.setSetName(left.get(k).getSetName());
							System.out.println(left.get(i).getSetName()+"---"+edge.getEdgeName()+"--->"+myset.getSetName());
							break;
						}
					}
				}
			}
        	
        }
		return null;
	}

	public static List<MySet> getLeftSetList(FA nfa) {
		
		// ���ȵõ��ӳ�ʼ״̬����������&���õ���״̬��
		int beginIndex = nfa.getBeginNode().getIndex();
		Set<Node> s = nfa.getStateSetcrossAnyEmpty(beginIndex);

		ArrayList<MySet> list = new ArrayList<MySet>();
		list.add(new MySet().SetConvertToMySet(s));
		//������
		int i=0;
		while(i<list.size()){
			Set<Edge> e = nfa.getAllDifferentEdge(nfa);
			Iterator<Edge> edgeIterator = e.iterator();
			while (edgeIterator.hasNext()) {
				Edge ed = edgeIterator.next();
				Set<Node> nodes = nfa.getAllStateCrossEmptyAEmpty(list.get(i),
						ed.getEdgeName());
				MySet myset = new MySet().SetConvertToMySet(nodes);
				
				// ������ұ߳��ֵļ��ϲ�Ϊ�ղ��������û���ֹ��������
				if (!myset.isEmpty()) {
					boolean hasFound = false;
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k).equals(myset)) {
							hasFound = true;
							break;
						}
					}
					if (!hasFound) {
						list.add(myset);
					}
				}
			}
			i++;
		}
		return list;
	}
}
