class Solution {
public:
struct Node;

typedef Node* NodePtr; // there is a memory leak, for some reason there is no shared_ptr :)
typedef unordered_map<string, NodePtr> KeyNodeMapT;
typedef unordered_map<string, vector<string>> PrefixMapT;

struct Node {
    unordered_set<NodePtr> children;
    string word;
};

inline NodePtr getOrCreateNode(KeyNodeMapT& nodesMap, const string& word) {
    if (nodesMap.find(word) == nodesMap.end()) {
        auto node = new Node();
        node->word = word;
        nodesMap.insert(make_pair(node->word, node));
        return node;
    }

    return nodesMap.at(word);
}

string shift(const string& word, int sh) {
    if (sh == 0) {
        return word;
    }

    sh = sh % word.length();

    string shWord = word.substr(sh, word.npos) + word.substr(0, sh);

    return shWord;
}

KeyNodeMapT createGraphM(vector<string>& dict, size_t wordLength) {
    KeyNodeMapT nodesMap;

    for (const string& lword : dict) {
        getOrCreateNode(nodesMap, lword);
    }

    for (int sh = 0; sh < wordLength; sh++) {

        PrefixMapT prefixMap;

        for (const string& word : dict) {
            if (word.length() > 1) {
                string shWord = shift(word, sh);
                string shWordPrefix = shWord.substr(0, shWord.length() - 1);

                prefixMap[shWordPrefix].push_back(word);
            } else if (word.length() == 1) {
                prefixMap[""].push_back(word);
            }
        }

        for (const auto& pr : prefixMap) {
            const auto& vecOfSimilar = pr.second;
            if (vecOfSimilar.size() > 1) {
                for (const auto& lword : vecOfSimilar) {
                    auto lnode = getOrCreateNode(nodesMap, lword);

                    for (const auto& rword : vecOfSimilar) {
                        if (lword != rword) {
                            auto rnode = getOrCreateNode(nodesMap, rword);
                            lnode->children.insert(rnode);
                            rnode->children.insert(lnode);
                        }
                    }
                }
            }
        }
    }

    return nodesMap;
}

int dijkstra(const KeyNodeMapT& nodes, const string& start, const string& end) {
    unordered_map<string, int> costs;

    for (const auto& node : nodes) {
        costs[node.first] = INT_MAX;
    }

    const auto& startNode = nodes.at(start);
    costs.at(startNode->word) = 0;

    int cost = 1;
    unordered_set<NodePtr> children = startNode->children;

    while (children.size() > 0) {

        unordered_set<NodePtr> grandsons;

        for (const auto& child : children) {
            if (costs.at(child->word) > cost) {
                costs[child->word] = cost;
            }

            for (const auto& grandson : child->children) {
                if (costs.at(grandson->word) > cost + 1) {
                    grandsons.insert(grandson);
                }
            }
        }

        cost++;
        children = std::move(grandsons);

    }

    return costs.at(end);
}

int ladderLength(string start, string end, unordered_set<string> &dict) {
    vector<string> wordsV(dict.begin(), dict.end());
    wordsV.push_back(start);
    wordsV.push_back(end);

    size_t wordSize = wordsV[0].length();

    auto nodes = createGraphM(wordsV, wordSize);
    int length = dijkstra(nodes, start, end);

    if (length == INT_MAX) return 0;

    return length + 1;
}

};