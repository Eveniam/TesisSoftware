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
import com.example.tesis.Entities.LocationData;
import com.example.tesis.Entities.User;
import com.example.tesis.Repository.UserRepository;
import com.example.tesis.Service.UserService;
import com.example.tesis.Utils.RetrofitBuilder;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Registrar_usuario extends AppCompatActivity {

    EditText edName,edApellido,edUsuario,edContra,edContra2,edTelefono,edDNI;
    Button btnRegistrar;
    Retrofit mRetro;
    UserService userService;
    int idObtener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        mRetro = RetrofitBuilder.build();

        edName = findViewById(R.id.edName);
        edApellido = findViewById(R.id.edApellido);
        edUsuario = findViewById(R.id.edUsuario);
        edContra = findViewById(R.id.edContra);
        edContra2 = findViewById(R.id.edContra2);
        edTelefono = findViewById(R.id.edTelefono);
        edDNI = findViewById(R.id.edDNI);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        UserRepository userRepository = db.userRepository();
        userService = mRetro.create(UserService.class);

        double Latitud = LocationData.getInstance().getLatitude();
        double Longitud = LocationData.getInstance().getLongitude();
        Log.d("MAIN_APP3-Lat", String.valueOf(Latitud));
        Log.d("MAIN_APP3-Long", String.valueOf(Longitud));

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edContra.getText().toString().trim().isEmpty() == edContra2.getText().toString().trim().isEmpty()){
                    Toast.makeText(getBaseContext(), "CONTRASEÑAS DIFERENTES", Toast.LENGTH_SHORT).show();
                }else{
                    User user = new User();
                    idObtener = user.id;
                    user.nombre = edName.getText().toString();
                    user.apellido = edApellido.getText().toString();
                    user.contra = edContra.getText().toString();
                    user.Conficontra = edContra2.getText().toString();
                    String value= edTelefono.getText().toString();
                    user.telefono = Integer.parseInt(value);
//                    userRepository.create(user);
                    if(isNetworkConnected()){
                        Call<User> call = userService.create(user);
                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                User user = response.body();
                                Toast.makeText(getBaseContext(), "DATOS SINCRONIZADOS", Toast.LENGTH_SHORT).show();
                                Log.i("MAIN_APP: Web", new Gson().toJson(user));
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                            }
                        });

                    }
                }
                Intent intent = new Intent(getApplicationContext(), Mostrar_Registro.class);
                intent.putExtra("id",idObtener);
                startActivity(intent);
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}