package dev.naamad.decryption;

public interface DecryptionStrategy {
    String decrypt(int[] encrypted, String key);
}
