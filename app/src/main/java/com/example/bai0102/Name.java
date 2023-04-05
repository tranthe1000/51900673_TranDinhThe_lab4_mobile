package com.example.bai0102;


import android.os.Parcel;
import android.os.Parcelable;

public class Name implements Parcelable {
    private String name;

    public Name() {
        this.name = "";
    }

    public Name(String name) {
        this.name = name;
    }

    protected Name(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
    }
}

