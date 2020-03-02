package test;

import java.util.*;

public class Graph {
	UrlFinder finder = new UrlFinder();
	String url;

	public Graph(String url) {
		this.url = url;
	}

	public void createGraphDfs(Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		createGraphDfs(url, graph, visited, max_depth - 1);

	}

	private void createGraphDfs(String url, Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		if (max_depth == 0)
			return;
		List<String> listOfUrl = finder.getUrl(url);
		graph.putIfAbsent(url, new HashSet<String>());
		graph.get(url).addAll(listOfUrl);
		for (String urll : listOfUrl) {
			if (!visited.contains(urll)) {
				visited.add(urll);
				createGraphDfs(urll, graph, visited, max_depth - 1);
			}
		}
	}

	public void createGraphBfs(Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		createGraphBfs(url, graph, visited, max_depth);
	}

	private void createGraphBfs(String url, Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		Queue<String> queue = new LinkedList<>();
		queue.add(url);
		while (!queue.isEmpty() && max_depth != 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String newurl = queue.poll();
				if (!visited.contains(newurl)) {
					visited.add(newurl);
					List<String> listOfUrl = finder.getUrl(newurl);
					graph.putIfAbsent(newurl, new HashSet<String>());
					graph.get(newurl).addAll(listOfUrl);
					queue.addAll(listOfUrl);
				}
			}
			max_depth--;
		}
	}

	public int maxCycle(Map<String, Set<String>> graph, Map<String, Integer> visited) {
		 int count=0;
		return maxCycle(url, graph, visited, count);
	}

	private int maxCycle(String url, Map<String, Set<String>> graph, Map<String, Integer> visited, int count) {
		if (!graph.containsKey(url))
			return 0;
		if (visited.containsKey(url)) {
			return count - visited.get(url);
		}
		visited.put(url, count);
		int max = -1;
		for (String newUrl : graph.get(url)) {
			max = Math.max(max, maxCycle(newUrl, graph, visited, count + 1));
		}
		visited.remove(url);
		return max;
	}

}