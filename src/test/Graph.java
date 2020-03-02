package test;

import java.util.*;

public class Graph {
	public Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
	public Set<String> visited = new HashSet<>();
	public Map<String, Integer> visitedList = new HashMap<String, Integer>();

}