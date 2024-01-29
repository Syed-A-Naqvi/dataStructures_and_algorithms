#include "knapsack.h"
#include <iostream>
#include <algorithm>
#include <iomanip>

// Implementations and initializations of the Item class
    // static item counter
    int Item::count = 0;
    
    // defalut constructor
    Item::Item(): weight(0.0f), value(0.0f), itemNumber(++count){};
    // overloaded constructor
    Item::Item(float value, float weight): weight(weight),
               value(value), itemNumber(++count){};
    
    // Getters
    float Item::getWeight() const { return this->weight; };
    float Item::getValue() const { return this->value; };
    int Item::getItemNumber() const { return this->itemNumber; };
    //Setters
    void Item::setWeight(float w){ this->weight = w; };
    void Item::setValue(float v){ this->value = v; };
    void Item::setItemNumber(int i) { this->itemNumber = i; };
    
    // resetting the count variable, might be useful
    void Item::resetCount(){
        count = 0;
    };
//------------------------------------------------------------------


// Implementation and initialization of the knapsack class
    
    //default constructor
    Knapsack::Knapsack(): remainingCapacity(0.0f), storedValue(0.0f), maxCapacity(0.0f){};
    // overloaded constructor
    Knapsack::Knapsack(float maxCapacity):
        maxCapacity(maxCapacity),
        remainingCapacity(maxCapacity),
        storedValue(0.0f){};
    
    // getters
    float Knapsack::getRemainingCapacity() const { return this->remainingCapacity; };
    float Knapsack::getStoredValue() const { return this->storedValue; };
    float Knapsack::getMaxCapacity() const { return this->maxCapacity; };
    
    //utility functions
    void Knapsack::sortItems(std::vector<Item>& items) {
        std::sort(items.begin(), items.end(), [](const Item& a, const Item& b) {
            return (a.getValue() / a.getWeight()) > (b.getValue() / b.getWeight());
        });
    }
    void Knapsack::addItem(Item item, float fraction){
        this->remainingCapacity -= (item.getWeight() * fraction);
        this->storedValue += (item.getValue() * fraction) ;
        std::tuple<Item,float> newEntry = std::make_tuple(item, fraction);
        this->storedItems.push_back(newEntry);
        if (this->remainingCapacity < 0){
            this->remainingCapacity = 0;
        }
    };

    // removes all items from storedItems vector
    // resets the remaining capacity and the stored value
    void Knapsack::empty(){
        this->storedItems.clear();
        this->remainingCapacity = this->maxCapacity;
        this->storedValue = 0.0f; 
    };

    // implements the fractional item insertion into the knapsack
    void Knapsack::fractionalInsertion(std::vector<Item> items){
        sortItems(items);
        for (int i = 0; i < items.size(); i++)
        {
            if (items[i].getWeight() <= this->getRemainingCapacity()){
                this->addItem(items[i], 1);
            }
            else
            {
                this->addItem(items[i], (this->getRemainingCapacity()/items[i].getWeight()));
            }
        }
    }

    // print the contents and statistics of the knapsack
    void Knapsack::print(){

        std::cout << std::fixed << std::setprecision(2);
        std::cout << "Maximal value in the knapsack for the given items: $" 
                  << std::fixed << std::setprecision(2)
                  << this->storedValue << ".\n" << std::endl;
        
        for (int i = 0; i < this->storedItems.size(); i++)
        {
            Item item = std::get<0>(this->storedItems[i]);
            float fraction = std::get<1>(this->storedItems[i]);

            std::cout << "Item" << item.getItemNumber() << ": $"
                      << item.getValue() << "/" << item.getWeight() << "w   "
                      << "Percentage Included: " << fraction << std::endl;
        }
        
    }

