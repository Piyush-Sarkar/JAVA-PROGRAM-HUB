import java.util.*;
public class count_String {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a paragraph: ");
            String p = sc.nextLine();
            int c = p.replace(" ", " "). length();
            int w = p.trim(). split("\\s"). length;
            System.out.println("Chars: " + c + ", Words: " + w);
        }
    }
}