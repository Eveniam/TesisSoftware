package com.example.tesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tesis.Adapter.UserAdapter;
import com.example.tesis.Entities.User;
import com.example.tesis.Utils.RetrofitBuilder;

import retrofit2.Retrofit;

public class Mostrar_Registro extends AppCompatActivity {

    RecyclerView rvUser;
    Retrofit mRetro;

    User mUser = new User();

    UserAdapter mAdapter = new UserAdapter(mUser);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_registro);


    }
}