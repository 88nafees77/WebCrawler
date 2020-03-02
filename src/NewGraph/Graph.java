package NewGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	private Map<Vertex<T>, Set<Vertex<T>>> adgecencyList = new HashMap<Vertex<T>, Set<Vertex<T>>>();

	public void addEdge(Edge<T> edge) {
		adgecencyList.putIfAbsent(edge.getFrom(), new HashSet<Vertex<T>>());
		adgecencyList.get(edge.getFrom()).add(edge.getTo());
	}

	public boolean hasEdge(Vertex<T> from, Vertex<T> to) {
		if (adgecencyList.containsKey(from)) {
			return adgecencyList.get(from).contains(to);
		}
		return false;
	}

	public Set<Vertex<T>> getAllConnectedNodes(Vertex<T> from) {
		return adgecencyList.get(from);
	}

	public int maxCycle(Vertex<T> start) {
		int count = 0;
		return maxCycle(start, new HashMap<Vertex<T>, Integer>(), count);
	}

	private int maxCycle(Vertex<T> node, Map<Vertex<T>, Integer> visitedList, int count) {
		if (!adgecencyList.containsKey(node))
			return 0;
		if (visitedList.containsKey(node)) {
			return count - visitedList.get(node);
		}
		visitedList.put(node, count);
		int max = -1;
		for (Vertex<T> to : getAllConnectedNodes(node)) {
			max = Math.max(max, maxCycle(to, visitedList, count + 1));
		}
		visitedList.remove(node);
		return max;
	}
}
