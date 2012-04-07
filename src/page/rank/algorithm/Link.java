package page.rank.algorithm;

public class Link {
	private Integer target;
	private Integer numberOfLinks;

	public Link(Integer target, Integer numberOfLinks) {
		this.target = target;
		this.numberOfLinks = numberOfLinks;
	}

	public Integer getTarget() {
		return target;
	}

	public Integer getNumberOfLinks() {
		return numberOfLinks;
	}

	
}
