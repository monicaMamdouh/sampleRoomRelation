package com.example.monicamamdouh.roomrelations.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithRepos {
    @Embedded public User user;

    @Relation(parentColumn = "id",
            entityColumn = "userId") public List<Repo> repoList;
}