package com.example.libapp;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Bookdata> bookdata;
    public BookAdapter(Context context, ArrayList<Bookdata> bookdata){
        this.context = context;
        this.bookdata =bookdata;
    }
    @NonNull
    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist,parent,false);
        MyViewHolder viewHolderClass = new MyViewHolder (view);
        return viewHolderClass ;
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.MyViewHolder holder, int position) {
        MyViewHolder viewHolderClass = (MyViewHolder)holder;
        Bookdata bookdata = this.bookdata.get(position);
        holder.tvjudul.setText(bookdata.getJudulbuku());
        holder.tvhalaman.setText(bookdata.getHalamanbuku());
        holder.tvpenulis.setText(bookdata.getPenulisbuku());
        holder.tvpublisher.setText(bookdata.getPublisherbukku());
    }

    @Override
    public int getItemCount() {
        return bookdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvjudul,tvhalaman,tvpenulis,tvpublisher;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvjudul = itemView.findViewById(R.id.tvjudul);

            tvhalaman = itemView.findViewById(R.id.tvhalaman);

            tvpenulis = itemView.findViewById(R.id.tvpenulis);

            tvpublisher = itemView.findViewById(R.id.tvpublisher);
        }
    }
}
