import re

class Solution(object):
    def isPalindrome(self, s):
        s = re.sub("[^a-z0-9]*", "", s.lower())
        left = 0
        right = len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left+=1
            right-=1

        return True

def main():
    s = Solution()
    assert not s.isPalindrome("abc 123 !@#$")
    assert not s.isPalindrome("abcd")
    assert s.isPalindrome("mom")
    assert s.isPalindrome("dad")
    assert s.isPalindrome("")
    assert s.isPalindrome(" ")
    assert s.isPalindrome("121")
    assert s.isPalindrome("11")
    assert s.isPalindrome("1")
 

if __name__ == "__main__":
    main()
