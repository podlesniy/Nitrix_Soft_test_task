package ua.czrblz.nitrix_soft_test_task.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ua.czrblz.nitrix_soft_test_task.R
import ua.czrblz.nitrix_soft_test_task.ui.theme.Typography

@Composable
fun EmptyView(
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.empty_view),
            textAlign = TextAlign.Center,
            style = Typography.displayMedium
        )
    }
}