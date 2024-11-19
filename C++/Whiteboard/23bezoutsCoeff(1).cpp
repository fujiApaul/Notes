#include <iostream>
using namespace std;

int numOfIterations(int m, int n, int q, int r);
void extendedEuclideanAlg(int m, int n, int q, int r, int &gcd, int *x, int *y, int iterations);
void valuesOfQ(int *arrayQ, int m, int n, int q, int r, int iterations);
void bezout(int *arrayQ, int *x, int *y, int iterations);

int main()
{   
    int m;
    int n;
    int q;
    int r = 1;
    int iterations;
    int gcd;

    cout << '\n'
         << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n' 
         << "| Bezout's Identity via Extended Euclidian Algorithm |" << '\n'
         << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n'
         << '\n' 
         << "          ---------------------------------" << '\n'
         << '\n' 
         << "                  ~ Formulas used ~        " << '\n'
         << '\n' 
         << "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n'
         << "          |      Euclidean Algorithm:     |" << '\n'
         << "          |          m = n(q) + r         |" << '\n'
         << "          |                               |" << '\n'
         << "          |             note:             |" << '\n'
         << "          |          m = dividend         |" << '\n'
         << "          |          n = divisor          |" << '\n'
         << "          |          q = quotient         |" << '\n'
         << "          |          r = remainder        |" << '\n'
         << "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n'
         << '\n' 
         << "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n'
         << "          |       Bezout's Identity:      |" << '\n'
         << "          |        m(x) + n(y) = d        |" << '\n'
         << "          |                               |" << '\n'
         << "          |             note:             |" << '\n'
         << "          |          d = gcd(m, n)        |" << '\n'
         << "          |    x = bezout's coeff for m   |" << '\n'
         << "          |    y = bezout's coeff for n   |" << '\n'
         << "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n'
         << '\n'
         << "Enter your m: ";
    cin  >> m;

    cout << '\n'
         << "Enter your n: ";
    cin  >> n;

    cout         << '\n' << 'm' << '\t' << 'n' << '\t' << 'q' << '\t' << 'r' << '\t' << 'x' << '\t' << 'y' << '\n'
                 << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" << '\n';

    iterations = numOfIterations(m, n, q, r);

    int arrayQ[iterations];
    int x[iterations + 1];
    int y[iterations + 1];

    valuesOfQ(arrayQ, m, n, q, r,  iterations);

    bezout(arrayQ, x, y, iterations);

    extendedEuclideanAlg(m, n, q, r, gcd, x, y, iterations);

    cout << "\n\n"
         << "gcd(m, n) = " << gcd
         << "\n\n"
         << "x = " << x[1]
         << "\n\n"
         << "y = " << y[1];

    return 0;
}

void extendedEuclideanAlg(int m, int n, int q, int r, int &gcd, int *x, int *y, int iterations)
{
    for (int i = 0; i < iterations; i++)
    {
        q = m / n;
        r = m - (n * q);

        cout << m << '\t' << n << '\t' << q << '\t' << r << '\t' << x[i + 1] << '\t' << y[i + 1] << '\n';

        m = n;
        n = r;

        if (i == iterations - 2)
        {
            gcd = r;
        }
        
    }
}

int numOfIterations(int m, int n, int q, int r)
{
    int i; 
    for (i = 0; r != 0; i++)
    {
        q = m / n;
        r = m - (n * q);

        m = n;
        n = r;
    }
    
    return i;
}

void valuesOfQ(int *arrayQ, int m, int n, int q, int r, int iterations)
{
    for (int i = 0; i < iterations; i++)
    {
        q = m / n;
        r = m - (n * q);

        arrayQ [i] =  q;

        m = n;
        n = r;
    }
}

void bezout(int *arrayQ, int *x, int *y, int iterations)
{
    int index = iterations - 1;
    x[index] = 1;
    y[index] = -1 * arrayQ[(iterations - 1) - 1];

    for (int i  = (iterations - 1) - 2; i >= 0; i--)
    {
        index--;

        x[index] = y[index + 1];
        y[index] = x[index + 1] - (y[index + 1] * arrayQ[i]);
    }

    x[iterations] = 0;
    y[iterations] = 0;
}