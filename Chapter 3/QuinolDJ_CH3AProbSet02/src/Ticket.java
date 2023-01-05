import java.util.*;
public class Ticket{
    private int[][] nums = new int[2][25];                                                                              //field in multidimensional array
    public void bingoNumber(){
        Random random = new Random();                                                                                   //arbitrary class object
        for(int x = 0; x < 2; x++){                                                                                     //x for multidimensional array's initial array
            for(int y = 0; y < 25; y++){                                                                                //y for multidimensional array's second  array
                this.nums[x][y] = random.nextInt(75)+1;                                                           //Create random number between 1 - 75
            }
        }
    }
    public void title(){
        System.out.println("+----+----+----+----+----+\t+----+----+----+----+----+");
        System.out.print("| B  | I  | N  | G  | O  |\t| B  | I  | N  | G  | O  |");

    }
    public void printNumbers(){
        System.out.print("\n+");                                                                                        //print +
        for(int x = 0; x < 10; x++){                                                                                    //print [——+] 10 times horizontal
            System. out.print("----+");
            if(x == 4)System.out.print("\t+");                                                                          //when x = 4 print a vertical tab and the character +
        }
            System.out.print("\n|");                                                                                    //print |
                int y = 1;                                                                                              /** In order to know where the array index y ends and to
                                                                                                                        initialize y for the second bingo card, we must declare
                                                                                                                        this outside of the loop. Otherwise, the second card will
                                                                                                                        print the same output as the first **/

        for(int x = 1; x <= 25; x++){                                                                                   //for the initial bingo card, x
            if(x == 13){                                                                                                //x == 13 (middle part)
                System.out.print(" FR |");                                                                              //print FR
            } else if (this.nums[0][x-1] < 10){                                                                         //if the index of the current array is less than 10 (1 - 9)
                System.out.print(" 0" + this.nums[0][x-1] + " |");                                                      //print '0' prefix (1 - 9)
            } else {
                System.out.print(" " + this.nums[0][x-1] + " |");                                                       //print " "
            }

            if(x % 5 == 0){                                                                                             //print | if x can be divided by 5
                    System.out.print("\t|");



        for(; y <= 25; y++){                                                                                            //loop for the second card
             if(y == 13){                                                                                               //y == 13 (middle part)
                 System.out.print(" FR |");                                                                             //print FR
             } else if (this.nums[1][y-1] < 10){                                                                        //if the index of the current array is lower than 10
                 System.out.print(" 0" + this.nums[1][y-1] + " |");                                                     //print '0' prefix (01-09)
             } else {
                 System.out.print(" " + this.nums[1][y-1] + " |");                                                      //print " "
             } if(y % 5 == 0){                                                                                          //if y % 5
                y++;                                                                                                    //increment y so that it won't print the array's final value twice
                break;
             }
        }

                 System.out.print("\n+");                                                                               //print +

        for(int z = 0; z < 10; z++){                                                                                    //This loop will print "——+" in horizontal lines.
            System.out.print("----+");
                if(z == 4){                                                                                             //z == 4
                    System.out.print("\t+");                                                                            //print + and horizontal tab
                    }
        }
                if(x == 25)break;                                                                                       //prevents printing too many | and breaks if x equals 25.
                System.out.print("\n|");                                                                                //print |
        }
    }

                System.out.println();
    }
}