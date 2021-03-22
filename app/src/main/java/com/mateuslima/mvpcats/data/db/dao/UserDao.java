package com.mateuslima.mvpcats.data.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mateuslima.mvpcats.data.db.model.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user_table WHERE email=(:userEmail) AND password =(:userPassword)")
    User login(String userEmail, String userPassword);

    @Query("SELECT * FROM user_table WHERE email=(:userEmail)")
    User checkEmail(String userEmail);
}
