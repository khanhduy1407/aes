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

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Key End-to-End Encryption (E2E)
 *
 * @author NKDuy
 */
object KeyE2E {

    var enc: Cipher? = Cipher.getInstance("AES")

    var dec: Cipher? = Cipher.getInstance("AES")

    private val encryptionKey = byteArrayOf(9, 115, 51, 86, 105, 4, -31, -23, -68, 88, 17, 20, 3, -105, 119, -53)

    var secretKey = SecretKeySpec(encryptionKey, "AES")
}
