package NewGraph;

import test.TestGraph;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://www.geeksforgeeks.org/";
		WebCrowler crowler = new WebCrowler(url);
		Graph<String> graph = crowler.createGraph(4);
		System.out.println(graph.maxCycle(new Node<String>("A")));

	}
}
