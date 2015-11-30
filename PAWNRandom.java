public class PAWNRandom {

    public static Integer seed = 0;

    public static Integer pawnRandom() {
        return pawnRandom(0);
    }

    public static Integer pawnRandom(int max) {
        Integer result = 16838 * Short.toUnsignedInt(seed.shortValue());

        Integer temp = 20077 * Short.toUnsignedInt(seed.shortValue());
        temp += 12345;
        temp = temp >> 16;

        result += temp;

        result -= 1043968403 * (seed >>> 16);
        result &= 0x7FFFFFFF;

        seed = 1103515245 * seed + 12345;

        if (max != 0) {
            result %= max;
        }

        return result;
    }

    public static void main(String[] args) {
        seed = 124768;

        System.out.println("Seed: " + seed);

        System.out.println(pawnRandom(7)); // 0 to 6
        System.out.println(1 + pawnRandom(12)); // 0 to 12
        System.out.println(1985 + pawnRandom(31)); // 1985 to 2015
        System.out.println(pawnRandom()); // 0 to INT_MAX
    }
}
