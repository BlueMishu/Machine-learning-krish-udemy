#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <set>
using namespace std;

// BFS function to find the shortest path
int bfs(vector<vector<int>>& grid, int M, int N, pair<int, int> source, pair<int, int> destination, pair<int, int> move_rule) {
    // Define the possible moves (forward, right, left, back)
    vector<pair<int, int>> moves = {
        {move_rule.first, move_rule.second},                   // Forward
        {move_rule.second, -move_rule.first},                  // Right (90 degrees clockwise)
        {-move_rule.second, move_rule.first},                  // Left (90 degrees anticlockwise)
        {-move_rule.first, -move_rule.second}                  // Backward (180 degrees)
    };

    // BFS queue (stores x, y coordinates and the number of steps taken)
    queue<tuple<int, int, int>> q;
    set<pair<int, int>> visited;

    // Start BFS from the source
    q.push({source.first, source.second, 0});
    visited.insert({source.first, source.second});

    while (!q.empty()) {
        int x, y, steps;
        tie(x, y, steps) = q.front();
        q.pop();

        // If we reached the destination, return the number of steps
        if (x == destination.first && y == destination.second) {
            return steps;
        }

        // Explore all possible moves
        for (auto move : moves) {
            int new_x = x + move.first;
            int new_y = y + move.second;

            // Check if the new position is within the grid and valid (not visited and not blocked)
            if (new_x >= 0 && new_x < M && new_y >= 0 && new_y < N && grid[new_x][new_y] == 0 && visited.find({new_x, new_y}) == visited.end()) {
                visited.insert({new_x, new_y});
                q.push({new_x, new_y, steps + 1});
            }
        }
    }

    // If no path found, return -1 (although the problem doesn't specify unreachable conditions)
    return -1;
}

int main() {
    int M, N;
    cin >> M >> N;

    // Reading the grid
    vector<vector<int>> grid(M, vector<int>(N));
    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> grid[i][j];
        }
    }

    // Reading source, destination and move rule
    pair<int, int> source, destination, move_rule;
    cin >> source.first >> source.second;
    cin >> destination.first >> destination.second;
    cin >> move_rule.first >> move_rule.second;

    // Perform BFS and print the result
    int result = bfs(grid, M, N, source, destination, move_rule);
    cout << result << endl;

    return 0;
}