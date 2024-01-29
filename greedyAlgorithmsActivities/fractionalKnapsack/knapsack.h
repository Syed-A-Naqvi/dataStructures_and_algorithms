#ifndef KNAPSACK_H
#define KNAPSACK_H

#include <vector>
#include <tuple>

// The item class will store an item number, its value and its weight
class Item{
    
    private:
        static int count;
        float weight;
        float value;
        int itemNumber;
    
    public:
        //constructors
        Item();
        Item(float value, float weight);
        //getters and setters
        float getWeight() const; 
        float getValue() const;
        int getItemNumber() const;
        void setWeight(float w);
        void setValue(float v);
        void setItemNumber(int i);
        // reset the item counter
        static void resetCount();
};


class Knapsack {

    private:
        // knapsack statistics;
        const float maxCapacity;
        float remainingCapacity;
        float storedValue;
        // items in the knapsack
        std::vector<std::tuple<Item, float>> storedItems;
        //utilitiy functions
        void sortItems(std::vector<Item>& items);
        void addItem(Item item, float fraction);

    public:
        // constructors
        Knapsack();
        Knapsack(float maxCapacity);
        //getters and setters
        float getRemainingCapacity() const;
        float getStoredValue() const;
        float getMaxCapacity() const;
        // empty all current items from the knapsack
        void empty();

        // fractional insertion
        void fractionalInsertion(std::vector<Item> items);

        // 0/1 knapsack implementation using dynamic programming
        // zeroOneInsertion(std::vector<Item> items);

        // print the knapsack
        void print();

};

#endif //KNAPSACK_H