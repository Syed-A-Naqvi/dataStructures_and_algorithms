#ifndef ZEROONE_H
#define ZEROONE_H

#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

//Item struct storing information for each item
struct Item {
    
    // inline static int count = 0;
    int number;
    float weight;
    float value;
    float ratio;

    //constructor
    Item(int num, float v, float w): /*number(++count)*/ number(num), value(v), weight(w){
        ratio = value/weight;
    }

    //destructor
    // ~Item() {
    //     --count;
    // }


};
//Nodes will be used to store the state of the current partial solution
struct Node {

    //current value in knapsack
    float runningValue;
    //remaining capacity of kanpsack
    float remainingCapacity;
    //heuristic upper bound (fractional knapsack value of remaining items)
    float heuristicUpperBound;

    //parent node pointer
    Node* parent = nullptr;
    //left child pointer
    Node* lChild = nullptr;
    //right child pointer
    Node* rChild = nullptr;

    //refers to index int sorted items vector in knapsackTree class
    int itemIndex = -1;
    //item added or not for current level
    bool itemAdded = false;
    //has node been pruned from future searches
    bool pruned = false;

    //constructor
    Node(float c, float r, float h): runningValue(c), remainingCapacity(r), heuristicUpperBound(h) {}

    //printNode
    void print(){
        std::cout << "running value: " << runningValue << std::endl;
        std::cout << "remaining capacity: " << remainingCapacity << std::endl;
        std::cout << "heuristic upper bound: " << heuristicUpperBound << std::endl;
        std::cout << "Item Index: " << itemIndex << std::endl;
        std::cout << "Item Added: " << itemAdded << std::endl;
        std::cout << "Pruned: " << pruned << std::endl;
    }
};


//Tree class to find solution for 0/1 knapsack problem
//  requires knapsack max capacity and item list
class ZeroOneKnapsack{

    private:
        
        //fields
        std::vector<Item> rankedItems;
        std::vector<Item> solutionSet;
        Node* rootNodePtr;
        Node* bestNodePtr;

    public:


        //methods

        //constructor
        //populates rankedItems with passed items vector and sorts based on item ratio
        //creates root node within initial remaining weight
        ZeroOneKnapsack(std::vector<Item>& items, float weight): rankedItems(items) {

            //sorting passed items based on value/weight ratios
            std::sort(rankedItems.begin(), rankedItems.end(), [](const Item& a, const Item& b){
                    return a.ratio > b.ratio;
                }
            );

            //setting up root node
            //remaining fractional of all items after index -1 is just all the items
            float initialHuersitic = getRemainingFractional(weight, -1);
            rootNodePtr = new Node(0, weight, initialHuersitic);

            //current best node is just the root
            bestNodePtr = rootNodePtr;

        }

        //returns a fractional knapsack value based on remaining weight and remaining items
        //of current partial solution
        float getRemainingFractional(float remainingWeight, int itemIndex){
            
            float fractionalValue = 0;
            
            //simple loop for determining the heurisitc upper bound based on
            //the remaining items and the remaining knapsack capacity
            for (auto i = rankedItems.begin() + itemIndex+1; i != rankedItems.end(); i++){
                
                if(i->weight <= remainingWeight){
                    fractionalValue += i->value;
                    remainingWeight -= i->weight;
                }
                else{
                    fractionalValue += i->ratio * remainingWeight;
                    break;
                }
            
            }

            return fractionalValue;
        }

        // returns the child with the highest hueristic upper bound
        Node* getBestChild(Node* parent){

            float lHU = parent -> lChild -> heuristicUpperBound;
            float rHU = parent -> rChild -> heuristicUpperBound;

            if(lHU > rHU){
                return parent -> lChild;
            }
            else{
                return parent -> rChild;
            }

        }

        //prunes the node from the tree if needed
        bool decidePrune(Node* node){
            if( node->heuristicUpperBound <= bestNodePtr->runningValue){
                node->pruned = true;
                return true;
            }
            return false;
        }

        //expends the passed node
        //returns 0 if no childs added, 1 if only right child added, 2 if both childs added
        //if 1 child added it will always be the right child since we can always not add an item
        int expand(Node* parentPtr){

            //numInserted
                //0 = no children added
                //1 = only right child added
                //2 = both children added
            int numInserted = 0;

            // does not add any children if parentPtr is a leaf node
            if(parentPtr->itemIndex == (rankedItems.size()-1)){
                return numInserted;
            }

            //current item index
            int i = (parentPtr->itemIndex) + 1;
            //current item
            Item& currItem = rankedItems[i];

            if (currItem.weight <= parentPtr->remainingCapacity){
                //We DO add the current item
                    numInserted++;
                    //defining node parameters
                    float newRunningValue = parentPtr->runningValue + currItem.value;
                    float newRemainingCap = parentPtr->remainingCapacity - currItem.weight;
                    float newUpperBound = newRunningValue + getRemainingFractional(newRemainingCap, i);
                    //creating node
                    Node* leftChildPtr = new Node(newRunningValue, newRemainingCap, newUpperBound);
                    leftChildPtr->itemAdded = true;
                    leftChildPtr->itemIndex = i;
                    //inserting node
                    leftChildPtr->parent = parentPtr;
                    parentPtr->lChild = leftChildPtr;
            }
                //We do NOT add the current item
                    numInserted++;
                    //creating node
                    Node* rightChildPtr
                        = new Node(parentPtr->runningValue,
                                   parentPtr->remainingCapacity,
                                   parentPtr->runningValue
                                   + getRemainingFractional(parentPtr->remainingCapacity, i));
                    rightChildPtr->itemIndex = i;
                    //inserting node
                    rightChildPtr->parent = parentPtr;
                    parentPtr->rChild = rightChildPtr;
            
            return numInserted;

        };

        //finds the best node by expanding a subtree
        //pass root node to get initial best
        void setBest(Node* nodePtr){

            //itereate for all remaining item idexes until we arrive at leaf nodes
            //or until both children's hueristic upper bounds are less than value of best node
            //update best only if we find a node with a greater value

            
            int numInserted = 0;
            do {
                //returns the number of inserted children
                numInserted = expand(nodePtr);

                switch (numInserted){
                    case 2:
                    {                        
                        // decide to prune children
                        decidePrune(nodePtr->rChild);
                        decidePrune(nodePtr->lChild);

                        // get the child with higher heuristic upper bound
                        Node* potentialBest = getBestChild(nodePtr);
                        
                        //if potential best has not been pruned reassign nodePtr
                        //else, subtree has no potential soultion, return
                        if(!potentialBest->pruned){nodePtr = potentialBest;}
                        else return;
                        
                        break;
                    }

                    case 1:
                    {
                        // decide to prune child
                        // there can only be a right child here
                        decidePrune(nodePtr->rChild);

                        //if right child has not been pruned reassign nodePtr
                        //else, subtree has no potential soultion, return
                        if(!nodePtr->rChild->pruned){nodePtr = nodePtr->rChild;}
                        else return;

                        break;
                    }

                    default:
                        break;
                }

            } while ( numInserted != 0); 

            // set new best node
            bestNodePtr = nodePtr;

        }

        //traverse tree from root
        //return the most promising childless node that should not be pruned
        void findPotentialBest(Node* node, Node*& pBest){
            if(node == nullptr || decidePrune(node)){
                return;
            }

            //left child traversal
            findPotentialBest(node->lChild, pBest);
            //right child traversal
            findPotentialBest(node->rChild, pBest);

            if(node->lChild == nullptr && node->rChild == nullptr){
                if (pBest->heuristicUpperBound < node->heuristicUpperBound){
                    pBest = node;
                }
            }
        }

        //find solution set
        void updateSolutionSet(){
            Node* nodePtr = bestNodePtr;

            while(nodePtr->itemIndex>-1){
                if (nodePtr->itemAdded){
                    solutionSet.insert(solutionSet.begin(), rankedItems[nodePtr->itemIndex]);
                }
                nodePtr = nodePtr->parent;
            };
        }

        //print items, 'R' for ranked set, 'S' for solution set
        void print(char list){
            switch (list)
            {
            case 'R':
                std::cout << "All items:\n[ ";
                for(auto& item: rankedItems){
                    std::cout << "Item"<< item.number << " ";
                }
                std::cout << "]" << std::endl;
                break;
            case 'S':
                std::cout << "Solution Set Items:\n[ ";
                for(auto& item: solutionSet){
                    std::cout << "Item" << item.number << " ";
                }
                std::cout << "]" << std::endl;
                break;
            default:
                break;
            }
        }

        //find solution
        void findSolution(){

            //finding an inital best node for our initial best solution
            setBest(rootNodePtr);

            Node* potentialBest = bestNodePtr;
            do{
                potentialBest = bestNodePtr;
                findPotentialBest(rootNodePtr, potentialBest);
                setBest(potentialBest);
            } while (potentialBest != bestNodePtr);

            updateSolutionSet();
            
            print('S');
        
        }


};

#endif