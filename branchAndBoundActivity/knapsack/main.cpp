#include "zeroOneKnapsack.h"

int main(int argc, char const *argv[])
{

    std::vector<Item> items;

    items.push_back(Item(1,8,2));
    items.push_back(Item(2,24,4));
    items.push_back(Item(3,10,5));
    items.push_back(Item(4,18,6));

    ZeroOneKnapsack solution = ZeroOneKnapsack(items, 12);

    solution.print('R');
    std::cout << std::endl;
    solution.findSolution();

    return 0;
}
