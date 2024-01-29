#include <iostream>
#include "knapsack.h"

int main() {

    
    // Part A: adding items of different values and weights to a knapsack
    // of maximum weight = 25
    int weight = 25;

    // creating the list of items
    std::vector<Item> items;
        // item 1
        items.push_back(Item(20, 5));
        // item 2
        items.push_back(Item(45, 15));
        // item 3
        items.push_back(Item(15, 10));
        // item 4
        items.push_back(Item(12, 6));

    // creating the knapsack
    Knapsack myKnapsack(weight);

    myKnapsack.fractionalInsertion(items);
    myKnapsack.print();



}