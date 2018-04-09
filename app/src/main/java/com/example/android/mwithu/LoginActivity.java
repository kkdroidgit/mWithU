package com.example.android.mwithu;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

import jp.wasabeef.blurry.Blurry;

public class LoginActivity extends AppCompatActivity {


    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Blurry.with(LoginActivity.this)
                        .radius(10)
                        .sampling(8)
                        .color(Color.argb(66, 255, 255, 0))
                        .async()
                        .onto((RelativeLayout) findViewById(R.id.login_layout));
            }
        });

        List<AuthUI.IdpConfig> loginProviders = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build()
        );

        /*startActivityForResult(
                AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(loginProviders)
                .setTheme(R.style.LoginTheme)
                .setLogo(R.mipmap.logo)
                .setIsSmartLockEnabled(false)
                .build(),
                RC_SIGN_IN);*/

    }
}
