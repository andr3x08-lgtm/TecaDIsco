package com.example.tecadisco;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mNumeroTextView;
    TextView mTotaleTextView;
    EditText mRicercaEditText;
    GridView mGriglia;

    ArrayList<Vinile> mTutti = new ArrayList<>();
    VinileAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mNumeroTextView = findViewById(R.id.tvNumero);
        mTotaleTextView = findViewById(R.id.tvTotale);
        mRicercaEditText = findViewById(R.id.etRicerca);
        mGriglia = findViewById(R.id.griglia);

        // dati finti per ora
        mTutti.add(new Vinile("La Bella Vita", "Artie 5ive", 2025, 100));
        mTutti.add(new Vinile("Going Hard 3", "Tony Boy", 2024, 60));
        mTutti.add(new Vinile("Glocky VS Kyddo", "Glocky", 2024, 80));
        mTutti.add(new Vinile("Trauma", "Tony Boy", 2026, 300));

        mAdapter = new VinileAdapter(this, new ArrayList<>(mTutti));
        mGriglia.setAdapter(mAdapter);

        aggiornaRiepilogo();

        mRicercaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtra(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void aggiornaRiepilogo() {
        int totale = 0;
        for (Vinile v : mTutti) {
            totale += v.getValore();
        }
        mNumeroTextView.setText(String.valueOf(mTutti.size()));
        mTotaleTextView.setText("€ " + totale);
    }

    private void filtra(String testo) {
        testo = testo.toLowerCase();
        mAdapter.clear();
        for (Vinile v : mTutti) {
            if (v.getTitolo().toLowerCase().contains(testo)
                    || v.getArtista().toLowerCase().contains(testo)) {
                mAdapter.add(v);
            }
        }
    }
}