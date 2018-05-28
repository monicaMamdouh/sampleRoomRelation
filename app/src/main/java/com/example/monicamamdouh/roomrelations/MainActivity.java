package com.example.monicamamdouh.roomrelations;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.monicamamdouh.roomrelations.helpers.room.Dao.RepoDao;
import com.example.monicamamdouh.roomrelations.helpers.room.Dao.UserDao;
import com.example.monicamamdouh.roomrelations.helpers.room.Dao.UserRepoJoinDao;
import com.example.monicamamdouh.roomrelations.helpers.room.database.RepoDatabase;
import com.example.monicamamdouh.roomrelations.models.Repo;
import com.example.monicamamdouh.roomrelations.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RepoDao repoDao;
    private UserRepoJoinDao userRepoJoinDao;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = RepoDatabase.getInstance(getApplicationContext()).getUserDao();
        repoDao = RepoDatabase.getInstance(getApplicationContext()).getRepoDao();
        userRepoJoinDao = RepoDatabase.getInstance(getApplicationContext()).getUserRepoJoinDao();

        //__________________________________one to many__________________________
        // updateRepos();
        // insertUser();
        // insetRepository();
        // deleteRepos();
        //getUsers();
        //updatedUser();
        //getUserRepository();

        //_______________________________many to many___________________________

      //  insertManyToMany();
       // getManyToMany();
        getManyToManyUser();


    }

    private void getManyToMany() {
        manyToManyGetAsyncTask.execute();
    }

    private void getManyToManyUser() {
        manyToManyGetUserAsyncTask
                .execute();
    }

    private void insertManyToMany() {
        manyToManyInsertAsyncTask.execute();
    }

    private AsyncTask<Void, Void, List<Repo>> manyToManyGetAsyncTask = new AsyncTask<Void, Void, List<Repo>>() {
        @Override
        protected List<Repo> doInBackground(Void... voids) {


            return userRepoJoinDao.getRepositoriesForUsers(1);


        }

        @Override
        protected void onPostExecute(List<Repo> aVoid) {
            super.onPostExecute(aVoid);
        }
    };

    private AsyncTask<Void, Void, List<User>> manyToManyGetUserAsyncTask = new AsyncTask<Void, Void, List<User>>() {
        @Override
        protected List<User> doInBackground(Void... voids) {


            return userRepoJoinDao.getUsersForRepository(1);


        }

        @Override
        protected void onPostExecute(List<User> aVoid) {
            super.onPostExecute(aVoid);
        }
    };
    private AsyncTask<Void, Void, Void> manyToManyInsertAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User(1,
                    "a",
                    "https://avatars0.githubusercontent.com/u/66577"));
            userDao.insert(new User(2,
                    "b",
                    "https://avatars0.githubusercontent.com/u/66577"));
            userDao.insert(new User(3,
                    "c",
                    "https://avatars0.githubusercontent.com/u/66577"));
            repoDao.insert(new Repo(1,
                    "aa",
                    "https://github.com/square/retrofit", 2));
            repoDao.insert(new Repo(2,
                    "bb",
                    "https://github.com/square/retrofit", 1));
            repoDao.insert(new Repo(3,
                    "cc",
                    "https://github.com/square/retrofit", 1));
            repoDao.insert(new Repo(4,
                    "dd",
                    "https://github.com/square/retrofit", 2));
            repoDao.insert(new Repo(5,
                    "ee",
                    "https://github.com/square/retrofit", 2));

//            userRepoJoinDao.insert(new UserRepoJoin(1, 1));
//            userRepoJoinDao.insert(new UserRepoJoin(2, 1));
//
//            userRepoJoinDao.insert(new UserRepoJoin(3, 1));


            return null;

        }
    };


    private void insertUser() {
        userAsyncTask.execute();

    }

    private void updateRepos() {
        repositoryUpdateAsyncTask.execute();

    }

    private void deleteRepos() {

        repositoryDeleteAsyncTask.execute();
    }

    private AsyncTask<Void, Void, Void> userAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User(2,
                    "Jake Wharton",
                    "https://avatars0.githubusercontent.com/u/66577"));
            return null;

        }
    };
    private AsyncTask<Void, Void, Void> repositoryDeleteAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            repoDao.delete(new Repo(1,
                    "updatedA",
                    "https://github.com/square/retrofit", 1));

            return null;

        }
    };

    private void updatedUser() {
        userUpdateAsyncTask.execute();
    }

    private AsyncTask<Void, Void, Void> userUpdateAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.update(new User(2,
                    "monica",
                    "https://avatars0.githubusercontent.com/u/66577"));

            return null;

        }
    };

    private AsyncTask<Void, Void, Void> repositoryUpdateAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            repoDao.update(new Repo(1,
                    "updatedA",
                    "https://github.com/square/retrofit", 1));

            return null;

        }
    };
    private AsyncTask<Void, Void, Void> repositoryAsyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            repoDao.insert(new Repo(1,
                    "a",
                    "https://github.com/square/retrofit",
                    1));
            repoDao.insert(new Repo(2,
                    "b",
                    "https://github.com/square/retrofit",
                    1));
            repoDao.insert(new Repo(3,
                    "c",
                    "https://github.com/square/retrofit",
                    1));
            repoDao.insert(new Repo(1,
                    "c",
                    "https://github.com/square/retrofit",
                    2));
            return null;

        }
    };

    private void getUserRepository() {
        getRepoAsyncTask.execute();
    }

    private AsyncTask<Void, Void, List<Repo>> getRepoAsyncTask = new AsyncTask<Void, Void, List<Repo>>() {
        @Override
        protected List<Repo> doInBackground(Void... voids) {
            return repoDao.findRepositoriesForUser(2);
        }

        @Override
        protected void onPostExecute(List<Repo> repos) {
            super.onPostExecute(repos);
        }

    };

    private void getUsers() {
        getUsersAsyncTask.execute();
    }

    private AsyncTask<Void, Void, List<User>> getUsersAsyncTask = new AsyncTask<Void, Void, List<User>>() {
        @Override
        protected List<User> doInBackground(Void... voids) {
            return userDao.getAllUsers();
        }

        @Override
        protected void onPostExecute(List<User> repos) {
            super.onPostExecute(repos);
        }

    };


    private void insetRepository() {

        repositoryAsyncTask.execute();
    }

}
