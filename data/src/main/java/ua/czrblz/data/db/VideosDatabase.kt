package ua.czrblz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.czrblz.data.models.VideoDBModel

@Database(entities = [VideoDBModel::class], version = 1)
abstract class VideosDatabase : RoomDatabase() {
    abstract fun moviesDao(): VideosDao
}
