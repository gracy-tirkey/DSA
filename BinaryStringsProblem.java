public class BinaryStringsProblem {
    public static void main(String[] args) {
        // binaryStrings(3, 0, "");
        // System.out.println();
        System.out.println();
        binaryStrings2(5, 0, "");
    }

    //Method-I
    public static void binaryStrings(int n, int lastPlace, String s){

        if(n==0) {
            System.out.println(s);
            return;
        }

        if(lastPlace == 0){
            binaryStrings(n-1, 0, s+"0");
            binaryStrings(n-1, 1, s+"1");
        }else{    
            binaryStrings(n-1, 0, s+"0");
        }
    }

    //Method-II
    public static void binaryStrings2(int n, int lastPlace, String s){
        if(n==0) {
            System.out.println(s);
            return;
        }

        binaryStrings(n-1, 0, s+"0");
        if(lastPlace == 0){
            binaryStrings(n-1, 0, s+"0");
            binaryStrings(n-1, 1, s+"1");
        }
    }
}
