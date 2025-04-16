class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """

        sum = 0
        left = 0
        min_length = len(nums) + 1

        for right, num in enumerate(nums):
            sum += num
            while sum >= target:
                min_length = min(min_length, right - left + 1)
                sum -= nums[left]
                left += 1

        return min_length % (len(nums) + 1)


def main():
    s = Solution()
    assert 2 == s.minSubArrayLen(7, [2, 3, 1, 2, 4, 3])
    assert 0 == s.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1])
    assert 1 == s.minSubArrayLen(4, [1, 2, 3, 4])


if __name__ == "__main__":
    main()
