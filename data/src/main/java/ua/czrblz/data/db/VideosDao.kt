package ua.czrblz.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ua.czrblz.data.models.VideoDBModel

@Dao
interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(video: List<VideoDBModel>)

    @Query("SELECT * FROM VideoDBModel")
    fun getAllVideo(): Flow<List<VideoDBModel>>

}
