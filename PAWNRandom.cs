using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PAWNRandom
{
    class PAWNRandom
    {
        static int seed = 0;

        static int pawnRandom(int max)
        {
            int result = 16838 * (seed & 0xFFFF);

            int temp = 20077 * (seed & 0xFFFF);
            temp += 12345;
            temp = temp >> 16;

            result += temp;

            result -= 1043968403 * (seed >> 16);
            result &= 0x7FFFFFFF;

            seed = 1103515245 * seed + 12345;

            if (max != 0)
            {
                result %= max;
            }
            return result;
        }

        static void Main(string[] args)
        {
            seed = 124768; // example seed, make sure not to use this

            Console.WriteLine("Seed: " +  seed);

            Console.WriteLine(pawnRandom(7)); // 0 to 6
            Console.WriteLine(1 + pawnRandom(12)); // 1 to 12
            Console.WriteLine(1985 + pawnRandom(31)); // 1985 to 2015
            Console.WriteLine(pawnRandom(0)); // 0 to Int32.MaxValue

            Console.ReadKey();
        }
    }
}
