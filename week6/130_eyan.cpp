class Solution {
public:
    void bfs(int i, int j, vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        queue<pair<int, int>> q;
        q.push(make_pair(i, j));
        while (!q.empty()) {
            auto top = q.front();
            q.pop();
            if (top.first >= 0 && top.first < n && top.second >= 0 && top.second < m && board[top.first][top.second] == 'O') {
                board[top.first][top.second] = '#';
                q.push(make_pair(top.first - 1, top.second));
                q.push(make_pair(top.first + 1, top.second));
                q.push(make_pair(top.first, top.second + 1));
                q.push(make_pair(top.first, top.second - 1));
            }
        }
    }

    void solve(vector<vector<char>>& board) {
        if (board.empty() || board[0].empty()) return;
        int n = board.size();
        int m = board[0].size();

        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') bfs(i, 0, board);
            if (board[i][m - 1] == 'O') bfs(i, m - 1, board);
        }

        for (int i = 0; i < m; ++i) {
            if (board[0][i] == 'O') bfs(0, i, board);
            if (board[n - 1][i] == 'O') bfs(n - 1, i, board);
        }

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (board[i][j] == '#') board[i][j] = 'O';
                else board[i][j] = 'X';
    }
};