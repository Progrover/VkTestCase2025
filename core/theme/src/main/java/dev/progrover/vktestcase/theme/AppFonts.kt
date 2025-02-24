package dev.progrover.vktestcase.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import dev.progrover.vktestcase.core.theme.R

data class AppFonts(
    val playfair: FontFamily,
    val roboto: FontFamily,
) {
    companion object {
        val Fonts = AppFonts(
            playfair = FontFamily(
                fonts = listOf(
                    Font(R.font.playfair_normal),
                    Font(R.font.playfair_italic),
                )
            ),
            roboto = FontFamily(
                fonts = listOf(
                    Font(R.font.roboto_medium),
                    Font(R.font.roboto_regular),
                    Font(R.font.roboto_semibold),
                )
            ),
        )
    }
}

internal val LocalAppFonts = staticCompositionLocalOf {
    AppFonts.Fonts
}