package test;

import java.util.*;

public class WebGraph extends Graph {
	UrlFinder finder = new UrlFinder();
	String url;

	public WebGraph(String url) {
		this.url = url;
	}

	public void createGraph(int max_depth) {
		createGraph(url, graph, visited, max_depth - 1);

	}

	private void createGraph(String url, Map<String, Set<String>> graph, Set<String> visited, int max_depth) {
		if (max_depth == 0)
			return;
		List<String> listOfUrl = finder.getUrl(url);
		graph.putIfAbsent(url, new HashSet<String>());
		graph.get(url).addAll(listOfUrl);
		for (String urll : listOfUrl) {
			if (!visited.contains(urll)) {
				visited.add(urll);
				createGraph(urll, graph, visited, max_depth - 1);
			}
		}
	}

	public void travserseGraph(String start) {
		travserseGraph(start, graph, visited);
	}

	private void travserseGraph(String url, Map<String, Set<String>> graph, Set<String> visited) {
		Queue<String> queue = new LinkedList<>();
		queue.add(url);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String newurl = queue.poll();
				if (!visited.contains(newurl)) {
					visited.add(newurl);
					System.out.println(newurl);
					List<String> listOfUrl = finder.getUrl(newurl);
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
