package com.example.monicamamdouh.roomrelations.helpers.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.monicamamdouh.roomrelations.models.Repo;
import com.example.monicamamdouh.roomrelations.models.User;
import com.example.monicamamdouh.roomrelations.models.UserRepoJoin;

import java.util.List;

@Dao
public interface UserRepoJoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserRepoJoin userRepoJoin);

    @Query("SELECT * FROM user INNER JOIN user_repo_join ON user_repo_join.userId=user.id INNER JOIN repo ON user_repo_join.repoId=repo.id WHERE user_repo_join.repoId=:repoId")
    List<User> getUsersForRepository(final int repoId);


    @Query("SELECT * FROM repo INNER JOIN user_repo_join ON Repo.id = user_repo_join.repoId INNER JOIN user ON user_repo_join.userId=user.id WHERE user.id =:userId")
    List<Repo> getRepositoriesForUsers(final int userId);
}