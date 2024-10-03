package ua.czrblz.nitrix_soft_test_task

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import ua.czrblz.nitrix_soft_test_task.di.appModule
import ua.czrblz.nitrix_soft_test_task.di.dataModule
import ua.czrblz.nitrix_soft_test_task.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@App)
            allowOverride(true)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}