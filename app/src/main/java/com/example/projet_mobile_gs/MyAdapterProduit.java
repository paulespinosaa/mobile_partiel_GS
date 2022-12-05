package com.example.projet_mobile_gs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class MyAdapterProduit extends RecyclerView.Adapter<MyAdapterProduit.MyViewHolder2> {

    Context context;
    RealmResults<Produit> produitList;

    public MyAdapterProduit(Context context, RealmResults<Produit> produitList) {
        this.context = context;
        this.produitList = produitList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.object_entrepot, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return produitList.size();
    }


    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView nomProduitOut;
        TextView quantiteProduitOut;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            nomProduitOut = itemView.findViewById(R.id.object_title);
            quantiteProduitOut =itemView.findViewById(R.id.object_quantity);
        }
    }
}
