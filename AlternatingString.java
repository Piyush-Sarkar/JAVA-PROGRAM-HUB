import java.util.*;

public class AlternatingString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the binary string
        String binaryString = sc.nextLine();
        
        // Input the worth array
        String[] worthsStr = sc.nextLine().split(" ");
        int n = binaryString.length();
        int[] worths = new int[n];
        
        for (int i = 0; i < n; i++) {
            worths[i] = Integer.parseInt(worthsStr[i]);
        }
        
        // Calculate the removal worths for two patterns
        int removeWorth1 = calculateRemoveWorth(binaryString, worths, '0');
        int removeWorth2 = calculateRemoveWorth(binaryString, worths, '1');
        
        // Output the minimum worth of characters removed
        System.out.println(Math.min(removeWorth1, removeWorth2));
        sc.close();
    }

    // Function to calculate the worth of characters to remove to form alternating sequence
    private static int calculateRemoveWorth(String binaryString, int[] worths, char startChar) {
        int totalWorth = 0; // Total worth of removed characters
        char expectedChar = startChar;
        
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != expectedChar) {
                // This character is not part of the alternating sequence, remove it
                totalWorth += worths[i];
            } else {
                // Flip the expected character for the next position
                expectedChar = (expectedChar == '0') ? '1' : '0';
            }
        }
        return totalWorth;
    }
}
//100101110110 5 19 8 7 6 15 4 3 2 1 10 8