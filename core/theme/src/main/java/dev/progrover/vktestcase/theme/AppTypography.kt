package dev.progrover.vktestcase.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * @property h1 55sp, Bold
 * @property h2 24sp, Bold
 * @property h3 18sp, Bold
 * @property h4 16sp, Bold
 * @property body1 16sp, Normal
 * @property body2 14sp, Bold
 * @property body3 12sp, SemiBold
 * @property body4 14sp, Normal
 * @property footnote 12sp, Bold
 * @property caption 11sp, Bold
 * @property title 18sp, Bold
 * @property number 10sp, Bold
 */
@Immutable
data class AppTypography(
    val materialTypography: Typography,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val footnote: TextStyle,
    val footnote1: TextStyle,
    val number: TextStyle,
    val caption: TextStyle,
    val caption1: TextStyle,
    val title: TextStyle,
    val h_32: TextStyle,
    val h_28: TextStyle,
    val h_22: TextStyle,
    val text_20: TextStyle,
    val text_18_semibold: TextStyle,
    val text_18_medium: TextStyle,
    val text_16_semibold: TextStyle,
    val text_16_medium: TextStyle,
    val text_14_semibold: TextStyle,
    val text_14_medium: TextStyle,
    val text_14_regular: TextStyle,
    val text_12_regular: TextStyle,
    val text_12_medium: TextStyle,
    val caption_10_semibold: TextStyle,
    val caption_10_medium: TextStyle,
)



internal fun appTypography(style: TextStyles): AppTypography =
    with(style) {
        AppTypography(
            materialTypography = Typography(),
            h1 = h1,
            h2 = h2,
            h3 = h3,
            h4 = h4,
            body1 = body1,
            body2 = body2,
            body3 = body3,
            body4 = body4,
            footnote = footnote,
            footnote1 = footnote1,
            number = number,
            caption = caption,
            caption1 = caption1,
            title = title,
            h_32 = h_32,
            h_28 = h_28,
            h_22 = h_22,
            text_20 = text_20,
            text_18_semibold = text_18_semibold,
            text_16_semibold = text_16_semibold,
            text_14_semibold = text_14_semibold,
            text_18_medium = text_18_medium,
            text_16_medium = text_16_medium,
            text_14_medium = text_14_medium,
            text_12_medium = text_12_medium,
            text_14_regular = text_14_regular,
            text_12_regular = text_12_regular,
            caption_10_semibold = caption_10_semibold,
            caption_10_medium = caption_10_medium
        )
    }




class TextStyles {

    val h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 55.sp,
        letterSpacing = 0.em,
    )

    val h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.em,
    )

    val h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.em,
    )

    val h4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.em,
    )

    val body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.em,
    )

    val body2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.em,
    )

    val body3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.em,
    )

    val body4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.em,
    )

    val footnote = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.em,
    )

    val footnote1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        letterSpacing = 0.em,
    )

    val number = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        letterSpacing = 0.em,
    )

    val caption = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        letterSpacing = 0.em,
    )

    val caption1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        letterSpacing = 0.em,
    )

    val title = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = (-0.03).em,
    )

    val h_32 = TextStyle(
        fontFamily = AppFonts.Fonts.playfair,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 34.sp,
    )

    val h_28 = TextStyle(
        fontFamily = AppFonts.Fonts.playfair,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 30.sp,
    )

    val h_22 = TextStyle(
        fontFamily = AppFonts.Fonts.playfair,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 24.sp,
    )

    val text_20 = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    )

    val text_18_semibold = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
    )

    val text_18_medium = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 22.sp,
    )

    val text_16_semibold = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    )

    val text_16_medium = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    )

    val text_14_semibold = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    )

    val text_14_medium = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    )

    val text_14_regular = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    )

    val text_12_medium = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 20.sp,
    )

    val text_12_regular = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
    )

    val caption_10_semibold = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = 16.sp,
    )

    val caption_10_medium = TextStyle(
        fontFamily = AppFonts.Fonts.roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 16.sp,
    )
}


internal val LocalAppTypography = staticCompositionLocalOf {
    appTypography(TextStyles())
}