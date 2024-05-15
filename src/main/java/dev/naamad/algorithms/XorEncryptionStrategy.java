package dev.naamad.algorithms;

import dev.naamad.encryption.EncryptionStrategy;

public class XorEncryptionStrategy implements EncryptionStrategy {

    /**
     * Encrypts the given plaintext using XOR encryption with the provided key.
     *
     * @param text The text to be encrypted.
     * @param key  The encryption key.
     * @return The encrypted text as an integer array.
     */
    @Override
    public int[] encrypt(String text, String key) {

        int[] encryptedText = new int[text.length()];

        // Iterate through each character of the text
        for (int i = 0; i < text.length(); i++) {
            // Get the i-th character of the text
            char currentChar = text.charAt(i);
            // Get the i-th character of the key, repeating the key if necessary
            char currentKeyChar = key.charAt(i % key.length());
            // Encrypt the character by performing a XOR operation between the character and the key character
            encryptedText[i] = (int) currentChar ^ (int) currentKeyChar;
        }

        return encryptedText;
    }

}
