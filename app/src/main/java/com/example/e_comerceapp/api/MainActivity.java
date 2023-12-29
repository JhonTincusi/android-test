package com.example.e_comerceapp.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_comerceapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "Username / Passoword Required", Toast.LENGTH_LONG).show();

                }else{

                    login();
                }
            }
        });
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Loggiin Succesfully", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            startActivity(new Intent(MainActivity.this, NavigationActivity.class).putExtra("data", loginResponse.getData().getUser().getUsername()));
                        }
                    }, 700);

                }else{
                    Log.e("LoginError", "Código de estado: " + response.code());
                    if(response.errorBody() != null){
                        try {
                            String errorBody = response.errorBody().string();
                            Log.e("LoginError", "Cuerpo del error: " + errorBody);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}