package test;

import java.util.*;

class WebGraph implements Graph {

	private Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

	private Set<String> visited = new HashSet<>();

	private Map<String, Integer> visitedList = new HashMap<String, Integer>();

	UrlFinder finder = new UrlFinder();
	String url;

	public WebGraph(String url) {
		this.url = url;
	}

	public void createGraph(int max_depth) {
		createGraph(url, graph, visited, max_depth);

	}

	private void createGraph(String url, Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		if (max_depth == 0)
			return;
		List<String> listOfUrl = finder.getUrl(url);
		visited.add(url);
		System.out.println(url);
		graph.putIfAbsent(url, new HashSet<String>());
		graph.get(url).addAll(listOfUrl);
		for (String urll : listOfUrl) {
			if (!visited.contains(urll)) {
				createGraph(urll, graph, visited, max_depth - 1);
			}
		}
	}

	public void traverseGraph(String start) {
		traverseGraph(start, graph, visited);
	}

	private void traverseGraph(String url, Map<String, Set<String>> graph, Set<String> visited) {
		Queue<String> queue = new LinkedList<>();
		queue.add(url);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String newurl = queue.poll();
				if (!visited.contains(newurl)) {
					visited.add(newurl);
					System.out.println(newurl);
					Set<String> listOfUrl = graph.get(newurl);
					graph.putIfAbsent(newurl, new HashSet<String>());
					graph.get(newurl).addAll(listOfUrl);
					queue.addAll(listOfUrl);
				}
			}

		}
	}

	public int maxCycle(String start) {
		int count = 0;
		return maxCycle(start, graph, visitedList, count);
	}

	private int maxCycle(String url, Map<String, Set<String>> cycleGraph, Map<String, Integer> visitedList, int count) {
		if (!cycleGraph.containsKey(url))
			return 0;
		if (visitedList.containsKey(url)) {
			return count - visitedList.get(url);
		}
		visitedList.put(url, count);
		int max = -1;
		for (String newUrl : cycleGraph.get(url)) {
			max = Math.max(max, maxCycle(newUrl, cycleGraph, visitedList, count + 1));
		}
		visitedList.remove(url);
		return max;
	}
}
