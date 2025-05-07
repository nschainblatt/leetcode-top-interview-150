class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 0 if target <= nums[0] else 1

        return binary_search(nums, target, 0, len(nums) - 1)


def binary_search(nums, target, l, r):
    if l > r:
        return r + 1
    m = (r + l) // 2
    if nums[m] > target:
        r = m - 1
    elif nums[m] < target:
        l = m + 1
    else:
        return m
    return binary_search(nums, target, l, r)


def main():
    s = Solution()
    assert 0 == s.searchInsert([], 1)
    assert 0 == s.searchInsert([2], 2)
    assert 0 == s.searchInsert([2], 1)
    assert 1 == s.searchInsert([1], 2)
    assert 2 == s.searchInsert([1, 3, 5, 6], 5)
    assert 3 == s.searchInsert([1, 3, 5, 6], 6)
    assert 1 == s.searchInsert([1, 3, 5, 6], 2)
    assert 3 == s.searchInsert([1, 3, 5, 7], 6)
    assert 4 == s.searchInsert([1, 3, 5, 7], 8)
    assert 0 == s.searchInsert([1, 3, 5, 7], 0)


if __name__ == "__main__":
    main()
