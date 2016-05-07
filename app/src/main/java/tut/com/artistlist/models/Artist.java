package tut.com.artistlist.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Murager on 07.05.2016.
 */
public class Artist {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("tracks")
    private int tracks;

    @SerializedName("albums")
    private int albums;

    @SerializedName("link")
    private String link;

    @SerializedName("description")
    private String description;

    @SerializedName("genres")
    private String[] genres;

    @SerializedName("cover")
    private Cover cover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getAlbums() {
        return albums;
    }

    public void setAlbums(int albums) {
        this.albums = albums;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tracks=" + tracks +
                ", albums=" + albums +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", cover=" + cover +
                '}';
    }
}
