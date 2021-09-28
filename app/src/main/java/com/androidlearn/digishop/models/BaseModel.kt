package com.androidlearn.digishop.models

data class BaseModel(
    val AmazingOffer: List<Product>,
    val `data`: Data,
    val discount: List<Product>,
    val makeup: List<Product>,
    val mobile: List<Product>,
    val news: List<New>,
    val categories : List<Category>
)