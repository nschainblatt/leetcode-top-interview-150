from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        triplets = []
        nums.sort()

        i = 0
        while i < len(nums):

            if nums[i] > 0:
                break

            if i > 0 and nums[i] == nums[i - 1]:
                i += 1
                continue

            l = i + 1
            r = len(nums) - 1

            while l < r:
                if nums[l] + nums[r] < -nums[i]:
                    l += 1
                elif nums[l] + nums[r] > -nums[i]:
                    r -= 1
                else:
                    triplets.append([nums[i], nums[l], nums[r]])
                    l += 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1

            i += 1

        return triplets


def main():
    s = Solution()
    assert [[-1, -1, 2], [-1, 0, 1]] == s.threeSum([-1, 0, 1, 2, -1, -4]), s.threeSum(
        [-1, 0, 1, 2, -1, -4]
    )


if __name__ == "__main__":
    main()
