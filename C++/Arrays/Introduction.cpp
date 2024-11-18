#include <iostream>

using namespace std;

int main(){
    
    int numbers[5];
    int size =  sizeof(numbers) / sizeof(numbers[0]);

    for (int i = 0; i < size; i++)
    {
        numbers[i] = i + 1;
        cout << numbers[i] << "\n\n";
    }

    int sum = 0;

    for (int i = 0; i < size; i++)
    {
        sum += numbers[i];
    }

    cout << "Sum of the numbers in the array: " << sum << endl;
    

    return 0;
}