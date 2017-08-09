package com.recordlife.www.recordlife.MyAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recordlife.www.recordlife.R;
import com.recordlife.www.recordlife.bean.RecordModelBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by SS on 17-1-16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private List<RecordModelBean> list;
    private Context mContext;
    public MyRecyclerViewAdapter( List<RecordModelBean> list,Context mContext){
        this.list = list;
        this.mContext = mContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
            return holder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setName(list.get(position).getUsername());
        holder.setIn(list.get(position).getmContent());
        holder.setOuter(list.get(position).getmTitle());
        holder.setData(list.get(position).getmDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name,in,outer,data;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_tv);
            in = (TextView) itemView.findViewById(R.id.in_tv);
            outer = (TextView) itemView.findViewById(R.id.out_tv);
            data = (TextView) itemView.findViewById(R.id.date_tv);
        }
        public void setName(String str){
            name.setText(str);
        }
        public void setIn(String putin){
            in.setText(putin);
        }
        public void setOuter(String out){
            outer.setText(out);
        }
        public void setData(String date){
            data.setText(date);
        }

    }
}
