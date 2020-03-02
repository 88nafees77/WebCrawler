package test;

import java.util.*;

public class WebGraph {
	UrlFinder finder = new UrlFinder();

	public void createGraphDfs(String url, Map<String, Set<String>> map, Set<String> visited, int max_depth) {
		if (max_depth == 0)
			return;
		List<String> listOfUrl = finder.getUrl(url);
		map.putIfAbsent(url, new HashSet<String>());
		map.get(url).addAll(listOfUrl);
		for (String urll : listOfUrl) {
			if (!visited.contains(urll)) {
				visited.add(urll);
				createGraphDfs(urll, map, visited, max_depth - 1);
			}
		}

	}

	public void createGraphBfs(String url, Map<String, Set<String>> map, Set<String> visited, int max_depth) {
		Queue<String> queue = new LinkedList<>();
		queue.add(url);
		while (!queue.isEmpty() && max_depth != 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String newurl = queue.poll();
				if (!visited.contains(newurl)) {
					visited.add(newurl);
					List<String> listOfUrl = finder.getUrl(newurl);
					map.putIfAbsent(newurl, new HashSet<String>());
					map.get(newurl).addAll(listOfUrl);
					queue.addAll(listOfUrl);
				}
			}
			max_depth--;
		}
	}

	public int maxCycle(String url, Map<String, Set<String>> map, Map<String, Integer> visited, int count) {
		if (!map.containsKey(url))
			return 0;
		if (visited.containsKey(url)) {
			return count - visited.get(url);
		}
		visited.put(url, count);
		int max = -1;
		for (String str : map.get(url)) {
			max = Math.max(max, maxCycle(str, map, visited, count + 1));
		}
		visited.remove(url);
		return max;
	}

}