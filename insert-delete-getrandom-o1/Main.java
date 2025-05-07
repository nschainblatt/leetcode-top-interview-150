import java.util.*;

public class Main {
	public static void main(String[] args) {

		RandomizedSet obj = new RandomizedSet();

		for (int i = 100; i > 0; i--) {
			if (i % 10 == 0) {
				obj.print();
			}
			assert obj.insert(i);
		}
		assert obj.insert(-1);
		obj.print();

		assert obj.contains(-1);
		assert obj.contains(100);
		obj.print();
		assert obj.remove(100);
		assert obj.remove(-1);
		assert !obj.contains(100);
		assert !obj.contains(-1);
		obj.print();

		System.out.println(obj.getRandom());

	}
}

// Hash Map and a List
// Hash map key is the value being inserted, the value is the index it is being
// added to in the list
// When removing an item, swap the index to remove with the last item in the
// list, and then finally delete the last element in the list
// to achieve removal in constant time.

class RandomizedSet {

	private final Map<Integer, Integer> map = new HashMap<>();
	private final List<Integer> list = new ArrayList<>();
	private final Random r = new Random();

	public RandomizedSet() {
	}

	public void print() {
		System.out.printf("MAP: %s, LIST: %s", map, list);
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		int index = list.size(); // This is the future index it will be in the list
		list.add(val);
		map.put(val, index);
		return true;
	}

	public boolean remove(int val) {
		if (map.containsKey(val) && !list.isEmpty()) {
			int index = map.get(val);
			int lastVal = list.get(list.size() - 1);
			list.set(index, lastVal);
			map.put(lastVal, index);
			list.remove(list.size() - 1);
			map.remove(val);
			return true;
		}
		return false;
	}

	public boolean contains(int val) {
		return map.containsKey(val);
	}

	public int getRandom() {
		return list.get(r.nextInt(list.size()));
	}
}
