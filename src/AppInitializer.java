import java.util.Scanner;

public class AppInitializer {
    // Database ==> access all around the project
    static String[][] users = new String[3][2];

    public static void main(String[] args) {
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
                if (login()) {
                    openDashboard();
                }
                break;
            case 2:
                if (register()) {
                    openDashboard();
                }
                break;
            case 3:
                break;
            default:
                //exit program
        }
    }

    // login
    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Your Email:");
        String email = input.nextLine();
        System.out.println("Insert Your Password:");
        String password = input.nextLine();

        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(email)) {
                if (users[i][1].equals(password)) {
                    System.out.println("Welcome Again!");
                    return true;
                } else {
                    System.out.println("Wrong Password");
                    return false;
                }
            }
        }
        System.out.println("404 not found");
        return false;
    }

    // register
    public static boolean register() {
        Scanner input = new Scanner(System.in);
        if (users[users.length - 1][0] != null) {
            System.out.println("User database is full");
            return false;
        }
        System.out.println("Insert Your Email:");
        String email = input.nextLine();
        System.out.println("Insert Your Password:");
        String password = input.nextLine();

        for (int x = 0; x < users.length; x++) {
            if (users[x][0] == null) {
                users[x][0] = email;
                users[x][1] = password;
                return true;
            } else {
                if (users[x][0].equalsIgnoreCase(email)) {
                    System.out.println("Email is already exists..!");
                    return false;
                }
            }
        }
        return false;
    }

    public static void openDashboard() {
        System.out.println("inside Dashboard");
    }

}