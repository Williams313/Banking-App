


public class CaesarCipher {
    private int alphabetSize;

    public CaesarCipher() {
        this.alphabetSize = 26;
    }

    public String encrypt(String word, int count) {
        if (count < 1 || count > alphabetSize) {
            throw new IllegalArgumentException("Invalid shift count");
        }
        StringBuilder encryptedSentence = new StringBuilder();
        for (char letter : word.toCharArray()) {
            encryptedSentence.append(encryptLetter(letter, count));
        }
        return encryptedSentence.toString();
    }

    public String decrypt(String word, int count) {
        return encrypt(word, alphabetSize - count);
    }

    public char encryptLetter(char letter, int count) {
        if (Character.isUpperCase(letter)) {
            return (char) ('A' + (letter - 'A' + count) % alphabetSize);
        } else if (Character.isLowerCase(letter)) {
            return (char) ('a' + (letter - 'a' + count) % alphabetSize);
        } else {
            return letter; // non-alphabetical characters remain unchanged
        }
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        String word = "Hello, World!";
        int count = 3;
        String encryptedWord = caesarCipher.encrypt(word, count);
        String decryptedWord = caesarCipher.decrypt(encryptedWord, count);
        System.out.println("Original word: " + word);
        System.out.println("Encrypted word: " + encryptedWord);
        System.out.println("Decrypted word: " + decryptedWord);
    }
}


