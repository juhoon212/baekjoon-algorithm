#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
// 1 ~ N
// 트리
// 두노드의 쌍이 주어졌을 때 lca를 구하라

static int N, M;
static std::vector <std::vector<int> > tree;
static std::vector <int> depth;
static int kmax;
static int parent[21][1000001];
static std::vector<bool> visited;

void bfs(int node);
int executeLca(int a, int b);

int main() {

    std::ios::sync_with_stdio(false);


   std::cin.tie(NULL);
   std::cout.tie(NULL);

   std::cin >> N;
   tree.resize(N + 1);

   for (int i = 0; i < N - 1; i++) {
        int s, e;
        
        std::cin >> s >> e;
        tree[s].push_back(e);
        tree[e].push_back(s);
    }

    depth.resize(N + 1);
    visited.resize(N + 1);

    //N이 노드의 개수
    int temp = 1;
    kmax = 0;

    while (temp < N) {
        temp <<= 1;
        kmax++;
    }

    bfs(1);

    for (int k = 1; k <= kmax; k++) {
        for (int n = 1; n <= N; n++) {
            parent[k][n] = parent[k - 1][parent[k-1][n]];
        }
    }

    std::cin >> M;

    for (int i = 0; i < M; i++) {
        int a, b;
        std::cin >> a >> b;
        int lca = executeLca(a, b);
        std::cout << lca << "\n";
    }

    

    return 0;
}

void bfs(int node) {
    std::queue<int> myqueue;
    myqueue.push(node);
    visited[node] = true;
    int level = 1;
    int now_size = 1;
    int count = 0;

    while (!myqueue.empty()) {
        int now_node = myqueue.front();
        myqueue.pop();
        for (int next : tree[now_node]) {
            if (!visited[next]) {
                visited[next] = true;
                myqueue.push(next);
                parent[0][next] = now_node;
                depth[next] = level;
            }
        }
        count++;
        if (count == now_size) {
            count = 0;
            now_size = myqueue.size();
            level++;
        }
        
    }
}

int executeLca(int a, int b) {
    
    if (depth[a] > depth[b]) {
        int temp = a;
        a = b;
        b = temp;
    }
    // 깊이 맞추기
    for (int k = kmax; k >= 0; k--) {
        if (pow(2, k) <= depth[b] - depth[a]) {
            b = parent[k][b];
        }
    }

    // 동시에 올라가면서 조상 찾기 => 빠르게
    
    for (int k = kmax; k >= 0; k--) {
        if (parent[k][a] != parent[k][b]) {
            a = parent[k][a];
            b = parent[k][b];
        }
    }

    int lca = a;
    if (a != b) {
        lca = parent[0][lca];
    }

    return lca;
}