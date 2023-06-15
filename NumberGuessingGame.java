import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> getScore = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame method = new NumberGuessingGame();
        method.menu(getScore);
    }
    public void menu(ArrayList<Integer> getScore) {
        NumberGuessingGame method = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("**************************");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
                    int numberRange = input.nextInt();
                    int randomgenerator = method.randomgenerator(numberRange);
                    method.guessNumberNumber(randomgenerator);
                    break;
                case 2:
                    method.displaygetScore();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(getScore);
        }
    }
    public int randomgenerator(int numberRange) {
        Random random = new Random();
        int randomgenerator = random.nextInt(numberRange) + 1;
        return randomgenerator;
    }
    public void guessNumberNumber(int randomgenerator) {
        Scanner input = new Scanner(System.in);
        int userNumber;
        int guessNumber = 0;
        do {
            System.out.print("Enter your guessNumber number: ");
            userNumber = input.nextInt();
            guessNumber++;
            if (userNumber > randomgenerator) {
                System.out.println("Lower");
            } else if (userNumber < randomgenerator) {
                System.out.println("Higher");
            }
        } while (randomgenerator != userNumber);
        System.out.println(" ");
        if (guessNumber == 1) {
            System.out.println("You answered number is right in " + guessNumber + " try!");
        } else {
            System.out.println("You answered number is right in " + guessNumber + " tries!");
        }
        getScore.add(guessNumber);
        System.out.println(" ");

        menu(getScore);
    }
    public void displaygetScore() {
        System.out.println("****************************");
        System.out.println("Score Board");
        System.out.println("****************************");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(getScore);
        for (Integer scores : getScore) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(getScore);
    }
}