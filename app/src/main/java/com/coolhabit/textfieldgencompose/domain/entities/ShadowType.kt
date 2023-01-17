package com.coolhabit.textfieldgencompose.domain.entities

data class ShadowType(
    val shadowColor: ColorRGB,
    var shadowOffset: Int,
    var shadowOpacity: Double,
    var shadowRadius: Int,
    val shadowSizeType: SizeType,
)
