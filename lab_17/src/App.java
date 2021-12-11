public class App {
    public static void main(String[] args) throws Exception {
        int arr[][] = {{1, 5, 9,}, 
                       {8, 3, 4 },
                       {6, 7, 2 }};
        Magic matrix = new Magic(arr);
        System.out.println(matrix.magic());
    }
}
