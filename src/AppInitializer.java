import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) {
        // Database


        Scanner input = new Scanner(System.in);
        // program initialization
        String[] initializePageQuestions =
                {
                        "1. Do You want to login?",
                        "2. Are you new to here?",
                        "3. Do you want to exit the page?"
                };

        for (String question : initializePageQuestions) {
            System.out.println(question);
        }

        int userInput = input.nextInt();
        switch (userInput) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                return;
                //exit program
        }
    }

    // login
    public static boolean login() {

    }
}