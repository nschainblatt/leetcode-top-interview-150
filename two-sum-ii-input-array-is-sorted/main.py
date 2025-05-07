class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i, v in enumerate(numbers):
            t = target - v
            if t in d:
                return [d[t]+1, i+1]
            if v not in d:
                d[v] = i


def main():
    s = Solution()
    assert [1, 4] == s.twoSum([1, 1, 2, 3], 4), s.twoSum([1, 1, 2, 3], 4)
    assert [5, 6] == s.twoSum([1, 1, 1, 2, 4, 5], 9)

if __name__ == "__main__":
    main()
