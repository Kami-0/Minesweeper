package ru.kami.minesweeper.model.security;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public final class AesCipher {
    private static final String KEY = "Focus Start Best";
    private final SecretKeySpec secretKeySpec;
    private Cipher cipher;

    public AesCipher() {
        this.secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        String transformation = "AES/ECB/PKCS5Padding";
        try {
            this.cipher = Cipher.getInstance(transformation);
        } catch (Exception e) {
            log.error("Ошибка во время инициализации инстанса шифра ", e);
        }
    }

    public byte[] encrypt(String text) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            log.error("Ошибка во время шифрования текста {}", text, e);
            return new byte[]{};
        }
    }

    public String decrypt(byte[] encrypted) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            return new String(decrypted);
        } catch (Exception e) {
            log.error("Ошибка во время дешифрования текста {}", encrypted, e);
            return "";
        }
    }
}
