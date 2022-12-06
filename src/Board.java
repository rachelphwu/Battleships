public class Board {
    private StrikePoint[] board;
    public Board()
    {
        board = new StrikePoint[100];
    }

    //TODO Aurora: This class holds all guesses, and all ships in (different!) ArrayLists. Please provide getters & setters
    //TODO Aurora: coordinate with Ryan, but likely equality of guess with ship's StrikePoint is determined here.
//TODO: add in Player p to parameter for createboard
    public static StrikePoint[] createBoard(Player p) {
        StrikePoint[] board = new StrikePoint[100];
        int counter = 0;
        for (int x = 1; x < 11; x++) {
            for (int y = 1; y < 11; y++) {
                StrikePoint sp = new StrikePoint(x,y);
                sp.setHitShip(false);
                sp.updateSymbol("O");
                board[counter] = sp;
                counter++;
            }
        }
        return board;
    }
    public static void printBoard(StrikePoint[] board){
        System.out.print("   | ");
        for (int i = 1; i<11; i++) {
            System.out.print(String.format("%-5s", i + " |  "));
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("1" + "  | ");
        for (int i = 0; i<10; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("2" + "  | ");
        for (int i = 10; i<20; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("3" + "  | ");
        for (int i = 20; i<30; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("4" + "  | ");
        for (int i = 30; i<40; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("5" + "  | ");
        for (int i = 40; i<50; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("6" + "  | ");
        for (int i = 50; i<60; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("7" + "  | ");
        for (int i = 60; i<70; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("8" + "  | ");
        for (int i = 70; i<80; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("9" + "  | ");
        for (int i = 80; i<90; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
        System.out.println();
        System.out.println("   |-------------------------------------------------|");
        System.out.print("10" + " | ");
        for (int i = 90; i<100; i++) {
            System.out.print(String.format("%-3s", board[i].getSymbol()) + "| ");
        }
    }
    /**
     * player enters coordinates to guess on enemy's board
     * method compares the player's strikepoints to the enemy's board
     * @param sp player's strikepoints.
     * @param enemyBoard enemy's hidden board for comparing the guesses to their ship placement
     * @return true for all symbols that are not blank or previously hit (e.g., Ca for carrier, Ba for battleship)
     */
    public boolean isHit(StrikePoint sp, StrikePoint[] enemyBoard) {
        //find the strikepoint
        //pull symbol from it
        //return true if it's not "O" or "X"
        String symbol = "null";
        for (StrikePoint strikePoint : enemyBoard) {
            //if (sp.getX() == strikePoint.getX() && sp.getY() == strikePoint.getY()) symbol=StrikePoint.getSymbol();
        }
        if (symbol.equals("O") || symbol.equals("X")) {
            return false;
        } else return true;
    }

}
