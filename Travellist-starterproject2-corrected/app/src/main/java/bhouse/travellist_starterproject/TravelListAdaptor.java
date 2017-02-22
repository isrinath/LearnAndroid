package bhouse.travellist_starterproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static bhouse.travellist_starterproject.R.id.placeName;
import static bhouse.travellist_starterproject.R.id.placeNameHolder;

/**
 * Created by dbs on 22/2/17.
 */

public class TravelListAdaptor extends RecyclerView.Adapter {

    private Context context;
    private View view;
    private ArrayList<Place> placeDataArrayList;
    private ItemClickListenerRecycler itemClickListenerRecycler;

    public class  MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private LinearLayout mainHolder;
        private  LinearLayout placeNameHolder;
        private ImageView placeImage;
        private TextView placeName;


        public MyViewHolder(View itemView) {
            super(itemView);
            mainHolder  = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeNameHolder  = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("SRINATH","onClickRecycle");
            Log.d("SRINATH",itemClickListenerRecycler.toString());
            if(itemClickListenerRecycler!=null){
                Log.d("SRINATH",itemClickListenerRecycler.toString()+" is not null");
                itemClickListenerRecycler.onClickRecycle(view,getPosition());
            }
        }
    }

    public void setItemClickListenerRecycler(ItemClickListenerRecycler itemClickListenerRecycler){
        this.itemClickListenerRecycler = itemClickListenerRecycler;
    }

    public TravelListAdaptor(Context context, ArrayList<Place> placeDataArrayList) {
        this.context = context;
        this.placeDataArrayList = placeDataArrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_places, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Place place = placeDataArrayList.get(position);
        myViewHolder.placeName.setText(place.name);
        Picasso.with(context).load(place.getImageResourceId(context)).into(myViewHolder.placeImage);
    }

    @Override
    public int getItemCount() {
        return placeDataArrayList.size();
    }



}
