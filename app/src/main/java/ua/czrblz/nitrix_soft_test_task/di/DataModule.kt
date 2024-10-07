package ua.czrblz.nitrix_soft_test_task.di

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module
import ua.czrblz.data.api.ApiService
import ua.czrblz.data.db.VideosDatabase
import ua.czrblz.data.mappers.DatabaseMappers
import ua.czrblz.data.mappers.VideoMappers
import ua.czrblz.data.repository.DatabaseRepositoryImpl
import ua.czrblz.data.repository.VideoRepositoryImpl
import ua.czrblz.domain.repository.DatabaseRepository
import ua.czrblz.domain.repository.VideoRepository
import ua.czrblz.network.NetworkAdapter

val dataModule = module {

    single<VideoRepository> {
        VideoRepositoryImpl(
            get(), get()
        )
    }

    single<DatabaseRepository> {
        DatabaseRepositoryImpl(
            get(), get()
        )
    }

    single<VideosDatabase> {
        Room.databaseBuilder(
            get<Context>(),
            VideosDatabase::class.java, "video_database"
        ).build()
    }

    single<ApiService> {
        NetworkAdapter().retrofit.create(ApiService::class.java)
    }

    single<VideoMappers> {
        VideoMappers()
    }

    single<DatabaseMappers> {
        DatabaseMappers()
    }
}