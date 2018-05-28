package com.example.monicamamdouh.roomrelations.helpers.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.monicamamdouh.roomrelations.helpers.room.Dao.RepoDao;
import com.example.monicamamdouh.roomrelations.helpers.room.Dao.UserDao;
import com.example.monicamamdouh.roomrelations.helpers.room.Dao.UserRepoJoinDao;
import com.example.monicamamdouh.roomrelations.models.Repo;
import com.example.monicamamdouh.roomrelations.models.User;
import com.example.monicamamdouh.roomrelations.models.UserRepoJoin;


@Database(entities = {Repo.class, User.class, UserRepoJoin.class},
        version = 42)
public abstract class RepoDatabase extends RoomDatabase {

    private static final String DB_NAME = "repoDatabase.db";
    private static volatile RepoDatabase instance;

    public static synchronized RepoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static RepoDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                RepoDatabase.class,
                DB_NAME).fallbackToDestructiveMigration().build();
    }

    public abstract RepoDao getRepoDao();
    public abstract UserDao getUserDao();
    public abstract UserRepoJoinDao getUserRepoJoinDao();



}