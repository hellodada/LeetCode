class Solution {
public:
    std::string intToRoman(int num) {
        std::vector<char> sign(7);
        sign[0] = 'M';
        sign[1] = 'D';
        sign[2] = 'C';
        sign[3] = 'L';
        sign[4] = 'X';
        sign[5] = 'V';
        sign[6] = 'I';
        std::string res(num / 1000, 'M');
        for (int i = 1000, j = 0; j != 3; ++j, i /= 10) {
            int bit = (num % i) / (i / 10);
            if (bit % 5 < 4) {
                if (bit / 5) {
                    res += sign[1 + 2 * j];
                }
                res += std::string(bit % 5, sign[2 + 2 * j]);
            } else {
                res += sign[2 + 2 * j];
                res += sign[1 + 2 * j - bit / 5];
            }
        }
        return res;
    }
};