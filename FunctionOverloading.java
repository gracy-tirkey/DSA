public class FunctionOverloading {
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static float sum(float a, float b){
        return a+b;
    }
    public static float sum(float a, float b, float c){
        return a+b+c;
    }
    public static void main(String[] args) {
        // Integer
        System.out.println(sum(2,3));
        System.out.println(sum(2,3,4));
        // Float
        System.out.println(sum(2.12f,5.3f));
        System.out.println(sum(2.12f,5.3f,4.7f));
    }
}
