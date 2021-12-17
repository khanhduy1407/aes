/*
 * Copyright © 2021 NKDuy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tk.nkduy.aes.e2e;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import static tk.nkduy.aes.e2e.KeyE2E.*;

/**
 * Method to convert plain string into Advanced Encryption Standard (AES) string
 * <br/>
 * End-to-End Encryption (E2E)
 *
 * @author NKDuy
 */
public class EndToEnd {

    /**
     * This method is used to encrypt the text string that you need
     *
     * @param text Text needs to be encrypted
     *
     * @return String is encrypted
     */
    public static String EncryptMethod(String text) {
        byte[] stringByte = text.getBytes();
        byte[] encryptedByte = new byte[stringByte.length];

        try {
            enc.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedByte = enc.doFinal(stringByte);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        String returnString = null;
        try {
            returnString = new String(encryptedByte, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return returnString;
    }

    /**
     * This method is used to decrypt the text string that you have encrypted
     *
     * @param text Text needs to be decrypted
     *
     * @return String is decrypted
     */
    public static String DecryptMethod(String text) throws UnsupportedEncodingException {
        byte[] encryptedByte = text.getBytes("ISO-8859-1");
        String decryptedString = text;

        byte[] decryption;

        try {
            dec.init(Cipher.DECRYPT_MODE, secretKey);
            decryption = dec.doFinal(encryptedByte);
            decryptedString = new String(decryption);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return decryptedString;
    }

}
