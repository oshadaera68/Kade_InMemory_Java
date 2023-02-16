import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer {
    // Database ==> access all around the project
    static String[][] users = new String[3][2];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitState = true;
        // program initialization
        String[] initializePageQuestions =
                {
                        "1. Do You want to login?",
                        "2. Are you new to here?",
                        "3. Do you want to exit the page?"
                };

        while (exitState) {
            for (String question : initializePageQuestions) {
                System.out.println(question);
            }

            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    // just for our testing process
                    users[0][0] = "oshada@gmail.com";
                    users[0][1] = "1234";
                    if (login()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    printUi("User Application");
                    break;
                case 2:
                    if (register()) {
                        printUi("Dashboard");
                        openDashboard();
                    }
                    break;
                case 3:
                    System.out.println("Good bye..!");
                    return;
                default:
                    System.out.println("Idiot, Wrong input..!\uD83D\uDE14");
                    return;
            }
        }
    }

    // login
    public static boolean login() {
        printUi("Log in");
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Your Email:");
        String email = input.nextLine();
        System.out.println("Insert Your Password:");
        String password = input.nextLine();

        for (int i = 0; i < users.length; i++) {
            if (users[i][0] != null && users[i][0].equals(email)) {
                if (users[i][1].equals(password)) {
                    System.out.println("Welcome Again!");
                    return true;
                } else {
                    System.out.println("Wrong Password");
                    return false;
                }
            }
        }
        System.out.println("404 email not found");
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

    // dashboard
    public static void openDashboard() {
        System.out.println("inside Dashboard");
    }

    public static void printUi(String position) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);
        System.out.println("===========" + simpleDate + "===========" + simpleTime + "==>" + position);
//        System.out.println("======================@System===========================================");
    }
}