package submission1.movieslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String movie = "movie";

    TextView tv_name, tv_description, tv_releasedate, tv_runtime;
    ImageView iv_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv_name = findViewById(R.id.tv_name);
        tv_description = findViewById(R.id.tv_description);
        tv_releasedate = findViewById(R.id.tv_releasedate);
        tv_runtime = findViewById(R.id.tv_runtime);
        iv_picture = findViewById(R.id.iv_picture);

        MovieModel movieModel = getIntent().getParcelableExtra(movie);

        Glide.with(getApplicationContext())
                .load(movieModel.getPicture())
                .into(iv_picture);

        tv_name.setText(movieModel.getName());
        tv_description.setText(movieModel.getDescription());
        tv_releasedate.setText(movieModel.getReleasedate());
        tv_runtime.setText(movieModel.getRuntime());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
