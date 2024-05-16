package dev.naamad.algorithms;

import dev.naamad.decryption.DecryptionStrategy;
import dev.naamad.decryption.DecryptionWithNoKey;
import java.util.*;

public class XorDecryptionStrategy implements DecryptionStrategy, DecryptionWithNoKey {

    @Override
    public String decrypt(int[] encrypted, String key) {

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encrypted.length; i++) {
            char currentKeyChar = key.charAt(i % key.length());
            decrypted.append((char) (encrypted[i] ^ (int) currentKeyChar));
        }

        return decrypted.toString();
    }

    @Override
    public String decryptWithKnowingOnlyKeyLength(int[] cipherText, int keyLength) {

        int[] key = new int[keyLength]; // Array to store the guessed key

        // Attempt to guess the key using frequency analysis
        for (int i = 0; i < keyLength; i++) {
            key[i] = guessKeyForPosition(cipherText, keyLength, i);
        }

        System.out.println("Guessed Key: " + Arrays.toString(key));

        // Decrypt the ciphertext with the guessed key
        return decrypt(cipherText, key);
    }

    /**
     * Guess the key byte for a specific position in the repeating key.
     * @param cipherText The array of encrypted bytes.
     * @param keyLength The length of the repeating key.
     * @param position The specific position in the key to guess.
     * @return The guessed key byte for the given position.
     */
    private int guessKeyForPosition(int[] cipherText, int keyLength, int position) {
        int[] frequencies = new int[256]; // Array to count byte frequencies

        // Count the occurrences of each byte in the position
        for (int i = position; i < cipherText.length; i += keyLength) {
            frequencies[cipherText[i]]++;
        }

        // Find the byte with the highest frequency
        int maxFrequency = 0;
        int likelyCipherByte = 0;
        for (int i = 0; i < 256; i++) {
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
                likelyCipherByte = i;
            }
        }

        // Guess the key by assuming the most frequent byte represents a space character (ASCII 32)
        return likelyCipherByte ^ 32;
    }

    /**
     * Decrypt the ciphertext using the guessed key.
     * @param cipherText The array of encrypted bytes.
     * @param key The guessed key.
     * @return The decrypted message as a string.
     */
    private String decrypt(int[] cipherText, int[] key) {
        StringBuilder plainText = new StringBuilder(); // To store the decrypted message

        // Decrypt each byte using the corresponding key byte
        for (int i = 0; i < cipherText.length; i++) {
            int keyByte = key[i % key.length]; // Cycle through the key bytes
            int plainByte = cipherText[i] ^ keyByte; // XOR to get the original byte
            plainText.append((char) plainByte); // Convert byte to char and append to the message
        }

        return plainText.toString(); // Return the decrypted message
    }

}








