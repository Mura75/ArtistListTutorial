package tut.com.artistlist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import tut.com.artistlist.R;
import tut.com.artistlist.models.Artist;

public class ArtistActivity extends AppCompatActivity {

    private ImageView ivCoverBig;

    private TextView tvName, tvGenres, tvTracks, tvAlbums, tvLink, tvDescription;

    private Artist artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        bindViews();
        setData(getArtist());
    }

    private void bindViews() {
        ivCoverBig = (ImageView)findViewById(R.id.ivCoverBig);
        tvName = (TextView)findViewById(R.id.tvName);
        tvGenres = (TextView)findViewById(R.id.tvGenres);
        tvTracks = (TextView)findViewById(R.id.tvTracks);
        tvAlbums = (TextView)findViewById(R.id.tvAlbums);
        tvLink = (TextView)findViewById(R.id.tvLink);
        tvDescription = (TextView)findViewById(R.id.tvDescription);
    }

    private Artist getArtist() {
        String data = getIntent().getStringExtra("data");
        artist = new Gson().fromJson(data, Artist.class);
        return artist;
    }

    private void setData(Artist artist) {
        Picasso.with(this).load(artist.getCover().getBig()).into(ivCoverBig);

        tvName.setText(artist.getName());
        tvGenres.setText("Genres: " + artist.getArtistGenres());
        tvAlbums.setText("Albums: " + artist.getAlbums());
        tvTracks.setText("Tracks: " + artist.getTracks());
        tvLink.setText("Link: " + artist.getLink());
        tvDescription.setText(artist.getDescription());
    }
}
