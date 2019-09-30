package submission1.movieslist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private String[] dataReleasedate;
    private String[] dataRuntime;
    private TypedArray dataPicture;
    private MovieAdapter movieAdapter;
    private ArrayList<MovieModel> movieModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.movie, movieModels.get(i));
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataReleasedate = getResources().getStringArray(R.array.data_releasedate);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataPicture = getResources().obtainTypedArray(R.array.data_picture);
    }

    private void addItem() {
        movieModels = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            MovieModel movieModel = new MovieModel();

            movieModel.setName(dataName[i]);
            movieModel.setDescription(dataDescription[i]);
            movieModel.setReleasedate(dataReleasedate[i]);
            movieModel.setRuntime(dataRuntime[i]);
            movieModel.setPicture(dataPicture.getResourceId(i, -1));

            movieModels.add(movieModel);
        }

        movieAdapter.setMovieModels(movieModels);
    }
}
