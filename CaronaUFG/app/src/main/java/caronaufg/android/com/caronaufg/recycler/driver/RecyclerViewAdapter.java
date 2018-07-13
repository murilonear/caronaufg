package caronaufg.android.com.caronaufg.recycler.driver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.model.TravelDriver;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<TravelDriver> travelDriver;
    protected Context context;
    public RecyclerViewAdapter(Context context, List<TravelDriver> travelDriver) {
        this.travelDriver = travelDriver;
        this.context = context;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recicler_to_do_list, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView, travelDriver);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.de.setText("Origem: " + travelDriver.get(position).getBeginDriver());
        holder.para.setText("Destino: " + travelDriver.get(position).getGoalDriver());
        holder.data.setText("Data: " + travelDriver.get(position).getDateDriver());
        holder.hora.setText("Hora: " + travelDriver.get(position).getTime());
    }
    @Override
    public int getItemCount() {
        return this.travelDriver.size();
    }
}