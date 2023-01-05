import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class QuinolDJ_CH3AProbSet01 {
    // Function to find and display the union and intersection
    static void displayUnionAndIntersection(int[] arrayOne, int[] arrayTwo){
        Set<Integer> obj = new HashSet<>();
        int i, j;

        for(i = 0; i < arrayOne.length; i++){
            obj.add(arrayOne[i]);
        }
        for(j = 0; j < arrayTwo.length; j++){
            obj.add(arrayTwo[j]);
        }

        System.out.println("The union of both the arrays is:");
        for(Integer I: obj){
            System.out.print(I + " ");
        }

        System.out.println();
        obj.clear();

        System.out.println("The intersection of both the arrays is:");
        for(i = 0; i < arrayOne.length; i++){
            obj.add(arrayOne[i]);
        }
            for(j = 0; j < arrayTwo.length; j++){
                if(obj.contains(arrayTwo[j]))
                    System.out.print(arrayTwo[j] + " ");
            }
    }
    // Function to read the input
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        System.out.println("Enter the size of the two arrays:");
        try {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
        }
            catch (IOException e) {
            System.out.println("Invalid input");
            return;
        }
        //if input is <5
        if (m <5 && n <5){
            System.out.println("Invalid Size, must be >= 5");
            System.exit(0);
        }

        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[m];

        System.out.println("Enter the first array elements:");
            int i, j;

        for(i = 0; i < arrayOne.length; i++){
            try {
                arrayOne[i] = Integer.parseInt(br.readLine());
            }
            catch (IOException e) {
                System.out.println("Invalid array element. Enter it again");
                i--;
            }
        }
        System.out.println("Enter the second array elements:");
        for(i = 0; i < arrayTwo.length; i++){
            try {
                arrayTwo[i] = Integer.parseInt(br.readLine());
            }
            catch (IOException e) {
                System.out.println("Invalid array element. Enter it again");
                i--;
            }
        }
        displayUnionAndIntersection(arrayOne,arrayTwo);
    }
}