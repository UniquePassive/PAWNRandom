from ctypes import *

seed = c_uint32(0)
    
def pawnRandom(max):
    result = 16838 * c_uint16(seed.value).value
    
    temp = 20077 * c_uint16(seed.value).value
    temp += 12345
    temp = temp >> 16
    
    result += temp
    
    result -= 1043968403 * (seed.value >> 16)
    result &= 0x7FFFFFFF
    
    seed.value = 1103515245 * seed.value + 12345
    
    if (max != 0):
        result %= max
    
    return result

def main():
    seed.value = 124768
    
    print "Seed: %d" % seed.value
    
    print "%d" % pawnRandom(7) # 0 to 6
    print "%d" % (1 + pawnRandom(12)) # 1 to 12
    print "%d" % (1985 + pawnRandom(31)) # 1985 to 2015
    print "%d" % pawnRandom(0) # 0 to sys.maxint

if __name__ == "__main__":
    main()