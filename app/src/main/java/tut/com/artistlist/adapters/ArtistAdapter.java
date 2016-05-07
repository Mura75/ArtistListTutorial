package tut.com.artistlist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import tut.com.artistlist.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_item_row, parent, false);
        ArtistViewHolder holder = new ArtistViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ArtistViewHolder holder, int position) {
        Artist artist = artistList.get(position);
        holder.tvArtistName.setText(artist.getName());
        holder.tvArtistGenres.setText(artist.getGenres() + "");

        Picasso.with(holder.context)
                .load(artist.getCover().getSmall())
                .into(holder.ivCoverSmall, new Callback() {
                        @Override
                        public void onSuccess() {
                            holder.pbCoverSmall.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            holder.pbCoverSmall.setVisibility(View.GONE);
                            holder.ivCoverSmall.setImageResource(android.R.drawable.ic_delete);
                        }
        });
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private ImageView ivCoverSmall;
        private TextView tvArtistName, tvArtistGenres;
        private ProgressBar pbCoverSmall;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ivCoverSmall = (ImageView)itemView.findViewById(R.id.ivCoverSmall);
            tvArtistName = (TextView)itemView.findViewById(R.id.tvArtistName);
            tvArtistGenres = (TextView)itemView.findViewById(R.id.tvArtistGenres);
            pbCoverSmall = (ProgressBar)itemView.findViewById(R.id.pbCoverSmall);
        }
    }
}
