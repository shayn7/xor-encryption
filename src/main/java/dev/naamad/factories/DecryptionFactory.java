package dev.naamad.factories;

import dev.naamad.algorithms.XorDecryptionStrategy;
import dev.naamad.decryption.DecryptionStrategy;
import dev.naamad.decryption.DecryptionWithNoKey;

public class DecryptionFactory {

    public DecryptionStrategy createXorDecryptionStrategy(){
        return new XorDecryptionStrategy();
    }

}
