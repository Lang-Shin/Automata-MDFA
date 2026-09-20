import java.util.Scanner;

public class MDFA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String input = sc.nextLine();

        String state = "AB"; // start state

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (state.equals("AB")) {
                state = (c == '0') ? "AB" : "CDE";
            } else if (state.equals("CDE")) {
                state = (c == '0') ? "CDE" : "F";
            } else if (state.equals("F")) {
                state = "F";
            }
        }

        if (state.equals("CDE")) {
            System.out.println("ACCEPTED");
        } else {
            System.out.println("REJECTED");
        }

        sc.close();
    }
}