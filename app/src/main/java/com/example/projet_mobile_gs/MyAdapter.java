package com.example.projet_mobile_gs;

import android.content.Context;
import android.content.Intent;
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

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    RealmResults<Entrepot> entrepotList;

    public MyAdapter(Context context, RealmResults<Entrepot> entrepotList) {
        this.context = context;
        this.entrepotList = entrepotList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.object_entrepot,parent, false ));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Entrepot entrepot = entrepotList.get(position);
        holder.nomEntrepotOut.setText(entrepot.getNomEntrepot());

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
                           entrepot.deleteFromRealm();
                           realm.commitTransaction();
                       }
                       if(item.getTitle().equals("Edit")){
                           Intent intent = new Intent(context.getApplicationContext(), EditEntrepotNameActivity.class);
                           intent.putExtra("entrepotName", entrepot.getNomEntrepot());
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
        return entrepotList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomEntrepotOut;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomEntrepotOut = itemView.findViewById(R.id.object_title);
        }


    }
}
