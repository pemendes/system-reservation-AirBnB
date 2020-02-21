package mendes.airbnb.menu;

public class ClassGenerique<T> {
	
	private T higher;
	private T lower;
	
	public ClassGenerique(T higher, T lower) {
		this.higher = higher;
		this.lower = lower;
	}

	public T getHigher() {
		return higher;
	}

	public T getLower() {
		return lower;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		ClassGenerique<T> other = (ClassGenerique<T>) obj;
		if (higher == null) {
			if (other.higher != null)
				return false;
		} else if (!higher.equals(other.higher))
			return false;
		if (lower == null) {
			if (other.lower != null)
				return false;
		} else if (!lower.equals(other.lower))
			return false;
		return true;
	}
}
