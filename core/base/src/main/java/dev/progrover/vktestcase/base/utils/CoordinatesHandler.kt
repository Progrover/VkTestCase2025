package dev.platovco.core.base.utils

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Метод вычисляет расстояние между двумя точками на карте.
 * Для каждой точки сначала указывается latitude, затем longitude.
 **/

fun calculateDistance(point1: Pair<Double, Double>, point2: Pair<Double, Double>): Double {
    val earthRadius = 6371.0
    val lat1Rad = Math.toRadians(point1.first)
    val lon1Rad = Math.toRadians(point1.second)
    val lat2Rad = Math.toRadians(point2.first)
    val lon2Rad = Math.toRadians(point2.second)

    val dlat = lat2Rad - lat1Rad
    val dlon = lon2Rad - lon1Rad

    val a = sin(dlat / 2).pow(2) + cos(lat1Rad) * cos(lat2Rad) * sin(dlon / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return earthRadius * c
}

fun convertDistanceToString(distanceInKilometers: Double): String =
    if (distanceInKilometers < 10) {
        String.format("%.1f км", distanceInKilometers)
    } else String.format("%.0f км", distanceInKilometers)

