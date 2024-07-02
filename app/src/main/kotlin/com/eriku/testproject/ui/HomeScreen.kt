package com.eriku.testproject.ui

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.core.ExperimentalAssetLoader
import com.eriku.testproject.R

@OptIn(ExperimentalAssetLoader::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RiveAnimationView(context).apply {
                setRiveResource(
                    resId = R.raw.test,
                )
            }
        },
    )
    if (viewModel.uiState.entries.isNotEmpty()) {
        Text(text = viewModel.uiState.entries[0].name, modifier = modifier)
    } else {
        Text(text = "No entries", modifier = modifier)
    }
}
