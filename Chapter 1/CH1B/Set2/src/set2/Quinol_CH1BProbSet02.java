package set2;
import java.util.Scanner;
import java.util.Arrays;

public class Quinol_CH1BProbSet02 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a sentence: ");
        String a = sc.nextLine();
        String[] words = a.split("\\s+"); 
        System.out.println("Words You Entered:");
        int count = 1;
        
        for(String one: words){
            one = one.toUpperCase();
            if(Character.isLetter(one.charAt(one.length()-1)) == false)
                one = one.substring(0,one.length()-1);
                
            int vowels, consonants;
            
            String cons = "", vows = "";
            int con = 0, vow = 0;
            
            for(int i=0; i<one.length(); i++) {
                if(one.charAt(i) == 'A' || one.charAt(i) == 'E' || one.charAt(i) == 'I' || one.charAt(i) == 'O' || one.charAt(i) == 'U' ) {
                    vow++;
                    vows += one.charAt(i) + " ";
                } else {
                    con++;
                    cons += one.charAt(i) + " ";
                }
            }
            System.out.printf("\t[%d] %s\n\t\t- %d Letter(s)\n\t\t- %d Consonant(s): %s\n\t\t- %d Vowel(s): %s\n\n", count, one, one.length(), con, cons, vow, vows);
            count += 1;
        }
    }
}