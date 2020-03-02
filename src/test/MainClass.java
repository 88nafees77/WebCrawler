package test;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://google.com";
		Graph graph = new WebGraph(url);
		int max_depth = 2;
		((WebGraph) graph).createGraph(max_depth);
		((WebGraph) graph).travserseGraph(url);

	}
}
