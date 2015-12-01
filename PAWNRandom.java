public class PAWNRandom {

    static Integer seed = 0;

    static Integer pawnRandom(int max) {
        Integer result = 16838 * (seed & 0xFFFF);

        Integer temp = 20077 * (seed & 0xFFFF);
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
        System.out.println(pawnRandom(0)); // 0 to Integer.MAX_VALUE
    }
}
