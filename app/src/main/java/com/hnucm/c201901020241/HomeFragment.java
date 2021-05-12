package com.hnucm.c201901020241;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView,recyclerView1;
    MyAdapter1 myAdapter1;
    MyAdapter myAdapter;
    Title title;
    Shop shop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        recyclerView1 = getActivity().findViewById(R.id.recyclerView2);
        myAdapter1 = new MyAdapter1();
        myAdapter= new MyAdapter();
        x.Ext.init(getActivity().getApplication());
        RequestParams requestParams = new RequestParams("https://www.fastmock.site/mock/655cf65cee3e3cad8708f0466f5f6907/homework10/infor1");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("MainActivity","result"+result);
                Gson gson=new Gson();
                title=gson.fromJson(result,Title.class);
                recyclerView.setAdapter(myAdapter1);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),5){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                recyclerView.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


        x.Ext.init(getActivity().getApplication());
        RequestParams requestParams1 = new RequestParams("https://www.fastmock.site/mock/655cf65cee3e3cad8708f0466f5f6907/homework10/infor2");
        x.http().get(requestParams1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("MainActivity","result"+result);
                Gson gson=new Gson();
                shop=gson.fromJson(result,Shop.class);
                recyclerView1.setAdapter(myAdapter);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                recyclerView1.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    public class MyAdapter1 extends RecyclerView.Adapter<MyViewHolder1> {

        @NonNull
        @Override
        public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_list1, parent, false);
            MyViewHolder1 myViewHolder1 = new MyViewHolder1(view);
            return myViewHolder1;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
            holder.contentTv.setText(title.all.get(position).title);
            Glide.with(getActivity()).load(title.all.get(position).iamge).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return title.all.size();
        }
    }


    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView contentTv;
        ImageView imageView;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            contentTv = itemView.findViewById(R.id.textView5);
            imageView = itemView.findViewById(R.id.imageView6);
        }
    }



    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_list2, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.contentTv.setText(shop.all.get(position).title);
            holder.moneyTv.setText(shop.all.get(position).money);
            holder.peopleTv.setText(shop.all.get(position).number);
            holder.otherTv.setText(shop.all.get(position).other);
            Glide.with(getActivity()).load(shop.all.get(position).iamge).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return shop.all.size();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView contentTv,moneyTv,peopleTv,otherTv;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contentTv = itemView.findViewById(R.id.textView9);
            moneyTv = itemView.findViewById(R.id.textView6);
            peopleTv = itemView.findViewById(R.id.textView7);
            otherTv = itemView.findViewById(R.id.textView8);
            imageView = itemView.findViewById(R.id.imageView7);
        }
    }
}