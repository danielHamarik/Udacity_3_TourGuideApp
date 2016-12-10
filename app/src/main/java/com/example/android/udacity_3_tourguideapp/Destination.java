package com.example.android.udacity_3_tourguideapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Destination implements Parcelable {

    private int title;
    private int location;
    private int address;
    private int open;
    private int web;
    private int description;
    private int history;
    private int imageSrc;
    private int lat, lon;

    public Destination(int title, int location, int address, int open, int web, int description, int history, int imageSrc, int lat, int lon) {
        this.title = title;
        this.location = location;
        this.address = address;
        this.open = open;
        this.web = web;
        this.description = description;
        this.history = history;
        this.imageSrc = imageSrc;
        this.lat = lat;
        this.lon = lon;
    }

    public Destination(Parcel p) {
        title = p.readInt();
        location = p.readInt();
        address = p.readInt();
        open = p.readInt();
        web = p.readInt();
        description = p.readInt();
        history = p.readInt();
        imageSrc = p.readInt();
        lat = p.readInt();
        lon = p.readInt();
    }

    public static Creator<Destination> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(location);
        dest.writeInt(address);
        dest.writeInt(open);
        dest.writeInt(web);
        dest.writeInt(description);
        dest.writeInt(history);
        dest.writeInt(imageSrc);
        dest.writeInt(lat);
        dest.writeInt(lon);
    }

    public static final Parcelable.Creator<Destination> CREATOR
            = new Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel source) {
            return new Destination(source);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public int getLocation() {
        return location;
    }

    public int getAddress() {
        return address;
    }

    public int getOpen() {
        return open;
    }

    public int getWeb() {
        return web;
    }

    public int getDescription() {
        return description;
    }

    public int getHistory() {
        return history;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public int getLat(){return lat;}

    public int getLon(){return lon;}


}
