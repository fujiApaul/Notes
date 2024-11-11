//Graph Coloring Problem
#include<iostream>
using namespace std;

int main ()
{
    // declare and initialize number of vertices
    int vertices;
    cout << '\n'
         << "Enter the number of vertices in the graph: ";
    cin  >> vertices;

    // declare and initialize number of edges
    int edges;
    cout << '\n'
         << "Enter the number of edges in the graph: ";
    cin  >> edges;

    // declare and initialize adjacency Matrix with all values as 0 as a placeholder
    bool adjacencyMatrix[vertices][vertices];
    for (int i = 0; i < vertices; i++)
    {
        for (int j = 0; j < vertices; j++)
        {
            adjacencyMatrix[i][j] = 0;
        }
    }

    // input final bool values for the adjacency matrix by asking for edges
    cout << '\n'
         << "Enter 2 vertices connected by an edge"
         << '\n';

    for (int i = 0; i < edges; i++)
    {
        int a, b, c, d;
        cout << "edge #" << i + 1 << ":\n";
        cin  >> c >> d;
        a = c - 1;
        b = d - 1;
        
        adjacencyMatrix[a][b] = 1;
        adjacencyMatrix[b][a] = 1;
    }

    // display adjacency matrix: if matrix[i][j] = 1, then vertex i isconnected to vertex j, otherwise, there is no conclusion
    cout << '\n'
         << ' ';
    for (int i = 0; i < vertices; i++)
    {
        cout << ' ' << i + 1;
    }
    cout << '\n';

    for (int i = 0; i < vertices; i++)
    {
        cout << i + 1;
        for (int j = 0; j < vertices; j++)
        {
            cout << ' ' << adjacencyMatrix[i][j];
        }
        cout << '\n';
    }

    // declare and initialize list of colors with the size of vertices and values set to 0
    int colors[vertices] = {0};

    // display a certain vertex and its adjacent vertices
    cout << '\n'
         << "vertex = {adjacent vertices}"
         << '\n';
    
    for (int i = 0; i < vertices; i++)
    {
        cout << '\n'
             << i + 1 << " = { ";
        
        for (int j = 0; j < vertices; j++)
        {
            if (adjacencyMatrix[i][j] == 1)
            {
                cout << j + 1 << ' ';
            }
        }
        cout << '}';
    }

    // algorithm that solves the coloring problem with the given graph
    for (int i = 0; i < vertices; i++)
    {
        for (int j = 0; j < vertices; j++)
        {
            if (adjacencyMatrix[i][j] == 1 && colors[i] == colors[j])
            {
                colors[i]++;
                i--;
                break;
            }
        }
    }

    // display solution
    cout << "\n\n"
         << "vertex : color of current vertex [colors of adjacent vertices]"
         << '\n';

    for (int i = 0; i < vertices; i++)
    {
        cout << '\n'
             << i + 1 << " : " << colors[i] << " [ ";

        for (int j = 0; j < vertices; j++)
        {
            if (adjacencyMatrix[i][j] == 1)
            {
                cout << colors[j] << ' ';
            }
        }
        cout << ']';
    }
    return 0;
}