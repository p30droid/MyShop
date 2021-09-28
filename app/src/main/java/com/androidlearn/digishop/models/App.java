package com.androidlearn.digishop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class App implements Parcelable {

    int id;
    String title;
    String description;

    protected App(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<App> CREATOR = new Creator<App>() {
        @Override
        public App createFromParcel(Parcel in) {
            return new App(in);
        }

        @Override
        public App[] newArray(int size) {
            return new App[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
    }
}
