package dev.naamad.factories;

import dev.naamad.algorithms.XorDecryptionStrategy;
import dev.naamad.decryption.DecryptionWithNoKey;

public class DecryptionWithNoKeyFactory {

    public DecryptionWithNoKey createXorDecryptionStrategy(){
        return new XorDecryptionStrategy();
    }
}
