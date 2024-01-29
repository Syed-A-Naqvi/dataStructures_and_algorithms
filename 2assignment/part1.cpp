#include <iostream>
#include <vector>
#include <string>

// utility function from printing the final matrix properly
void printMatrix(const std::vector<std::vector<int>>& vector, std::string s1, std::string s2){
    
    s1.erase(0,1);
    s2.erase(0,1);

    std::cout << "string1: " + s1 + "\nstring2: " + s2 << std::endl;

    s1 = "_" + s1;
    s2 = "_" + s2;

    for (int i = vector.size() - 1; i > -1 ; i--){

        std::cout << s1[i] << " [  ";
        for (int j = 0; j < vector[0].size(); j++){
            
            std::string spaces = "   ";
            if(vector[i][j]>9){
                spaces = "  ";
            }
            std::cout << vector[i][j] << spaces;
        }
        std::cout << "]" << std::endl;

    }

    std::cout << "     ";
    for (int j = 0; j < vector[0].size(); j++){
        std::cout << s2[j] << "   ";
    }
    std::cout << std::endl;
    
}

// solving problem using dynamic programming
void getEditDistance(std::string s1, std::string s2){
    

    // adding a null character before the actual string
    s1 = "_" + s1;
    s2 = "_" + s2;    

    // getting the dimensions of the edit distance table
    // 0th row and col will represent the NULL character,
    // rows/cols 1..n will represents actual position of character      
    int M = s1.length();
    int N = s2.length();

    // creating the 2D vector(matrix)
    std::vector<std::vector<int>> matrix(M, std::vector<int>(N));

    //initialization
    for (int i = 0; i < M; i++){
        matrix[i][0] = i;
    }
    for (int j = 1; j < N; j++){
        matrix[0][j] = j;
    }

    //calculating the edit distances of all subproblems
    for (int i = 1; i < matrix.size(); i++){

        for (int j = 1; j < matrix[0].size(); j++){

            int below = matrix[i-1][j]+1;
            int left = matrix[i][j-1]+1;
            int diag = matrix[i-1][j-1] + (s1[i] == s2[j] ? 0:2);

            matrix[i][j] = std::min(std::min(below, left), diag);

        }

    }

    //prining matrix of edit distances of subproblems
    printMatrix(matrix, s1, s2);
    //printing the minimum edit distance for the two strings
    std::cout<<"Minimum edit distance of the two strings is: " << matrix[M-1][N-1] << "\n" << std::endl;
    
};

int main(int argc, char const *argv[])
{

    // --------------TEST CODE---------------

    // prints the final answer along with all relevant information formatted correctly
    std::cout << "As per stanford document: insertions=1cost, deletions=1cost, substitutions=2cost\n\n";
    getEditDistance("spoof", "stool");
    getEditDistance("podiatrist", "pediatrician");
    getEditDistance("blaming", "conning");
    
    return 0;
}
