package com.rappi.movies.presentation.util

import androidx.annotation.DimenRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable

fun BottomNavigationView.backgroundRoundedCorners(@DimenRes dimen: Int) {
    val radius = resources.getDimension(dimen)
    val shapeDrawable : MaterialShapeDrawable = this.background as MaterialShapeDrawable
    shapeDrawable.shapeAppearanceModel = shapeDrawable.shapeAppearanceModel
        .toBuilder()
        .setAllCorners(CornerFamily.ROUNDED, radius)
        .build()
}