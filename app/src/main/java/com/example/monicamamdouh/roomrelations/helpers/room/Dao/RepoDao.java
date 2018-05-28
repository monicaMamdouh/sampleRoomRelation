package com.example.monicamamdouh.roomrelations.helpers.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.monicamamdouh.roomrelations.models.Repo;

import java.util.List;

@Dao
public interface RepoDao {

    @Query("SELECT * FROM repo")
    List<Repo> getAllRepos();

    @Query("SELECT * FROM repo WHERE userId=:userId")
    List<Repo> findRepositoriesForUser(final int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repo... repos);

    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);

}