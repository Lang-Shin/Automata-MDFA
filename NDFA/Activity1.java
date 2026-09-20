import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Activity1 {

    static String validComment(String s) {

        if(s.length() < 4) return  "NO";

        int state = 0;

        for(char c : s.toCharArray()) {
            switch(state) {
                case 0:
                    state = (c == '/') ? 1 : -1;
                    break;
                case 1:
                    state = (c == '*') ? 2 : -1;
                    break;
                case 2:
                    state = (c == '*') ? 3 : 2;
                    break;
                case 3:
                    if(c == '/') state=4;
                    else if(c == '*') state=3;
                    else state=2;
                    break;
                case 4:
                    state=-1;
                    break;
            }

            if(state==-1) return "NO";
        }

        return (state==4) ? "YES" : "NO";

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(validComment(s));

    }
}