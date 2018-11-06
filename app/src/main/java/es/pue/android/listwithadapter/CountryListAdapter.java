package es.pue.android.listwithadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CountryListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> countries;

    static class ViewHolder {
        TextView tvCountryName;
    }

    public CountryListAdapter(@NonNull Context context, int resource, @NonNull List<String> countries) {
        super(context, resource, countries);
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvCountryName = rowView.findViewById(R.id.tvCountry);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder)rowView.getTag();
        holder.tvCountryName.setText(this.countries.get(position));

        return rowView;
    }
}
