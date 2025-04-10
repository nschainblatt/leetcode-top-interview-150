import re

class Solution(object):
    def isPalindrome(self, s):
        left = 0
        right = len(s) - 1
        while left < right:
            if not is_character_or_number(s[left]):
                left+=1
            elif not is_character_or_number(s[right]):
                right-=1
            elif s[left].lower() != s[right].lower():
                return False
            else:
                left+=1
                right-=1

        return True


def is_character_or_number(s):
    return re.match("[A-Za-z0-9]", s)

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
