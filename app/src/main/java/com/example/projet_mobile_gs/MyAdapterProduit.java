package com.example.projet_mobile_gs;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
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
            Produit produit = produitList.get(position);
            holder.nomProduitOut.setText(produit.getNomProduit());
            holder.quantiteProduitOut.setText(produit.getQuantite());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu menu =  new PopupMenu(context,v);
                menu.getMenu().add("Delete");
                menu.getMenu().add("Edit");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("Delete")){
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            produit.deleteFromRealm();
                            realm.commitTransaction();
                        }
                        if(item.getTitle().equals("Edit")){
                            Intent intent = new Intent(context.getApplicationContext(), EditEntrepotNameActivity.class);
                            intent.putExtra("nomProduit",produit.getNomProduit());
                            intent.putExtra("quantite",produit.getQuantite());
                            intent.putExtra("entrepotID", produit.getIdEntrepot());
                            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                            context.getApplicationContext().startActivity(intent);
                        }
                        return true;
                    }
                });
                menu.show();
                return true;
            }
        });
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
