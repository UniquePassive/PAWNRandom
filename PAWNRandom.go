package main

import (
	"fmt"
)

var seed uint = 0

func pawnRandom(max uint) uint {
	var result uint = 16838 * (seed & 0xFFFF)
	
	var temp uint = 20077 * (seed & 0xFFFF)
	temp += 12345
	temp = temp >> 16
	
	result += temp
	
	result -= 1043968403 * (seed >> 16)
	result &= 0x7FFFFFFF
	
	seed = 1103515245 * seed + 12345
	
	if (max != 0) {
		result %= max;
	}
	return result;
}

func main() {
	seed = 124768 // example seed, make sure not to use this
	
	fmt.Println("Seed:", seed)
	
	fmt.Println(pawnRandom(7)) // 0 to 6
	fmt.Println(1 + pawnRandom(12)) // 1 to 12
	fmt.Println(1985 + pawnRandom(31)) // 1985 to 2015
	fmt.Println(pawnRandom(0)) // 0 to INT_MAX
}