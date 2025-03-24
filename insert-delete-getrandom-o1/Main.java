import java.util.*;

// TODO:
// Next step is to optimize the load factor:
// Increase the size of the underlying array whenever the load factor gets too high, you will also have to rehash every element becuase
// the ArrayList size changes.
// Improve the getRandom method by including probabilities between buckets (buckets with higher number of elements have a higher chance of getting randomly selected), I am not sure how much this part matters, we may be able to get away with just randomly choosing a bucket that isn't random, and then randomly choosing a element in that bucket.

public class Main {
	public static void main(String[] args) {

		RandomizedSet obj = new RandomizedSet();

		//boolean param_1 = obj.insert(1);
		//boolean param_2 = obj.remove(2);
		//boolean param_3 = obj.insert(2);
		//int param_4 = obj.getRandom();
		//boolean param_5 = obj.remove(1);
		//boolean param_6 = obj.insert(2);
		//int param_7 = obj.getRandom();

		//assert param_1;
		//assert !param_2;
		//assert param_3;
		//assert param_5;
		//assert !param_6;

		assert obj.insert(1);
		assert obj.insert(2);
		assert obj.insert(3);
		assert obj.insert(4);
		assert obj.insert(5);
		assert obj.insert(6);
		assert obj.insert(7);

		assert obj.insert(-1);
		obj.print();



		System.out.println(obj.getRandom());

	}
}


class RandomizedSet {

	private final List<List<Integer>> bucketHolder = new ArrayList<>();
	private final int defaultSize = 16;
	private final Random r = new Random();

	public void print() {
		System.out.println(bucketHolder);
	}

	public RandomizedSet() {
		for (int i = 0; i < defaultSize; i++) {
			bucketHolder.add(new ArrayList<>());
		}
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
		return true;
	}

	public boolean remove(int val) {
		int hashKey = hashValue(val);
		List<Integer> bucket = bucketHolder.get(hashKey);
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i) == val) {
				bucket.remove(i);
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

