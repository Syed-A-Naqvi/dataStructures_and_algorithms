#include <fstream>
#include <map>
#include <string>
#include <iostream>
#include <queue>
#include <vector>

// main node structure to be used for the huffman's process
struct Node {
    
    Node* left = nullptr;
    Node* right = nullptr;

    std::string c = "\0";
    int freq = 0;

    Node(std::string character, int frequency): c(character), freq(frequency){}
    Node(int frequency):freq(frequency){}
    Node(){}

    void printNode(){
        std::cout<<"Node:\n" << "Character: " << c << "\nCount: " << freq << std::endl;
    }

};
// comparator for the priority queue to be able to compare custom Node objects
struct CompareNodes {
    bool operator()(const Node& a, const Node& b) {
        return a.freq > b.freq;
    }
};


// main huffman encoding algorithm implemented by this class
class HuffmanEncoding {

    private:

        // used to store charater-count and character-encoding pairs
        std::map<std::string, int> frequencyMap;
        std::map<std::string, std::string> encodingMap;

        // storing the root of the Huffman's encoding tree
        Node* root;

        // traversing Huffman's tree and populating encoding map
        void addbit(Node* node, std::string encoding){
            if (node == nullptr){
                return;
            }

            std::string lPath = encoding + "0";
            addbit(node->left, lPath);
            std::string rPath = encoding + "1";
            addbit(node->right, rPath);

            if((node->right == nullptr) && (node->left == nullptr)){
                encodingMap[node->c] = encoding;
            }
            
        }

        // performs Huffman's encoding to build prefix tree
        void encode(){

            // priority queue, implemented as MinHeap using custom comparator
            std::priority_queue<Node, std::vector<Node>,CompareNodes> charPQ;

            // populating the MinHeap
            for(const auto& pair : frequencyMap){
                Node character(pair.first, pair.second);
                charPQ.push(character);
            }

            // building Huffman's tree using the minHeap (HUFFMAN ALGORITHM)
            while( !(charPQ.size() == 1) ){
                
                Node* x = new Node();
                (*x) = charPQ.top();
                charPQ.pop();

                Node* y = new Node();
                (*y) = charPQ.top();
                charPQ.pop();

                Node z(x->freq+y->freq);
                z.left = x;
                z.right = y;

                charPQ.push(z);

            }
            (*root) = charPQ.top();

            // builing the character encoding map
            std::string encoding = "";
            addbit(root, encoding);

        }       

    public:
        // constructor
        HuffmanEncoding(std::map<std::string, int> C):frequencyMap(C){
            root = new Node();
            encode();
        }

        // print original characters and their frequencies
        void printFreq(){
            std::cout << "CHARACTER FREQUENCIES-----------------------------\n";
            for(auto& pair: frequencyMap){
                std::cout << "Character: " << pair.first << "  Count: " << pair.second << std::endl;
            }
            std::cout <<"Document size before using prefix codes: "
                      << root->freq*8 << " bits  (Assuming 8-bit ASCII encodings)" << std::endl;
        }
        // print encodings
        void printEncodings(){
            std::cout << "CHARACTER PREFIX CODES----------------------------\n";
            
            int size=0;
            for(auto& pair: encodingMap){
                std::cout << "Character: " << pair.first << "  Encoding: " << pair.second << std::endl;
                size += (pair.second.size() * frequencyMap[pair.first]);
            }        
            std::cout <<"Document size after using prefix codes: " << size << " bits" << std::endl;
        }
};

int main(int argc, char* argv[]) {
    //ensuring successful file read
    if (argc < 2) {
        std::cerr << "Please provide a filename as an argument.\n";
        return 1;
    }
    std::ifstream file(argv[1]);
    if (!file) {
        std::cerr << "Failed to open file.\n";
        return 1;
    }
    // creating character frequency table by reading from file and incrementing associated value
    std::map<std::string, int> frequencies;
    char c;
    while (file.get(c)) {
        if(c == '\n'){
            frequencies["\\n"]++;
        }
        else if (c == ' '){
            frequencies["space"]++;
        }
        else{
            std::string temp(1,c);
            frequencies[temp]++;
        }
    }

    // generating Huffman's encodings
    HuffmanEncoding encoding(frequencies);
    //printing results
    encoding.printFreq();
    std::cout << std::endl;
    encoding.printEncodings();

    return 0;
}