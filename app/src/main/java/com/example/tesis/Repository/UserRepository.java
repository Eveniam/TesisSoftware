package com.example.tesis.Repository;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tesis.Entities.User;

import java.util.List;

@Dao
public interface UserRepository {

    @Insert
    void create(User user);

//    @Query("SELECT * FROM User WHERE id LIKE :id")
//    List<User> searchCartaID(int id);
}
