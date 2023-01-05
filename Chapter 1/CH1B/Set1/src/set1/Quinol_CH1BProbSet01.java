package set1;
import java.util.*;

public class Quinol_CH1BProbSet01 {
    
    public static void main(String args[]){

        System.out.print(">> Enter 3-digit number: ");
        Scanner sc = new Scanner(System.in);
        char choice = 'Y';
        while(true){

            String num = sc.nextLine();
            if(num.length()!=3){
                System.out.println("   == " + num + " is not a 3-digit number.");
                System.out.println("   == " + num + " IS NOT A VALID INPUT.");
                System.out.print("\n>> Enter 'y' to try again: ");
                choice = sc.nextLine().charAt(0);
                if(choice!='y') break;

                System.out.print("\n>> Enter 3-digit number: ");
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i))) {
                    System.out.println("   == '" + num.charAt(i) + "' is not a digit.");
                    System.out.println("   == " + num + " IS INVALID INPUT.");
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.print("\n>> Enter 'y' to try again: ");
                choice = sc.nextLine().charAt(0);
                if (choice != 'y')
                    break;
                System.out.print("\n>> Enter 3-digit number: ");

                continue;
            }
            int n = Integer.parseInt(num);
            int a = n/100;
            int b = (n/10)%10;
            int c = n%10;
            String[] arr = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
            System.out.println("   == DIGITS WORD: " + arr[a] + "-" + arr[b] + "-" + arr[c]);
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int mid = a+b+c-max-min;
            System.out.println("   == CHORONOLOGICAL ORDER: "+arr[max]+", "+arr[mid]+". "+arr[min]);
            System.out.print("\n>> Enter 'y' to try again: ");
            choice = sc.nextLine().charAt(0);
            
            if (choice != 'y')
                break;
            System.out.print("\n>> Enter 3-digit number: ");
        }
        System.out.println("\n  ==  Program Terminated.");
        
    }
}