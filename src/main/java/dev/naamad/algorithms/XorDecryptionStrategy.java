package dev.naamad.algorithms;

import dev.naamad.decryption.DecryptionStrategy;

public class XorDecryptionStrategy implements DecryptionStrategy {

    @Override
    public String decrypt(int[] encrypted, String key) {

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encrypted.length; i++) {
            char currentKeyChar = key.charAt(i % key.length());
            decrypted.append((char) (encrypted[i] ^ (int) currentKeyChar));
        }

        return decrypted.toString();
    }
}
