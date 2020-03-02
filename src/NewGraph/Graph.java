package NewGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	private Map<Node<T>, Set<Node<T>>> adgecencyList = new HashMap<Node<T>, Set<Node<T>>>();

	public void addEdge(Edge<T> edge) {
		adgecencyList.putIfAbsent(edge.getFrom(), new HashSet<Node<T>>());
		adgecencyList.get(edge.getFrom()).add(edge.getTo());
	}

	public boolean hasEdge(Node<T> from, Node<T> to) {
		if (adgecencyList.containsKey(from)) {
			return adgecencyList.get(from).contains(to);
		}
		return false;
	}

	public Set<Node<T>> getAllConnectedNodes(Node<T> from) {
		return adgecencyList.get(from);
	}

	public int maxCycle(Node<T> start) {
		int count = 0;
		return maxCycle(start, new HashMap<Node<T>, Integer>(), count);
	}

	private int maxCycle(Node<T> node, Map<Node<T>, Integer> visitedList, int count) {
		if (!adgecencyList.containsKey(node))
			return 0;
		if (visitedList.containsKey(node)) {
			return count - visitedList.get(node);
		}
		visitedList.put(node, count);
		int max = -1;
		for (Node<T> to : getAllConnectedNodes(node)) {
			max = Math.max(max, maxCycle(to, visitedList, count + 1));
		}
		visitedList.remove(node);
		return max;
	}
}
