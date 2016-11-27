package core;

import java.util.ArrayList;
import java.util.List;

//ͼ�����ڵ�ͱߣ����бߵ��������Ϊ '&'���ʾ�մ�
public class Graph {

	private List<Node> nodes = new ArrayList<Node>();

	private List<Edge> edges = new ArrayList<Edge>();

	
	public List<Edge> getEdges() {
		return edges;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	// ����index�ҵ���Ӧ��Node
	public Node getNodeById(int index) {
		for (int i = 0; i < getNodes().size(); i++) {
			if (getNodes().get(i).getIndex() == index) {
				return getNodes().get(i).clone();
			}
		}
		return null;
	}
}
