#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>
#include <string>

struct Item {
    int num;
    float Value;
    float Weight;
    float Ratio;

    Item(int num, int value, int weight): num(num), Value(value), Weight(weight){
        Ratio = Value/Weight; 
    }
};

class FractionalKnapsack{

    private:
        std::vector<Item> itemList;
        std::vector<std::tuple<Item,float>> knapsack;
        float remainingCapacity;
        float storedValue;

        // sorting passed items in descending order based on their value-to-weight ratios
        void sortItems(std::vector<Item>& items) {
        std::sort(items.begin(), items.end(), [](const Item& a, const Item& b) {
            return (a.Ratio > b.Ratio);
        });
    }

        // populating the knapsack
        void fillKnapsack(){

        for(int i = 0; i < itemList.size(); i++){


            if(itemList[i].Weight <= remainingCapacity){
                //if item weight is <= remainingCapacity, add 100% of item
                knapsack.push_back(std::make_tuple(itemList[i],1));
                //subtract item's weight from remainingCapacity
                remainingCapacity -= itemList[i].Weight;
                //add 100% of item's value to stored value
                storedValue += itemList[i].Value;
            }
            else{
                //percentage of item that can be inserted
                float percentage = remainingCapacity / itemList[i].Weight; 
                //add fraction of item to the knapsack
                knapsack.push_back(std::make_tuple(itemList[i], percentage));
                //updating stored Value in knapsack
                storedValue += itemList[i].Ratio * remainingCapacity;
                //all space in knapsack has been used up
                remainingCapacity = 0;
            }

        }

    }

    public:
        // constructor
        FractionalKnapsack(std::vector<Item>& items, float capacity):itemList(items), remainingCapacity(capacity){
            //knapsack initially contains no items, stored value is 0
            storedValue = 0;
            //sorting passed list of items in descending order based on value/weight ratios
            sortItems(itemList);
            //populating the knapsack
            fillKnapsack();
        }

        // print knapsack
        void printKnapsack(){

        std::cout<<"Total value in knapsack: $" << storedValue << "\n" << std::endl;

        for(auto& t: knapsack){
            
            Item item = std::get<0>(t);
            float fraction = std::get<1>(t);

            std::cout <<"Item"<<item.num<<": $"<<item.Value<<"/"<<item.Weight<<"w"
                      <<", %"<<fraction*100<< " included" <<std::endl;
        
        }
    }

};

int main(int argc, char const *argv[])
{

    //creating a list and inserting items
    std::vector<Item> items;
    items.push_back(Item(1,20,5));
    items.push_back(Item(2,45,15));
    items.push_back(Item(3,15,10));
    items.push_back(Item(4,22,7));
    items.push_back(Item(5,12,1));
    items.push_back(Item(6,32,4));

    //inserting items into the fractional knapsack and printing knapsack state
    FractionalKnapsack myKnapsack(items, 25);
    myKnapsack.printKnapsack();

    return 0;
}
