import math

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """

        # Turn int to string
        x_str = str(x)

        # Reverse the characters
        x_str_rev = reverse_string(x_str)


        # Turn back into int
        x_int = int(x_str_rev)

        # Check if it's a 32 bit integer
        # Return 0 if not 32 bit integer
        return x_int if is_32_bit_signed_int(x_int) else 0


def is_32_bit_signed_int(x):
    return int(-1 * math.pow(2, 31)) <= x <= int(math.pow(2, 31) - 1)



def reverse_string(s):
    r = ""
    if int(s) < 0:
        r += "-"
    for i in range(len(s)-1, -1, -1):
        if s[i] == '-':
            continue
        r += s[i]
    return r


def main():
    s = Solution()
    assert s.reverse(123) == 321, s.reverse(123)
    assert s.reverse(-123) == -321, s.reverse(-123)
    assert s.reverse(1563847412) == 0, s.reverse(1563847412)


if __name__ == "__main__":
    main()
