public class BitManipulation {

    public static void oddOrEven(int n){
        int bitMask = 1;
        
        if((n & bitMask) == 0){
            System.out.println("Even");
        } else{
            System.out.println("Odd");
        }
    }

    public static void swapTwoNumbers(int a, int b){
        System.out.println(a+"  "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+"  "+b);
    }

    public static void toLowerCase(){
        for( char ch='A'; ch<='Z'; ch++){
            System.out.print((char)(ch | ' '));
        }
    }

    public static int fastExpo(int a, int n){
        int ans = 1;

        while(n>0){
            if((n & 1)!=0){
                ans = ans * a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    public static boolean isPowerOf2(int n){
        return ((n & (n-1))==0) ? true : false;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n & 1) != 0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;

        if((n & bitMask) == 0){
            return 0;
        } else{
            return 1;
        }
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;

        return n | bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);

        return n & bitMask;
    }

    // Method-I
    public static int updateIthBit(int n, int i, int newBit){
        if(newBit == 0){
            return clearIthBit(n, i);
        }else{
            return setIthBit(n, i);
        }
    }

    // Method-II
    public static int updateIthBit2(int n, int i, int newBit){
        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearLastIthBit(int n, int i){
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    public static void main(String[] args) {

        oddOrEven(11);
        oddOrEven(12);
        System.out.println(getIthBit(10,3));
        System.out.println(setIthBit(10,2));
        System.out.println(clearIthBit(10,1));
        System.out.println(updateIthBit(10,1,0));
        System.out.println(updateIthBit2(10,1,0));
        System.out.println(clearLastIthBit(15,2));
        System.out.println(isPowerOf2(9)+"  "+isPowerOf2(16));
        System.out.println(countSetBits(15));
        System.out.println(fastExpo(3, 5));
        swapTwoNumbers(3, 4);
        toLowerCase();

    }
}
