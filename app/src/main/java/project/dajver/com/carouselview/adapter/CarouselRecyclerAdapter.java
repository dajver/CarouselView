package project.dajver.com.carouselview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.carouselview.R;

/**
 * Created by gleb on 3/20/18.
 */

public class CarouselRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> carouselList = new ArrayList<>();
    private Context context;

    public CarouselRecyclerAdapter(Context context, List<String> carouselList) {
        this.context = context;
        this.carouselList = carouselList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.item_carousel, null);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(context).load(carouselList.get(position)).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return carouselList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.promImage)
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}