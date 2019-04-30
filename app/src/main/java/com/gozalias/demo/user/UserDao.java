package com.gozalias.demo.user;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void save(User user);

    @Query("SELECT * FROM user")
    LiveData<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    LiveData<User> loadAllByIds(int[] userIds);

}
