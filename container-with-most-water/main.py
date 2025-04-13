class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        l = 0
        r = len(height) - 1
        max = 0

        while l < r:
            min_value = min(height[l], height[r])
            volume = min_value * (r - l)
            if volume > max:
                max = volume
            if min_value == height[l]:
                l+=1
            else:
                r-=1

        return max


def main():
    s = Solution()
    assert 49 == s.maxArea([1,8,6,2,5,4,8,3,7])
    assert 1 == s.maxArea([1,1])



if __name__ == "__main__":
    main()
