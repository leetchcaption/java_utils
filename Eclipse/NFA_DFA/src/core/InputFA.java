package core;

import java.util.Scanner;
import util.InputUtil;

public class InputFA {

	public FA input() {
		FA nfa = new FA();
		Scanner scanner = new Scanner(System.in);

		// 输入所有的状态
		inputNodes(scanner, nfa);
        inputEdges(scanner, nfa);
		return nfa;
	}

	public void inputNodes(Scanner scanner, FA nfa) {
		// 共有多少种状态
		System.out.print("一个有多少种状态：     ");
		int stateNum = InputUtil.inputNum(scanner);

		boolean hasBeginState = false;
		for (int i = 0; i < stateNum; i++) {
			Node node = new Node();
			node.setIndex(i + 1);
			System.out.println("请输入第" + (i + 1) + "个状态的信息:");
			System.out.print("   状态的名称:  ");
			node.setNodeName(scanner.next());
			// 还没有初态时才会询问是否是初态
			if (!hasBeginState) {
				System.out.print("   是否是初态(Y/N)?:  ");
				if (scanner.next().trim().equalsIgnoreCase("Y")) {
					node.setBeginNode(true);
					hasBeginState = true;
				}
			}
			//是否为终态
			System.out.print("   是否是终态(Y/N)?:  ");
			if (scanner.next().trim().equalsIgnoreCase("Y")) {
				node.setEndNode(true);
			}
			nfa.getNodes().add(node);
		}
		// 如果所有的输入中没有初始状态，则输入错误
		if (!hasBeginState) {
			System.out.println("这不是一个有穷自动机，因为没有初始状态，系统错误退出!");
			System.exit(0);
		}
	}

	// 输入所有的边
	public void inputEdges(Scanner scanner, FA nfa) {
		System.out.print("一个有多少条边：     ");
		int edgeNum = InputUtil.inputNum(scanner);
		for (int i = 0; i < edgeNum; i++) {
			System.out.println("请输入第" + (i + 1) + "条边的信息:");
			Edge edge = new Edge();
			System.out.print("   边的名称(&表示空串):  ");
			edge.setEdgeName(scanner.next().trim());
			System.out.print("   从第几个状态开始?:  ");
			edge.setBeginIndex(InputUtil.inputNumBetweenAandB(scanner, 1, nfa
					.getNodes().size()));
			System.out.print("   从第几个状态结束?:  ");
			edge.setEndIndex(InputUtil.inputNumBetweenAandB(scanner, 1, nfa
					.getNodes().size()));
			nfa.getEdges().add(edge);
		}
	}
}
