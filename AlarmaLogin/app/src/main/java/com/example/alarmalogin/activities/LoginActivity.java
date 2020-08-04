package com.example.alarmalogin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.alarmalogin.R;
import com.example.alarmalogin.api.Api;
import com.example.alarmalogin.api.RetrofitClient;
import com.example.alarmalogin.models.LoginResponse;
import com.example.alarmalogin.models.User;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    RetrofitClient  retrofitClient;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private   Api api ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        findViewById(R.id.buttonLogin).setOnClickListener(this);

        postRequest();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                userLogin();
                break;
        }
    }

    private void userLogin() {

        String usuario = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
/*
      if (email.isEmpty()){
          editTextEmail.setError("email is required");
          editTextEmail.requestFocus();
          return;
      }
      if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
          editTextEmail.setError("Enter a valid email");
          editTextEmail.requestFocus();
          return;
      }
      if (password.isEmpty()){
          editTextPassword.setError("Password required");
          editTextPassword.requestFocus();
          return;
      }
      if (password.length() < 6 ){
          editTextPassword.setError("Password should be atleast 6 character long");
          editTextPassword.requestFocus();
          return;
      } */


        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsuario("martinez");
        loginResponse.setPasword("123456");



        Call<LoginResponse> call = api.userLogin(loginResponse);




        call.enqueue(new Callback<LoginResponse>() {
            @Override   // este metodo es para mostrarle al usuario que la operacion se realizo con exito
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                /*
                LoginResponse loginResponse = response.body();

                Intent intent = new Intent(LoginActivity.this,SesionAbierta.class);
                startActivity(intent);
*/
                System.out.println(response.body().toString());
                 /*
                if(!loginResponse.isError()){

                    //proceed with the Login
                    //save user
                    //open profile
                    //Toast.makeText( LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this,SesionAbierta.class);
                    startActivity(intent);

                }else{

                    //Log.e("Error",t.getMessage());
                    //muestra el error traido del json
                    Toast.makeText( LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

                }*/

            }

            @Override// muestra el error
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Error Usuario o contraseña",Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void postRequest(){

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://incidencias-servicio-backend.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api= retrofit.create(Api.class);
            userLogin();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }


}