package com.example.tecadisco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class VinileAdapter extends ArrayAdapter<Vinile> {

    public VinileAdapter(Context context, List<Vinile> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_vinile, parent, false);
        }

        Vinile v = getItem(position);

        TextView tvTitolo = convertView.findViewById(R.id.tvTitolo);
        TextView tvArtista = convertView.findViewById(R.id.tvArtista);
        TextView tvValore = convertView.findViewById(R.id.tvValore);

        tvTitolo.setText(v.getTitolo());
        tvArtista.setText(v.getArtista() + " · " + v.getAnno());
        tvValore.setText("€ " + v.getValore());

        return convertView;
    }
}