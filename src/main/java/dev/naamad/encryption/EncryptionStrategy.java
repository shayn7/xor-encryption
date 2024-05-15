package dev.naamad.encryption;

/**
 * this interface represents the behavior of any encryption algorithm
 */
public interface EncryptionStrategy {
    int[] encrypt(String plainText, String key);
}
