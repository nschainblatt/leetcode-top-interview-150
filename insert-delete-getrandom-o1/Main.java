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
		assert obj.remove(100);
		assert obj.remove(-1);
		assert !obj.contains(100);
		assert !obj.contains(-1);
		obj.print();

		System.out.println(obj.getRandom());

	}
}

class RandomizedSet {

	private List<List<Integer>> bucketHolder = new ArrayList<>();
	private final int defaultSize = 16;
	private int entryCount = 0;
	private final double maxLoadFactor = 0.75;
	private final Random r = new Random();

	public void print() {
		System.out.printf("Buckets: %d, Entries: %d, Load Factor: %f, Data: %s\n", bucketHolder.size(),
				entryCount, getLoadFactor(), bucketHolder);
	}

	public RandomizedSet() {
		expandBucketHolder(defaultSize);
	}

	private double getLoadFactor() {
		return entryCount / (double) bucketHolder.size();
	}

	public boolean insert(int val) {
		int hashKey = hashValue(val);
		List<Integer> bucket = bucketHolder.get(hashKey);
		for (int num : bucket) {
			if (num == val) {
				return false;
			}
		}
		bucket.add(val);
		entryCount++;
		// Check if we need to expand and re-hash
		if (getLoadFactor() > maxLoadFactor) {
			expandBucketHolder(bucketHolder.size());
			rehash();
		}
		return true;
	}

	private void expandBucketHolder(int size) {
		for (int i = 0; i < size; i++) {
			bucketHolder.add(new ArrayList<>());
		}
	}

	private void rehash() {
		List<List<Integer>> newBucketHolder = new ArrayList<>();
		for (int i = 0; i < bucketHolder.size(); i++) {
			newBucketHolder.add(new ArrayList<>());
		}

		for (List<Integer> bucket : bucketHolder) {
			for (int val : bucket) {
				int hashKey = hashValue(val);
				List<Integer> newBucket = newBucketHolder.get(hashKey);
				newBucket.add(val);
			}
		}

		bucketHolder = new ArrayList<>(newBucketHolder);
	}

	public boolean remove(int val) {
		int hashKey = hashValue(val);
		List<Integer> bucket = bucketHolder.get(hashKey);
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i) == val) {
				bucket.remove(i);
				entryCount--;
				return true;
			}
		}
		return false;
	}

	public boolean contains(int val) {
		int hashKey = hashValue(val);
		List<Integer> bucket = bucketHolder.get(hashKey);
		for (int num : bucket) {
			if (num == val) {
				return true;
			}
		}
		return false;
	}

	public int getRandom() {
		List<Integer> bucket;
		while (true) {
			int randomBucketIndex = r.nextInt(bucketHolder.size());
			List<Integer> randomBucket = bucketHolder.get(randomBucketIndex);
			if (randomBucket.isEmpty()) {
				continue;
			} else {
				bucket = randomBucket;
				break;
			}
		}
		int randomIndex = r.nextInt(bucket.size());
		return bucket.get(randomIndex);
	}

	private int hashValue(int value) {
		while (value < 0) {
			value += bucketHolder.size();
		}
		return value % bucketHolder.size();
	}
}
