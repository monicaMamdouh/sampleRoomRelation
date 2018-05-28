package com.example.monicamamdouh.roomrelations.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "user_repo_join",
        primaryKeys = {"userId", "repoId"},
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId", onDelete = CASCADE),

                @ForeignKey(entity = Repo.class,
                        parentColumns = "id",
                        childColumns = "repoId", onDelete = CASCADE)})

public class UserRepoJoin {

    public int userId;
    public int repoId;

    public UserRepoJoin( int userId,  int repoId) {
        this.userId = userId;
        this.repoId = repoId;
    }
}
