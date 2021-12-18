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

package tk.nkduy.ktx.aes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tk.nkduy.aes.R
import tk.nkduy.ktx.aes.e2e.EndToEnd
import tk.nkduy.ktx.aes.e2e.KeyE2E
import java.io.UnsupportedEncodingException
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.SecretKeySpec

class KtxMainActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private var button: Button? = null
    private var buttonJava: Button? = null
    private var encrypt: TextView? = null
    private var decrypt:TextView? = null
    private var stringEnc: String? = null
    private var stringDec: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ktx_activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        buttonJava = findViewById(R.id.buttonJava)
        encrypt = findViewById(R.id.encrypt)
        decrypt = findViewById(R.id.decrypt)

        button!!.setOnClickListener(View.OnClickListener {
            stringEnc = EndToEnd.EncryptMethod(editText!!.text.toString())
            encrypt!!.text = "Encrypt: $stringEnc"


            try {
                stringDec = stringEnc?.let { it -> EndToEnd.DecryptMethod(it) }
                decrypt!!.text = "Decrypt: $stringDec"
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
        })

        buttonJava!!.setOnClickListener(View.OnClickListener { onBackPressed() })
    }
}
