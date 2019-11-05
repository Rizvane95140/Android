package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Entities.Logement;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //Ici au lieu d'appeler de fausses données on appellera un vrai service web
        ArrayList<Logement> logementList = GetLogement();

        RecyclerView recyclerView = findViewById(R.id.rvwLogements);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(logementList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);


    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

        private ArrayList<Logement> _logementList;

        public RecyclerViewAdapter(ArrayList<Logement> logementList) {
            this._logementList = logementList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_logement, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Logement logement = this._logementList.get(position);
            holder.txtTitre.setText(logement.getTitre());
        }

        @Override
        public int getItemCount() {
            return this._logementList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txtTitre;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                txtTitre = itemView.findViewById(R.id.txtTitre);
            }
        }
    }

    private ArrayList<Logement> GetLogement()
    {

        ArrayList<Logement> logementList = new ArrayList<>();

        Logement logement = new Logement();
        logement.setTitre("Lyon");

        logementList.add(logement);

        return logementList;
    }
}
