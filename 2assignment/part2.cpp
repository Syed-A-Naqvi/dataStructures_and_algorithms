#include<iostream>
#include<vector>
#include<cmath>

//---------------------------- utility functions ----------------------------
// returns the digit of a number at the specified place value
int getDigit(int num, int digit){
    int working = num / std::pow(10, digit-1);
    return working % 10; 
}
// prints array
void printVec(std::vector<int>& v){
    std::cout<<"[ ";
    for (auto& e: v){
        std::cout << e << " ";
    }
    std::cout << "]" << std::endl;
}

// ---------------------------- radix sort ----------------------------
// used counting sort as subroutine for performing in-place radix sort on passed array 
void radixSort(std::vector<int>& A, int maxDigits){

    for(int d = 1; d <= maxDigits; d++){

        // will store the dth digit for each element in A, maintaining original order
        std::vector<int>A_d(A.size());
        // populating A_d with the dth digit of A        
        for(int j = 0; j < A.size(); j++){
            A_d[j] = getDigit(A[j], d);
        }


        // counting sort on the digit array-----------------------

        // initializing auxillary array, each element is zero by default
        std::vector<int> C(10);

        // building auxillary array
        for(int j = 0; j < A_d.size(); j++){
            C[A_d[j]] += 1;
        }
        for(int i = 1; i < 10; i++){
            C[i] += C[i-1];
        }

        //temporary vector for updating original array after sorting on dth digit
        std::vector<int> B(A.size());

        for(int j = A.size()-1; j > -1; j--){
            B[C[A_d[j]]-1] = A[j];
            C[A_d[j]] -= 1; 
        }
        A = B;
    }

};

int main(int argc, char const *argv[])
{
    std::vector<int> numbers = {123456, 901293, 12, 235, 3456, 456, 5678, 679, 9, 67890, 1, 89012, 90123};
    
    std::cout << "original array:\n";
    printVec(numbers);

    // radix sort will take an array and the maximum number of digits (k value)
    radixSort(numbers, 6);

    std::cout << "\nSorted array:\n";
    printVec(numbers);

    return 0;
}
