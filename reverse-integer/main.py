SIGNED_INT_MIN = -1 * (1 << 31)
SIGNED_INT_MAX = (1 << 31) - 1


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        reversed_int_string = str(x)[::-1]
        reversed_int_string = fix_trailing_sign(
            reversed_int_string)
        reversed_x = int(reversed_int_string)

        return reversed_x if is_32_bit_signed_int(reversed_x) else 0


def is_32_bit_signed_int(x):
    return SIGNED_INT_MIN <= x <= SIGNED_INT_MAX


def fix_trailing_sign(s):
    if s[-1] == '-':
        s = '-' + s[:-1]
    return s


def main():
    s = Solution()
    assert s.reverse(123) == 321, s.reverse(123)
    assert s.reverse(-123) == -321, s.reverse(-123)
    assert s.reverse(1563847412) == 0, s.reverse(1563847412)


if __name__ == "__main__":
    main()
