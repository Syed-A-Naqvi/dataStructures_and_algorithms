// illustrate the operation of building a heap on the following array
// A = [5, 13, 2, 25, 7, 17, 20, 8 ,4]

#include<iostream>
#include<cmath>
#include<vector>
#include<stdexcept>

class Heap {

    private:

        std::vector<int>& heap;
        int heapSize;

        // Utility functions
        int parent(int i){
            return ((i-1)/2);
        }
        int left(int i){
            return 2*i+1;
        }
        int right(int i){
            return 2*i+2;
        }
        void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        void maxHeapify(int i){
            
            int l = left(i);
            int r = right(i);

            int largest = i;
            if ( (l < heapSize) && (heap[l] > heap[largest]) ){
                largest = l;
            }
            if ( (r < heapSize) && (heap[r] > heap[largest]) ){
                largest = r;
            }

            if ( largest != i){
                swap(largest, i);
                maxHeapify(largest);
            }

        }


    public:

        Heap(std::vector<int>& vec): heap(vec){
            if(vec.size()==0){
                throw std::invalid_argument("Size cannot be zero.");
            }
            heapSize = heap.size();
            buildMaxHeap();
        };

        // the last parent of a heap will always be floor(n/2)
        void buildMaxHeap(){
            for (int i = (heapSize/2); i > -1; i--)
            {
                maxHeapify(i);
            }
        }

        void resetHeap(){
            heapSize = heap.size();
            buildMaxHeap();  
        }

        int heapMaximum(){
            return heap[0];
        }

        int heapExtractMax(){
            
            if(heapSize == 0){
                std::cout << "All elements extracted. Reseting heap...\n";
                resetHeap();
            }
            if(heapSize == 1){
                std::cout << "Removing final element from heap...\n";
            }
            
            int max = heap[0];
            swap(0, heapSize-1);
            heapSize--;
            maxHeapify(0);
            return max;


        }

        void maxHeapInsert(int value){
            
            heap.insert(heap.begin() + heapSize,value);
            heapSize++;

            int i = heapSize-1;

            while (heap[i] > heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }

        }

        void heapSort(){
            
            resetHeap();

            for (int i = heapSize-1; i > 0; i--)
            {
                heapExtractMax();
            }

        }

};

void printVector(const std::vector<int>& vec){
    
    std::cout << "[";
    for (int i = 0; i < vec.size(); i++)
    {
        std::cout << " " << vec[i];
    }
    std::cout << " ]\n";
    
}

int main(int argc, char const *argv[])
{
    
    std::vector<int> list1 = {5, 13, 2, 25, 7, 17, 20, 8 ,4};
    std::vector<int> list2 = {5, 13, 2, 25, 7, 17, 20, 8 ,4};

    std::cout<<"Original array:\n";
    printVector(list1);

    Heap heap = Heap(list1);

    std::cout<<"\nHeap configuration:\n";
    printVector(list1);

    std::cout<<"\nOriginal array:\n";
    printVector(list2);

    heap.heapSort();

    std::cout<<"\nArray using Heapsort:\n";
    printVector(list1);
    
    return 0;
}
