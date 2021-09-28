package com.androidlearn.digishop.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.androidlearn.digishop.utils.TypeConvertor
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_product")
class Product(
    @PrimaryKey (autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "brand")
    val brand: String,
    @ColumnInfo(name = "catId")
    val catId: String,
    @ColumnInfo(name = "catName")
    val catName: String,
    @ColumnInfo(name = "count")
    val count: String,
    @ColumnInfo(name = "discount")
    val discount: String,
    @ColumnInfo(name = "fullDescription")
    val fullDescription: String,
   // @ColumnInfo(name = "gallery")
    @SerializedName("gallery")
    @TypeConverters(TypeConvertor::class)
    val gallery: List<Gallery>,
    @ColumnInfo(name = "garanti")
    @SerializedName("garanti")
    val garanti: String,
    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    val icon: String,
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "price")
    @SerializedName("price")
    val price: String,
    @ColumnInfo(name = "rate")
    @SerializedName("rate")
    val rate: String,
    @ColumnInfo(name = "shortDescription")
    @SerializedName("shortDescription")
    val shortDescription: String,
    @ColumnInfo(name = "special")
    @SerializedName("special")
    val special: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
) : Parcelable {


    }


