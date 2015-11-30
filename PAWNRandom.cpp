#include "stdafx.h"
#include <conio.h>

unsigned int seed = 0; 

unsigned int pawnRandom(int max = 0) {
	unsigned int result = 16838 * (unsigned __int16)seed;

	unsigned int temp = 20077 * (unsigned __int16)seed;
	temp += 12345;
	temp = temp >> 16;

	result += temp;

	result -= 1043968403 * (seed >> 16);
	result &= 0x7FFFFFFF;

	seed = 1103515245 * seed + 12345;

	if (max != 0L) {
		result %= max;
	}
	return result;
}

int main()
{
	seed = 124768; // example seed, make sure not to use this
	
	printf("Seed: %d\n", seed);
	
	printf("%d\n", pawnRandom(7)); // 0 to 6
	printf("%d\n", 1 + pawnRandom(12)); // 1 to 12
	printf("%d\n", 1985 + pawnRandom(31)); // 1985 to 2015
	printf("%d\n", pawnRandom()); // 0 to INT_MAX
	
	_getch();
}
