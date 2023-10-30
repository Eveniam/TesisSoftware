package com.example.tesis.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey()
    public int id;

    @ColumnInfo(name = "name")
    public String nombre;

    @ColumnInfo(name = "apellido")
    public String apellido;

    @ColumnInfo(name = "usuario")
    public String usuario;

    @ColumnInfo(name = "contra")
    public String contra;
        
    @ColumnInfo(name = "conficontra")
    public String Conficontra;

    @ColumnInfo(name = "telefono")
    public int telefono;

    @ColumnInfo(name = "dni")
    public int dni;
}
