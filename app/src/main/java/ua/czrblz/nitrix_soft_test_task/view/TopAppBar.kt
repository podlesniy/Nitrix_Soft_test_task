package ua.czrblz.nitrix_soft_test_task.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ua.czrblz.nitrix_soft_test_task.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onRefreshClick: () -> Unit
) {
    Column {
        Row {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        text = stringResource(R.string.app_name),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { onRefreshClick() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_refresh),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                },
            )
        }
        Spacer(
            modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Black)
        )
    }
}