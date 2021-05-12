package com.hnucm.c201901020241;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class MessageFragment extends Fragment {

    RecyclerView recyclerView;
    Chat chat;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            recyclerView = getActivity().findViewById(R.id.recyclerView3);
            myAdapter = new MyAdapter();


            x.Ext.init(getActivity().getApplication());
            RequestParams requestParams = new RequestParams("https://www.fastmock.site/mock/655cf65cee3e3cad8708f0466f5f6907/homework10/infor3");

            x.http().get(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.i("MainActivity","result"+result);
                    Gson gson=new Gson();
                    chat=gson.fromJson(result,Chat.class);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Log.i("MainActivity","ex"+ex.getMessage());
                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });

        }

        public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_chat, parent, false);
                MyViewHolder myViewHolder = new MyViewHolder(view);
                return myViewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                holder.nameTv.setText(chat.chatlist.get(position).name);
                holder.contentTv.setText(chat.chatlist.get(position).content);
                holder.timeTv.setText(chat.chatlist.get(position).time);
                Glide.with(getActivity()).load(chat.chatlist.get(position).head).into(holder.imageView);
            }

            @Override
            public int getItemCount() {
                return chat.chatlist.size();
            }
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView nameTv;
            TextView contentTv;
            TextView timeTv;
            ImageView imageView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTv = itemView.findViewById(R.id.nametextview);
                contentTv = itemView.findViewById(R.id.contenttextview);
                timeTv = itemView.findViewById(R.id.timetextview);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
}