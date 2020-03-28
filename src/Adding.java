import java.util.Scanner;

public class Adding {
    public static String addGhostString(String addedPart, int diff) {
        int addedPartLength = addedPart.length();

        while (addedPartLength < diff) {
            addedPart += "0";
            addedPartLength++;
        }
        return addedPart;
    }

    public static void printResult(String result) {
        System.out.print("SUM = ");

        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first binary number:");
        String binary1 = scanner.nextLine();
        System.out.println("Type first binary number:");
        String binary2 = scanner.nextLine();

        String result = "";
        int lengthBinary1 = binary1.length();
        int lengthBinary2 = binary2.length();

        if ((lengthBinary1 != lengthBinary2)) {
            String addedPart = "";

            if (lengthBinary1 > lengthBinary2) {
                int diff = lengthBinary1 - lengthBinary2;
                addedPart = addGhostString(addedPart, diff);
                binary2 = addedPart + binary2;
            } else if (lengthBinary1 < lengthBinary2) {
                int diff = lengthBinary2 - lengthBinary1;
                addedPart = addGhostString(addedPart, diff);
                binary1 = addedPart + binary1;
            }
        }

        int place = binary1.length() - 1;
        int carry = 0;

        while (place >= 0) {
            if (binary1.charAt(place) == '0' && binary2.charAt(place) == '0' && carry == 0) {
                result += "0";
            } else if (binary1.charAt(place) == '0' && binary2.charAt(place) == '1' || (binary1.charAt(place) == '1' && binary2.charAt(place) == '0') && carry == 0) {
                result = result + "1";
            } else if (binary1.charAt(place) == '1' && binary2.charAt(place) == '1' && carry == 0) {
                result = result + "0";
                carry = 1;
            } else if (binary1.charAt(place) == '0' && binary2.charAt(place) == '0' && carry == 1) {
                result += "1";
                carry = 0;
            } else if (binary1.charAt(place) == '0' && binary2.charAt(place) == '1' || (binary1.charAt(place) == '1' && binary2.charAt(place) == '0') && carry == 1) {
                result = result + "0";
            } else if (binary1.charAt(place) == '1' && binary2.charAt(place) == '1' && carry == 1) {
                result = result + "1";
            }

            place -= 1;
        }

        if (carry == 1) {
            result += "1";
            printResult(result);
        } else {
            printResult(result);
        }
    }
}