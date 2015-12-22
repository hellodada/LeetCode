class Solution {
public:
void    buildPartition(string &s, int pos, vector<vector<string> > &res, vector<vector<bool> > &isPal, vector<string> &curP)
{
    int len, sSize = s.size();

    if(pos>= sSize) 
    {
        res.push_back(curP); 
        return;
    }

    for(len=1; len<= sSize-pos; len++)
    { 
        if(isPal[pos][len])
        { 
            curP.push_back(s.substr(pos, len));  
            buildPartition(s, pos+len, res, isPal, curP);
            curP.pop_back(); 
        }
    }
}    
    vector<vector<string>> partition(string s) {
        vector<vector<string> > res;
        int sSize = s.size();
        if(sSize > 0)
        {
            vector<vector<bool> > isPal(sSize, vector<bool>(sSize + 1, true)); 
            int i, len;
            vector<string> curP;

   
            for(i =0; i<sSize-1; i++) isPal[i][2] = (s[i] == s[i+1]); 
            for(len=3; len<=sSize; len++)
            {
                for(i =0; i< (sSize-len + 1); i++) isPal[i][len] = (s[i] == s[i+len-1]) && isPal[i+1][len-2];
            }

            buildPartition(s, 0, res, isPal, curP);

        }
        return res;
    }
};