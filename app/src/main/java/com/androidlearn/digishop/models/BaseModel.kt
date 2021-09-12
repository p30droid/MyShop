package com.androidlearn.digishop.models

data class BaseModel(
    val AmazingOffer: List<AmazingOffer>,
    val `data`: Data,
    val discount: List<Discount>,
    val makeup: List<Makeup>,
    val mobile: List<Mobile>,
    val news: List<New>,
    val categories : List<Category>
)