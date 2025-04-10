class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """

        left, right = 0, len(numbers) - 1

        while left < right:
            v = numbers[left] + numbers[right]
            if v == target:
                return [left+1, right+1]
            if v < target:
                left += 1
            else:
                right -= 1

        raise Exception()


def main():
    s = Solution()
    assert [1, 4] == s.twoSum([1, 1, 2, 3], 4)
    assert [5, 6] == s.twoSum([1, 1, 1, 2, 4, 5], 9)

if __name__ == "__main__":
    main()
