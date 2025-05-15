import re


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        for match in re.finditer(p, s):
            return match.group() == s
        return False


def main():
    s = Solution()
    assert not s.isMatch("aa", "a"), s.isMatch("aa", "a")
    assert s.isMatch("a", "a"), s.isMatch("a", "a")
    assert s.isMatch("ab", ".*"), s.isMatch("ab", ".*")
    assert s.isMatch("", ".*"), s.isMatch("", ".*")


if __name__ == "__main__":
    main()
