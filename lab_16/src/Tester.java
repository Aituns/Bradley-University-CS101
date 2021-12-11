public class Tester {
    public static void main(String[] args) throws Exception {
        //data_type name = new data_type ;
        int[] a = new int[100] ;
        Aray.populate(a);
        System.out.println("Max: " + Aray.findMax(a));
        System.out.println("Min: " + Aray.findMin(a));
        System.out.println("Mean: " + Aray.mean(a));
    }
}
