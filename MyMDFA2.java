public class MyMDFA2 {
    public static void main(String[] args) {
        // 2 accepted, 2 rejected test cases (no manual input needed)
        String[] tests = {"01", "11", "00", "0"};

        for (String input : tests) {
            String state = "A"; // start state

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (state.equals("A")) {
                    state = "BC";                     // A -0-> BC, A -1-> BC
                } else if (state.equals("BC")) {
                    state = (c == '0') ? "D" : "EF";  // BC -0-> D, BC -1-> EF
                } else if (state.equals("D")) {
                    state = "EF";                      // D -0-> EF, D -1-> EF
                } else if (state.equals("EF")) {
                    state = "EF";                      // EF -0-> EF, EF -1-> EF
                }
            }

            String result = state.equals("EF") ? "ACCEPTED" : "REJECTED";
            System.out.println("Input: " + input + " -> " + result);
        }
    }
}