#include "bits/stdc++.h"

using namespace std;

#define FAST_IO cin.tie(NULL)->sync_with_stdio(false)

int N, M, K;
int main()
{
   FAST_IO;

    cin >> N >> M >> K;

    vector<vector<int>> flower(K, vector<int>(2));
    for (auto& row : flower) for (auto& elem : row) cin >> elem, elem--;

    int max_dist = 0;
    if (K > 2)
    {
        for (int i = 0; i < K; i++)
        {
            int wise_dist = INT_MAX;
            for (int j = 0; j < K; j++) if (i != j)
            {
                int dx = max(flower[i][0] - flower[j][0] - 1, 0);
                int dy = max(flower[i][1] - flower[j][1] - 1, 0);
                int dist = (dx + 1) / 2 + (dy + 1) / 2;
                wise_dist = min(wise_dist, dist);
            }

            max_dist = max(max_dist, wise_dist);
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++) if (i * j == 0 || i == N - 1 || j == M - 1)
        {
            int edge_dist = INT_MAX;
            for (int k = 0; k < K; k++)
            {
                int dx = abs(flower[k][0] - i);
                int dy = abs(flower[k][1] - j);
                int dist = dx + dy;
                edge_dist = min(edge_dist, dist);
            }

            max_dist = max(max_dist, edge_dist);
        }
    }

    cout << max_dist << '\n';

   return 0;
}