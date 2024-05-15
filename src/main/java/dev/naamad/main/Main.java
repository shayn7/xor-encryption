package dev.naamad.main;

import dev.naamad.decryption.DecryptionStrategy;
import dev.naamad.encryption.EncryptionStrategy;
import dev.naamad.factories.DecryptionFactory;
import dev.naamad.factories.EncryptionFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String plainText = "This is a wonder world please make it safe";
        String key = "abc";
        EncryptionFactory factory = new EncryptionFactory();
        EncryptionStrategy encryptionStrategy = factory.createXorEncryptionStrategy();
        int[] encrypted = encryptionStrategy.encrypt(plainText, key);
        System.out.println("Encrypted message: " + Arrays.toString(encrypted));
        DecryptionFactory decryptionFactory = new DecryptionFactory();
        DecryptionStrategy decryptionStrategy = decryptionFactory.createXorDecryptionStrategy();
        String decrypted = decryptionStrategy.decrypt(encrypted, key);
        System.out.println("Decrypted message: " + decrypted);
    }
}