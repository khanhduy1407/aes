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

package tk.nkduy.aes;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tk.nkduy.aes.e2e.KeyE2E;
import tk.nkduy.aes.e2e.EndToEnd;
import tk.nkduy.ktx.aes.KtxMainActivity;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button, buttonKotlin;
    private TextView encrypt, decrypt;

    private String stringEnc, stringDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        buttonKotlin = findViewById(R.id.buttonKotlin);
        encrypt = findViewById(R.id.encrypt);
        decrypt = findViewById(R.id.decrypt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringEnc = EndToEnd.EncryptMethod(editText.getText().toString());
                encrypt.setText("Encrypt: " + stringEnc);


                try {
                    stringDec = EndToEnd.DecryptMethod(stringEnc);
                    decrypt.setText("Decrypt: " + stringDec);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KtxMainActivity.class));
            }
        });
    }
}
