import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        
        Integer[] costVer = {2, 1, 3, 1, 4};
        Integer[] costHor = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; //pointers for horizontal and vertical cost arrays
        int hp = 1, vp = 1; //directional pieces count
        int totalCost = 0;

        while (h < costHor.length && v < costVer.length) {
            
            if(costHor[h] >= costVer[v]) {
                totalCost += costHor[h] * vp;
                hp ++;
                h++;
            } else {
                totalCost += costVer[v] * hp;
                vp ++;
                v++;
            }
        }
        while (h < costHor.length) {
            totalCost += costHor[h] * vp;
            hp ++;
            h++;
        }
        while (v < costVer.length) {
            totalCost += costVer[v] * hp;
            vp ++;
            v++;
        }
        System.out.println("The minimum cost to cut the chocolate is: " + totalCost);
    }
}
