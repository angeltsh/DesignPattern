package templatemethod.demo1;

/**
 * ģ�巽��ģʽ
 */
public class Duck implements Comparable<Object> {
	String name;
	int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name + " weighs " + weight;
	}

	@Override
	public int compareTo(Object object) {
		Duck otherDuck = (Duck) object;

		if (this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight == otherDuck.weight) {
			return 0;
		} else {
			return 1;
		}
	}
}