package utilities;

public class Pair<T1, T2> {
	public final T1 first;   	// first field of a Pair
	public final T2 second;  	// second field of a Pair

	// Constructs a new Pair with specified values
	private Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}

	@Override
	// Checks specified object is "equal to" current object or not
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		// call equals() method of the underlying objects
		if (!first.equals(pair.first))
			return false;
		return second.equals(pair.second);
	}

	@Override
	// Computes hash code for an object to support hash tables
	public int hashCode() {
		// use hash codes of the underlying objects
		return 31 * first.hashCode() + second.hashCode();
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	// Factory method for creating a Typed Pair immutable instance
	public static <T1, T2> Pair <T1, T2> of(T1 a, T2 b) {
		// calls private constructor
		return new Pair<>(a, b);
	}
}