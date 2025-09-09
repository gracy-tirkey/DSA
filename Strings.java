public class Strings {
    public static void main(String[] args) {

        System.out.println(isPalindrome("racecar")+"  "+isPalindrome("racpar"));
        System.out.println(getShortestPath("WNEENESENNN") + "  "+ getShortestPath("NS"));
        System.out.println(substring("Hello Coders! " ,0, 5) +" "+substring("Learn DSA", 6, 9));
        // Using inbuilt Function substring(beginIndex,endIndex)
        System.out.println("Hello Coders! ".substring(0, 5));

        String fruits[] = {"apple", "grapes","banana","orange"};
        System.out.println(largestString(fruits));

    }

    public static boolean isPalindrome(String str){
        for(int i=0; i< str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static String largestString(String list[]){
        String largest = list[0];
        for(int i=1; i< list.length; i++){
            if(largest.compareTo(list[i]) < 0){
                largest = list[i];
            }
        }
        return largest;
    }

    public static String substring(String str, int startIndex, int endIndex){
        String substr = "";
        for(int i=startIndex; i< endIndex; i++){
            substr += str.charAt(i);
        }
        return substr;
    }

    public static float getShortestPath(String str){
        int x=0, y=0;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == 'N'){
                x++;
            }else if(str.charAt(i) == 'S'){
                x--;
            }else if(str.charAt(i) == 'E'){
                y++;
            }else{
                y--;
            }
        }
        return (float) Math.sqrt(x*x+y*y);
    }
}
