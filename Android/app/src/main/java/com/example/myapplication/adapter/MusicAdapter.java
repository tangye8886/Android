package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.Music;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<Music> {

    private int resourceId;

    private int resource;
    private List<Music> data;
    private Context context;

    public MusicAdapter(Context context, int textViewResourceId, List<Music> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
        this.data=objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Music music = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.musicImage = (ImageView) view.findViewById (R.id.music_image);
            viewHolder.musicSinger = (TextView) view.findViewById (R.id.music_singer);
            viewHolder.musicName = (TextView) view.findViewById (R.id.music_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.musicImage.setImageResource(R.drawable.music);
        viewHolder.musicSinger.setText(music.getSinger());
        viewHolder.musicName.setText(music.getName());
        return view;
    }

    protected class ViewHolder {

        ImageView musicImage;

        TextView musicSinger;

        TextView musicName;

    }

}
