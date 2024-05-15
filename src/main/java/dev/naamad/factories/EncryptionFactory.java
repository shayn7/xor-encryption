package dev.naamad.factories;

import dev.naamad.algorithms.XorEncryptionStrategy;
import dev.naamad.encryption.EncryptionStrategy;

public class EncryptionFactory {

    public EncryptionStrategy createXorEncryptionStrategy() {
        return new XorEncryptionStrategy();
    }
}
