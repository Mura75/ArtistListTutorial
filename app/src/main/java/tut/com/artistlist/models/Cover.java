package tut.com.artistlist.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Murager on 07.05.2016.
 */
public class Cover {

    @SerializedName("small")
    private String small;

    @SerializedName("big")
    private String big;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    @Override
    public String toString() {
        return "Cover{" +
                "small='" + small + '\'' +
                ", big='" + big + '\'' +
                '}';
    }
}
