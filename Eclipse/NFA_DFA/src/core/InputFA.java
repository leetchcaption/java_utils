package core;

import java.util.Scanner;
import util.InputUtil;

public class InputFA {

	public FA input() {
		FA nfa = new FA();
		Scanner scanner = new Scanner(System.in);

		// �������е�״̬
		inputNodes(scanner, nfa);
        inputEdges(scanner, nfa);
		return nfa;
	}

	public void inputNodes(Scanner scanner, FA nfa) {
		// ���ж�����״̬
		System.out.print("һ���ж�����״̬��     ");
		int stateNum = InputUtil.inputNum(scanner);

		boolean hasBeginState = false;
		for (int i = 0; i < stateNum; i++) {
			Node node = new Node();
			node.setIndex(i + 1);
			System.out.println("�������" + (i + 1) + "��״̬����Ϣ:");
			System.out.print("   ״̬������:  ");
			node.setNodeName(scanner.next());
			// ��û�г�̬ʱ�Ż�ѯ���Ƿ��ǳ�̬
			if (!hasBeginState) {
				System.out.print("   �Ƿ��ǳ�̬(Y/N)?:  ");
				if (scanner.next().trim().equalsIgnoreCase("Y")) {
					node.setBeginNode(true);
					hasBeginState = true;
				}
			}
			//�Ƿ�Ϊ��̬
			System.out.print("   �Ƿ�����̬(Y/N)?:  ");
			if (scanner.next().trim().equalsIgnoreCase("Y")) {
				node.setEndNode(true);
			}
			nfa.getNodes().add(node);
		}
		// ������е�������û�г�ʼ״̬�����������
		if (!hasBeginState) {
			System.out.println("�ⲻ��һ�������Զ�������Ϊû�г�ʼ״̬��ϵͳ�����˳�!");
			System.exit(0);
		}
	}

	// �������еı�
	public void inputEdges(Scanner scanner, FA nfa) {
		System.out.print("һ���ж������ߣ�     ");
		int edgeNum = InputUtil.inputNum(scanner);
		for (int i = 0; i < edgeNum; i++) {
			System.out.println("�������" + (i + 1) + "���ߵ���Ϣ:");
			Edge edge = new Edge();
			System.out.print("   �ߵ�����(&��ʾ�մ�):  ");
			edge.setEdgeName(scanner.next().trim());
			System.out.print("   �ӵڼ���״̬��ʼ?:  ");
			edge.setBeginIndex(InputUtil.inputNumBetweenAandB(scanner, 1, nfa
					.getNodes().size()));
			System.out.print("   �ӵڼ���״̬����?:  ");
			edge.setEndIndex(InputUtil.inputNumBetweenAandB(scanner, 1, nfa
					.getNodes().size()));
			nfa.getEdges().add(edge);
		}
	}
}
