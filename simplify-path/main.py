
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        # stack
        # find first slash, loop until no more slashes
        # read word until next slash
        # add word to stack
        # find slash, loop until no more slashes
        # repeat
        # if you encounter . do nothing, this references current
        # if you encounter .. pop off stack and continue
        # build the canonical path at the end with whats in the stack (can optimize later)

        stack = []

        i = 0
        while i < len(path):
            while i < len(path) and path[i] == "/":
                i+=1

            # i is now at first non-slash
            file = ""
            while i < len(path) and path[i] != "/":
                file += path[i]
                i+=1

            if file == ".":
                i+=1
                continue
            elif file == '..':
                if len(stack) > 0:
                    stack.pop()
            elif len(file):
                stack.append(file)

            i+=1

        canonical_path = "/"
        for index, file in enumerate(stack):
            if index != len(stack) - 1:
                canonical_path += file + "/"
            else:
                canonical_path += file

        return canonical_path


def main():
    s = Solution()
    assert "/.../b/d" == s.simplifyPath("/...//a/..///b/c/..////d/./")
    assert "/" == s.simplifyPath("/../..")
    assert "/" == s.simplifyPath("/..")
    assert "/" == s.simplifyPath("/")



if __name__ == "__main__":
    main()
