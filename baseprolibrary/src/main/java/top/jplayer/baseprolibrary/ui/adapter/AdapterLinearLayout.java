package top.jplayer.baseprolibrary.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import java.util.zip.Inflater;

import top.jplayer.baseprolibrary.R;

/**
 * Created by Obl on 2018/1/22.
 * top.jplayer.baseprolibrary.ui.adapter
 */

public class AdapterLinearLayout extends DelegateAdapter.Adapter {
    private LinearLayoutHelper helper;
    private Context context;

    public AdapterLinearLayout(Context context, LinearLayoutHelper helper) {
        this.helper = helper;
        helper.setBgColor(R.color.cornflowerblue);
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.layout_test, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewholder) holder).text.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private TextView text;

        public MyViewholder(View view) {
            super(view);
            text = view.findViewById(R.id.tvNum);
        }
    }
}
