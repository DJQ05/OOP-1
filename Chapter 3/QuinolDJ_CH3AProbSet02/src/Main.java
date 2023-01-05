public class Main{

    public static void main(String args[]) {
        //create object
        Ticket card = new Ticket();
            //repeat each method to generate 4 cards
            for(int x = 0; x < 2; x++){

                //create arbitrary numbers
                card.bingoNumber();
                //prints the title
                card.title();
                //prints random numbers inside a table
                card.printNumbers();
            }
    }
}