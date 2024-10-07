package ua.czrblz.nitrix_soft_test_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import ua.czrblz.nitrix_soft_test_task.screen.MainScreen
import ua.czrblz.nitrix_soft_test_task.ui.theme.Nitrix_Soft_test_taskTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nitrix_Soft_test_taskTheme {
                MainScreen(viewModel)
            }
        }
    }
}
