package NewGraph;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class UrlFinder {
	public Set<String> getUrl(String currentUrl) {
		Set<String> urls = new HashSet<>();
		try {
			Connection connection = Jsoup.connect(currentUrl);
			Document htmlDocument = connection.get();
			Elements linksOnPage = htmlDocument.select("a[href]");
			for (Element element : linksOnPage) {
				urls.add(element.absUrl("href"));
			}
			return urls;
		} catch (Exception e) {
		}
		return urls;
	}

}
