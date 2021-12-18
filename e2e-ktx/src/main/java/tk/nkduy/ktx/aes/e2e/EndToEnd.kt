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

package tk.nkduy.ktx.aes.e2e

import tk.nkduy.ktx.aes.e2e.KeyE2E.dec
import tk.nkduy.ktx.aes.e2e.KeyE2E.enc
import tk.nkduy.ktx.aes.e2e.KeyE2E.secretKey
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets
import java.security.InvalidKeyException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import kotlin.Throws

/**
 * Method to convert plain string into Advanced Encryption Standard (AES) string
 * <br></br>
 * End-to-End Encryption (E2E)
 *
 * @author NKDuy
 */
object EndToEnd {

    /**
     * This method is used to encrypt the text string that you need
     *
     * @param text Text needs to be encrypted
     *
     * @return String is encrypted
     */
    @JvmStatic
    fun EncryptMethod(text: String): String {
        val stringByte = text.toByteArray()
        var encryptedByte = ByteArray(stringByte.size)
        try {
            enc!!.init(Cipher.ENCRYPT_MODE, secretKey)
            encryptedByte = enc!!.doFinal(stringByte)
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        }
        var returnString: String? = null
        returnString = String(encryptedByte, StandardCharsets.ISO_8859_1)
        return returnString
    }

    /**
     * This method is used to decrypt the text string that you have encrypted
     *
     * @param text Text needs to be decrypted
     *
     * @return String is decrypted
     */
    @JvmStatic
    @Throws(UnsupportedEncodingException::class)
    fun DecryptMethod(text: String): String {
        val encryptedByte = text.toByteArray(charset("ISO-8859-1"))
        var decryptedString = text
        val decryption: ByteArray
        try {
            dec!!.init(Cipher.DECRYPT_MODE, secretKey)
            decryption = dec!!.doFinal(encryptedByte)
            decryptedString = String(decryption)
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        }
        return decryptedString
    }
}
