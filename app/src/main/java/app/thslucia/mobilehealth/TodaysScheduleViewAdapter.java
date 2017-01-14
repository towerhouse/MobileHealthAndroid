package app.thslucia.mobilehealth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import app.thslucia.mobilehealth.model.Schedule;

public class TodaysScheduleViewAdapter extends RecyclerView.Adapter<TodaysScheduleViewAdapter.CustomViewHolder> {

    List<Schedule> list = Collections.emptyList();
    Context context;

    public TodaysScheduleViewAdapter(List<Schedule> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TodaysScheduleViewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todays_schedule_row, parent, false);
        TodaysScheduleViewAdapter.CustomViewHolder holder = new TodaysScheduleViewAdapter.CustomViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(TodaysScheduleViewAdapter.CustomViewHolder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).getTitle());
        //holder.description.setText(list.get(position).getDescription());
        holder.imageView.setImageResource(list.get(position).imageId);

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Schedule data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Schedule data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView description;
        protected ImageView imageView;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.todays_schedule_thumbnail);
            this.title = (TextView) view.findViewById(R.id.todays_schedule_title);
        }
    }

}
