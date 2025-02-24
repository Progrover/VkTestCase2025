package dev.progrover.vktestcase.uicommon.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import dev.progrover.vktestcase.core.uicommon.R
import dev.progrover.vktestcase.theme.AppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun LoadingScreenPlaceHolder(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
) {

    var rotationAngle by remember { mutableFloatStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    /**
     * Использование дополнительного корутинскоупа - необходимость. Без него на главном экране
     * прогрессбар может зависнуть
     */
    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
            val step = 360 / 8f
            while (isActive) {
                val newValue = rotationAngle - step
                rotationAngle = if (newValue <= -360) 0f else newValue
                delay(70)
            }
        }
    }

    if (isVisible)
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(AppTheme.colors.white),
            contentAlignment = Alignment.Center,
        ) {

            Image(
                modifier = Modifier
                    .size(AppTheme.sizes.size30)
                    .rotate(rotationAngle),
                painter = painterResource(R.drawable.loading),
                contentDescription = null,
            )
        }
}