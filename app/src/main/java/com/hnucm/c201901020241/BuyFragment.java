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

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class BuyFragment extends Fragment {
    String headimg;
    RecyclerView recyclerView;
    Buy buy;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.recyclerView4);
        myAdapter = new MyAdapter();


        x.Ext.init(getActivity().getApplication());
        RequestParams requestParams = new RequestParams("https://www.fastmock.site/mock/655cf65cee3e3cad8708f0466f5f6907/homework10/infor4");

//        Retrofit RxJava
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("MainActivity","result"+result);
                Gson gson=new Gson();
                buy=gson.fromJson(result,Buy.class);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.shop_list, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nameTv.setText(buy.shoplist.get(position).shop_name);
            holder.titleTv.setText(buy.shoplist.get(position).title);
            holder.optionTv.setText(buy.shoplist.get(position).option);
            holder.priceTv.setText(buy.shoplist.get(position).price);
            holder.otherTv.setText(buy.shoplist.get(position).other);
            holder.numTv.setText(buy.shoplist.get(position).num);
            Glide.with(getActivity()).load(buy.shoplist.get(position).image).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return buy.shoplist.size();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv,titleTv,optionTv,priceTv,otherTv,numTv;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.textView13);
            titleTv = itemView.findViewById(R.id.textView14);
            optionTv = itemView.findViewById(R.id.textView15);
            priceTv = itemView.findViewById(R.id.textView16);
            otherTv = itemView.findViewById(R.id.textView18);
            numTv = itemView.findViewById(R.id.textView17);
            imageView = itemView.findViewById(R.id.imageView10);
        }
    }
}