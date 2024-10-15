public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (this.rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList curList = this;
		int total = 1;
		while (curList.rest != null) {
			curList = curList.rest;
			total++;
		}
		return total;
	}

	/** Returns the ith item of this IntList. */
	public int get(int idx) {
		assert  0 <= idx && idx < this.iterativeSize();
		int start = 0;
		IntList curList = this;
		while (start != idx) {
			curList = curList.rest;
			start++;
		}
		return curList.first;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
	}
} 