package page.rank.algorithm;

import java.util.Set;

public class Page {
	private Set<Link> links;

	public Page(Set<Link> links) {
		this.links = links;
	}

	public Set<Link> getLinks() {
		return links;
	}

}
