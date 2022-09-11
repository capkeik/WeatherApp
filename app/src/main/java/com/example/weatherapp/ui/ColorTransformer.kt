package com.example.weatherapp.ui

import androidx.compose.ui.graphics.Color
import com.example.weatherapp.ui.theme.*

object ColorTransformer {
    fun getColor(temp: Int): Color {
        return when (temp) {
            in -300..-20 -> Blue400
            in -20..-10 -> Blue200
            in -10..15 -> Teal200
            in 15..30 -> Red500
            in 30..300 -> Red500Dark
            else -> Purple700
        }
    }
}