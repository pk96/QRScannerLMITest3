package com.example.pranavb.qrscannerlimtest2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.Result;

import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.example.pranavb.qrscannerlimtest2.R.id.usernameTextField;

public class MainActivity extends AppCompatActivity {
    private ZXingScannerView mScannerView;
    private Button loginButton;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.usernameTextField);
        password = (EditText)findViewById(R.id.passwordTextField);
        loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                startScanner(name);
            }
        });
    }

    private void startScanner(String name) {

        Intent intent = new Intent(this,ScannerActivity.class);
        Resources resource = getResources();
        String namekey = resource.getString(R.string.username);
        intent.putExtra(namekey,name);
        startActivity(intent);
    }



    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

}
