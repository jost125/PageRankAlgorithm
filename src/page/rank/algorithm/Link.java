package page.rank.algorithm;

public class Link implements Comparable<Link> {
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

	@Override
	public int compareTo(Link link) {
		return new Integer(this.hashCode()).compareTo(link.hashCode());
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + target;
		hash = hash * 31 + numberOfLinks;

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Link other = (Link) obj;
		if (this.target != other.target && (this.target == null || !this.target.equals(other.target))) {
			return false;
		}
		if (this.numberOfLinks != other.numberOfLinks && (this.numberOfLinks == null || !this.numberOfLinks.equals(other.numberOfLinks))) {
			return false;
		}
		return true;
	}
}
