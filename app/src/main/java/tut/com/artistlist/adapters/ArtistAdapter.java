package tut.com.artistlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tut.com.artistlist.models.Artist;

/**
 * Created by Murager on 07.05.2016.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private List<Artist> artistList;

    public ArtistAdapter(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        return null;
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {

        public ArtistViewHolder(View itemView) {
            super(itemView);
        }
    }
}
