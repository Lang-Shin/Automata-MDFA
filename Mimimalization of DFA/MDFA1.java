import java.util.Scanner;

public class MDFA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String input = sc.nextLine();

        String state = "AC"; // start state

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (state.equals("AC")) {
                state = (c == '0') ? "B" : "AC";
            } else if (state.equals("B")) {
                state = (c == '0') ? "B" : "D";
            } else if (state.equals("D")) {
                state = (c == '0') ? "B" : "E";
            } else if (state.equals("E")) {
                state = (c == '0') ? "B" : "AC";
            }
        }

        if (state.equals("E")) {
            System.out.println("ACCEPTED");
        } else {
            System.out.println("REJECTED");
        }

        sc.close();
    }
}