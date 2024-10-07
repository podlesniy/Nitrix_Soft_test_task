package ua.czrblz.nitrix_soft_test_task.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ua.czrblz.nitrix_soft_test_task.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            get(),
            get(),
            get()
        )
    }
}