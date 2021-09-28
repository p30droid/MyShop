package com.androidlearn.digishop.utils;

import androidx.room.TypeConverter;

import com.androidlearn.digishop.models.Gallery;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TypeConvertor {

    @TypeConverter
    public static List<Gallery> storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Gallery>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<Gallery> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }

}
