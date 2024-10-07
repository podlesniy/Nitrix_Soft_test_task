package ua.czrblz.nitrix_soft_test_task.di

import org.koin.dsl.module
import ua.czrblz.domain.usecase.GetVideosFromDBUseCase
import ua.czrblz.domain.usecase.GetVideosFromServerUseCase
import ua.czrblz.domain.usecase.SaveVideosInfoToDBUseCase

val domainModule = module {

    single<GetVideosFromDBUseCase> {
        GetVideosFromDBUseCase(
            get()
        )
    }

    single<GetVideosFromServerUseCase> {
        GetVideosFromServerUseCase(
            get()
        )
    }

    single<SaveVideosInfoToDBUseCase> {
        SaveVideosInfoToDBUseCase(
            get()
        )
    }
}