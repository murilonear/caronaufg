package caronaufg.android.com.caronaufg.recycler.driver;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.model.TravelDriver;

public class RecyclerViewHolders extends RecyclerView.ViewHolder{
    public TextView de;
    public TextView para;
    public TextView data;
    public TextView hora;
    public TextView valor;
    private List<TravelDriver> travelDriver;
    public RecyclerViewHolders(final View itemView, final List<TravelDriver> travelDriver) {
        super(itemView);
        this.travelDriver = travelDriver;
        de = (TextView)itemView.findViewById(R.id.ride_from);
        para = (TextView)itemView.findViewById(R.id.ride_to);
        data = (TextView)itemView.findViewById(R.id.ride_date);
        hora = (TextView)itemView.findViewById(R.id.ride_time);
    }
}