class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if not s:
            return True

        s_pointer = 0
        for c in t:
            if s_pointer == len(s): # Reached last character to check
                break
            if c == s[s_pointer]:
                s_pointer+=1

        return s_pointer == len(s)


def main():
    s = Solution()
    assert s.isSubsequence("", "ahbgdc")
    assert s.isSubsequence("abc", "ahbgdc")
    assert not s.isSubsequence("axc", "ahbgdc")


if __name__ == "__main__":
    main()
