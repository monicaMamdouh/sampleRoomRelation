package com.example.monicamamdouh.roomrelations.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(
        tableName = "repo", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId"))
//@Entity
public class Repo {
    @PrimaryKey
    @NonNull

    public int id;

    public String name;

    public String url;

    public int userId;

    @Ignore
    public Repo(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }


    public Repo(int id, String name, String url, int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }
}