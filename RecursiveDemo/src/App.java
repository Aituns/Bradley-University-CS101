public class App {
    public static void main(String[] args) throws Exception {
        int factOf4 = factorial(4);
        System.out.println(factOf4);

        public static int factorial(int n) {
            int result;
            if (n > 1)
                result = n * factorial(n - 1);
            else
                result = 1;
            return result;
        
        }
    }
}
