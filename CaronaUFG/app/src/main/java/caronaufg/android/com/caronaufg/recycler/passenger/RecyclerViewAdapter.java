package caronaufg.android.com.caronaufg.recycler.passenger;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.model.TravelPassenger;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<TravelPassenger> travelPassenger;
    protected Context context;
    public RecyclerViewAdapter(Context context, List<TravelPassenger> travelPassenger) {
        this.travelPassenger = travelPassenger;
        this.context = context;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recicler_to_do_list, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView, travelPassenger);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.de.setText("Origem: " + travelPassenger.get(position).getBeginPassenger());
        holder.para.setText("Destino: " + travelPassenger.get(position).getGoalPassenger());
        holder.data.setText("Data: " + travelPassenger.get(position).getDatePassenger());
        holder.hora.setText("Hora: " + travelPassenger.get(position).getTimePassenger());
    }
    @Override
    public int getItemCount() {
        return this.travelPassenger.size();
    }
}