package dev.naamad.decryption;

public interface DecryptionWithNoKey {

    String decryptWithKnowingOnlyKeyLength(int[] encrypted, int keyLength);
}
