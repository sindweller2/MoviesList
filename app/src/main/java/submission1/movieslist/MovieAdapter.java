package submission1.movieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<MovieModel> movieModels;

    MovieAdapter(Context context) {
        this.context = context;
        movieModels = new ArrayList<>();
    }

    void setMovieModels(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }

    @Override
    public int getCount() {
        return movieModels.size();
    }

    @Override
    public Object getItem(int i) {
        return movieModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieModel movieModel = (MovieModel) getItem(i);
        viewHolder.bind(movieModel);
        return view;
    }

    private class ViewHolder {
        TextView tvName;
        TextView tvDescription;
        ImageView ivPicture;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvDescription = view.findViewById(R.id.tv_description);
            ivPicture = view.findViewById(R.id.iv_picture);
        }

        void bind(MovieModel movieModel) {
            tvName.setText(movieModel.getName());
            tvDescription.setText(movieModel.getDescription());
            Glide.with(context)
                    .load(movieModel.getPicture())
                    .into(ivPicture);
        }
    }
}
