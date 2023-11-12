package com.example.tesis.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tesis.Entities.User;
import com.example.tesis.Repository.UserRepository;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserRepository userRepository();

    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "BDFINAL")
                .allowMainThreadQueries()
                .build();
    }
}
