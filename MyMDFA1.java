public class MyMDFA1 {
    public static void main(String[] args) {
        // 2 accepted, 2 rejected test cases (no manual input needed)
        String[] tests = {"000", "110", "111", "00"};

        for (String input : tests) {
            String state = "A"; // start state

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (state.equals("A")) {
                    state = "BC";              // A -0-> BC, A -1-> BC
                } else if (state.equals("BC")) {
                    state = "D";               // BC -0-> D, BC -1-> D
                } else if (state.equals("D")) {
                    state = (c == '0') ? "E" : "A"; // D -0-> E, D -1-> A
                } else if (state.equals("E")) {
                    state = "E";               // E -0-> E, E -1-> E
                }
            }

            String result = state.equals("E") ? "ACCEPTED" : "REJECTED";
            System.out.println("Input: " + input + " -> " + result);
        }
    }
}