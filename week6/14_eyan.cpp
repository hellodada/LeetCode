string longestCommonPrefix(vector<string>& strs) {
    if (strs.size()==0)
        return string();
    string prefix= strs[0];
    int prefix_len = prefix.length();
    for (int i=1; i<strs.size(); ++i) {
        int j=0;
        string& st= strs[i];
        int st_len = st.length();
        while (j<prefix_len && j<st_len && prefix[j]==st[j]) { ++j; }
        if (j< prefix_len) {
            prefix = prefix.substr(0,j);
            prefix_len = j;
            if (prefix_len==0) break;
        }
    }
    return prefix;
}