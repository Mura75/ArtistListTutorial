package tut.com.artistlist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tut.com.artistlist.R;
import tut.com.artistlist.adapters.ArtistAdapter;
import tut.com.artistlist.models.Artist;
import tut.com.artistlist.utils.RestClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ArtistAdapter artistAdapter;

    private List<Artist> artistList;

    private RestClient restClient;

    private ProgressBar pbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistList = new ArrayList<>();
        bindViews();
        setAdapter();
        getArtists();
    }

    private void bindViews() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        pbMain = (ProgressBar)findViewById(R.id.pbMain);
    }

    private void setAdapter() {
        artistAdapter = new ArtistAdapter(artistList);
        recyclerView.setAdapter(artistAdapter);
    }

    private void getArtists() {
        restClient = new RestClient();

        Call<List<Artist>> call = restClient.getApi().getAllArtists();

        call.enqueue(new Callback<List<Artist>>() {
            @Override
            public void onResponse(Call<List<Artist>> call, Response<List<Artist>> response) {
                pbMain.setVisibility(View.GONE);
                Log.d("Artist_result", response.isSuccessful() + " " + response.message());
                if (response.isSuccessful()) {
                    artistList.addAll(response.body());
                    artistAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Artist>> call, Throwable t) {

            }
        });
    }
}
