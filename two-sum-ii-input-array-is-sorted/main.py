class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """

        # If element + maximum possible element is less than target, increase left
        new_num_index = 0
        left = 0
        while left < len(numbers):
            changed = False
            for right in range(left+1, len(numbers)):
                if numbers[new_num_index] == numbers[left] and numbers[new_num_index] != numbers[right]:
                    new_num_index = right
                    changed = True
                if numbers[left] + numbers[right] == target:
                    return [left+1, right+1]
            left = (new_num_index if changed else left + 1)

        raise Exception()

def main():
    s = Solution()
    assert [1, 4] == s.twoSum([1, 1, 2, 3], 4)
    assert [5, 6] == s.twoSum([1, 1, 1, 2, 4, 5], 9)

if __name__ == "__main__":
    main()
