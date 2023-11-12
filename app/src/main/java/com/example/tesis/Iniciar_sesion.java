package com.example.tesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tesis.DB.AppDatabase;
import com.example.tesis.Repository.UserRepository;
import com.example.tesis.Service.UserService;
import com.example.tesis.Utils.RetrofitBuilder;

import retrofit2.Retrofit;

public class Iniciar_sesion extends AppCompatActivity {

    EditText etUser, etContra;
    Button btnIniciar,btnReg,btnOlv,btnRecu;

    Retrofit mRetro;
    UserService userService;
    UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        Toast.makeText(getBaseContext(), " BIENVENIDOS", Toast.LENGTH_SHORT).show();

        mRetro = RetrofitBuilder.build();

        etUser = findViewById(R.id.etUser);
        etContra = findViewById(R.id.etContra);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnReg = findViewById(R.id.btnReg);
        btnOlv = findViewById(R.id.btnOlv);
        btnRecu = findViewById(R.id.btnOlv);

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        userRepository = db.userRepository();
        userService = mRetro.create(UserService.class);
        Log.i("MAIN_APP: MAIN", "ENTRANDO");

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registrar_usuario.class);
            }
        });

        if(isNetworkConnected()) {

        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}