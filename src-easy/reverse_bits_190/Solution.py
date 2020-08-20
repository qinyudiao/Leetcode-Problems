# reverse_bit_190

class Solution:
    def reverseBits(self, n):
        ret, power = 0, 31
        while n:
            ret += (n & 1) << power # retrieve bit 0 and shift it left to where it should be in ret
            n = n >> 1
            power -= 1
        return ret

print(Solution.reverseBits(Solution(), 43261596)) # 964176192
print(Solution.reverseBits(Solution(), 4294967293)) # 3221225471
