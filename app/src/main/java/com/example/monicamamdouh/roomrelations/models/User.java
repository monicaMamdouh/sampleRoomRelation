package com.example.monicamamdouh.roomrelations.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

//@Entity(indices={@Index(value="postalCode", unique=true)})
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public final int id;
    @ColumnInfo(name = "login")

    public final String login;
    @ColumnInfo(name = "avatarUrl")

    public final String avatarUrl;

    public User(int id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
}