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

    @Query("SELECT * FROM user INNER JOIN user_repo_join ON user.id=user_repo_join.userId WHERE user_repo_join.repoId=:repoId")
    List<User> getUsersForRepository(final int repoId);

    @Query("SELECT * FROM repo LEFT JOIN user_repo_join ON Repo.userId = user_repo_join.repoId WHERE repo.userId =:userId")
    List<Repo> getRepositoriesForUsers(final int userId);
}