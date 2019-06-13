package com.software.tempe.retrofitwithrecycler.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.software.tempe.retrofitwithrecycler.ItemDetailActivity;
import com.software.tempe.retrofitwithrecycler.R;
import com.software.tempe.retrofitwithrecycler.model.Post;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AppAdapter> {

    private List<Post> postList = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public AppAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_itemlist, viewGroup, false);
        return new AppAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppAdapter appAdapter, final int i) {
        final Post post = postList.get(i);

        appAdapter.postIdTxtView.setText(String.valueOf(post.getId()));
        appAdapter.titleTxtView.setText(post.getTitle());
        appAdapter.bodyTxtView.setText(post.getBody());

        appAdapter.item_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra("title_data", post.getTitle());
                intent.putExtra("body_data", post.getBody());
                // Toast.makeText(context, "Title: " + post.getId(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class AppAdapter extends RecyclerView.ViewHolder {
        CircleImageView profileImgView;
        TextView titleTxtView;
        TextView bodyTxtView;
        TextView postIdTxtView;
        RelativeLayout item_list;

        public AppAdapter(@NonNull View itemView) {
            super(itemView);

            profileImgView = itemView.findViewById(R.id.profileImgView);
            postIdTxtView = itemView.findViewById(R.id.postIdTxtView);
            titleTxtView = itemView.findViewById(R.id.titleTxtView);
            bodyTxtView = itemView.findViewById(R.id.bodyTxtView);
            item_list = itemView.findViewById(R.id.item_list);

        }
    }
}
