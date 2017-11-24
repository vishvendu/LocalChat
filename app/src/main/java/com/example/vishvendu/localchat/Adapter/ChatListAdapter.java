package com.example.vishvendu.localchat.Adapter;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishvendu.localchat.R;
import com.example.vishvendu.localchat.database.User;

import java.util.ArrayList;

/**
 * Created by vishvendu on 22/11/17.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {


    ArrayList<String> chatData;
    ArrayList<Integer> randomdata;
    User chatHistory;
    Context mContext;
    public ChatListAdapter(ArrayList<String> chatString, ArrayList<Integer> randomintegers, Application application){

        chatData = new ArrayList<>();
        randomdata = new ArrayList<>();
         chatHistory = new User();
        this.chatData = chatString;
        this.randomdata =  randomintegers;
        this.mContext = application;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatListAdapter.MyViewHolder holder, int position) {


        holder.randomText.setText("I am random " +randomdata.get(position).toString());
        holder.firstText.setText(chatData.get(position));

    }

    @Override
    public int getItemCount() {
        return chatData.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

      private  TextView firstText;
      private  TextView randomText;

        public MyViewHolder(View itemView) {
            super(itemView);

            firstText = (TextView)itemView.findViewById(R.id.firsttext);
            randomText = (TextView)itemView.findViewById(R.id.randomtext);
        }
    }
}
