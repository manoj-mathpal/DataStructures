package amazonPrep;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "abc";
        generatePermutations(input.toCharArray(), 0);
    }

    private static void generatePermutations(char[] strArray, int currentIndex) {
        if (currentIndex == strArray.length - 1) {
            System.out.println(String.valueOf(strArray));
            return;
        }

        for (int i = currentIndex; i < strArray.length; i++) {
            // Swap the current character with the character at index i
            swap(strArray, currentIndex, i);

            // Recursively generate permutations for the remaining characters
            generatePermutations(strArray, currentIndex + 1);

            // Backtrack by swapping back to the original state
            swap(strArray, currentIndex, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
