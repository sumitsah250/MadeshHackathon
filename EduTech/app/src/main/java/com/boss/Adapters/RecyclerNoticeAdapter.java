package com.boss.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.edutech.R;
import com.boss.edutech.databinding.NoticeBackgroundBinding;
import com.boss.modelClass.NoticeModel;

import java.util.ArrayList;

public class RecyclerNoticeAdapter extends RecyclerView.Adapter<RecyclerNoticeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NoticeModel> noticeModels;

    public RecyclerNoticeAdapter(Context context, ArrayList<NoticeModel> noticeModels) {
        this.context = context;
        this.noticeModels = noticeModels;
    }

    @NonNull
    @Override
    public RecyclerNoticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_background,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerNoticeAdapter.ViewHolder holder, int position) {
        holder.binding.noticename.setText( noticeModels.get(position).getNoticeName());
        holder.binding.noticetime.setText((CharSequence) noticeModels.get(position).getNoticeTime());
    }

    @Override
    public int getItemCount() {
        return noticeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NoticeBackgroundBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=NoticeBackgroundBinding.bind(itemView);
        }
    }
}
