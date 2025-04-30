import math


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """

        x_str_rev = str(x)[::-1]
        if x_str_rev[-1] == '-':
            x_str_rev = '-' + x_str_rev[:-1]

        x_int = int(x_str_rev)

        return x_int if is_32_bit_signed_int(x_int) else 0


def is_32_bit_signed_int(x):
    return int(-1 * math.pow(2, 31)) <= x <= int(math.pow(2, 31) - 1)


def main():
    s = Solution()
    assert s.reverse(123) == 321, s.reverse(123)
    assert s.reverse(-123) == -321, s.reverse(-123)
    assert s.reverse(1563847412) == 0, s.reverse(1563847412)


if __name__ == "__main__":
    main()
