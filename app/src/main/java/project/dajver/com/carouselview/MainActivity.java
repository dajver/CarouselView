package project.dajver.com.carouselview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.gtomato.android.ui.widget.CarouselView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.carouselview.adapter.CarouselRecyclerAdapter;
import project.dajver.com.carouselview.view.FlatMarryGoRoundSyndTransformer;

public class MainActivity extends AppCompatActivity implements CarouselView.OnItemClickListener {

    @BindView(R.id.carousel)
    CarouselView carouselView;

    private List<String> carouselList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        carouselList = new ArrayList<>();
        carouselList.add("https://s-media-cache-ak0.pinimg.com/originals/f2/d2/eb/f2d2eb69fb80e312d310c32786bf8182.png");
        carouselList.add("https://vignette.wikia.nocookie.net/marveldatabase/images/1/1a/The_Avengers_%28film%29_poster_011.jpg");
        carouselList.add("https://i.pinimg.com/originals/13/35/b1/1335b128be40578eec379be437f02de7.jpg");
        carouselList.add("https://i.pinimg.com/originals/6d/2b/b3/6d2bb3023ada5ea320f54bb4fc3fe50a.jpg");
        carouselList.add("http://moviemarker.co.uk/wp-content/uploads/2012/03/Thor-Film-Poster.jpg");
        carouselList.add("http://www.cbc.ca/strombo/content/images/a-cool-look-at-rejected-posters-for-classic-films-feature2.jpg");
        carouselList.add("http://mediablogs.keshacademy.com/cmacleannanwatkinsas/files/2016/09/free-movie-film-poster-harry-potter-phoenix-2iwng7l.jpg");

        CarouselRecyclerAdapter carouselRecyclerAdapter = new CarouselRecyclerAdapter(this, carouselList);
        carouselView.setTransformer(new FlatMarryGoRoundSyndTransformer());
        carouselView.setAdapter(carouselRecyclerAdapter);
        carouselView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(RecyclerView.Adapter adapter, View view, int position, int adapterPosition) {
        Toast.makeText(this, carouselList.get(position), Toast.LENGTH_LONG).show();
    }
}
