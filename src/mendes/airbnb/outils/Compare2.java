package mendes.airbnb.outils;

import java.util.ArrayList;

public class Compare2<T extends Comparable> {

	private ArrayList<T> list;

	public Compare2() {
		super();

		list = new ArrayList<>();
	}

	public Compare2(T obj1, T obj2) {
		super();

		list = new ArrayList<>();
		add(obj1);
		add(obj2);
	}

	public void add(T obj) {

		list.add(obj);
	}

	public boolean remove(T obj) {

		return list.remove(obj);
	}

	public T getHigher() {

		T max = null;
		int maxValue = Integer.MIN_VALUE;

		for (T t : list) {
			if (t.getValueToCompare() > maxValue) {

				maxValue = t.getValueToCompare();
				max = t;
			}
		}

		return max;
	}

	public T get(int indice) {
		return list.get(indice);
	}

}