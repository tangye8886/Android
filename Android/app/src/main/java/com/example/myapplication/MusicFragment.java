package com.example.myapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.myapplication.adapter.MusicAdapter;
import com.example.myapplication.entity.Music;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by caobotao on 16/1/4.
 */
public class MusicFragment extends Fragment {


    public static List<Music> musicList=new ArrayList<Music>();

    private MediaPlayer player;

    private String playerUrl="";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ListView list = (ListView) view.findViewById(R.id.music_list_view);


      if(musicList.size()<=0)
      {
          sendRequestWithOkHttp();
      }


        //将数据放入list
        list.setAdapter(new MusicAdapter(getActivity(),R.layout.music_item,musicList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        });

        //设置列表点击事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Music music = musicList.get(position);

                //判断这是个播放时还有没有音乐在播放
                if(player!=null&&player.isPlaying()){
                    player.pause();
                }

                //判断点击是不是同一首歌
                if(playerUrl.equals(music.getUrl()))
                {
                    player.pause();

                }else
                {

                    try {
                        player = new MediaPlayer();
                        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        player.setDataSource(music.getUrl());
                        player.prepare();

                        if (player.isPlaying()){
                            player.pause();
                        }else
                        {
                            player.start();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        playerUrl=music.getUrl();
                    }
                }

                playerUrl=music.getUrl();




                try {

                    Music ms = musicList.get(position+1);//下一首音乐

                    MediaPlayer  mp=new MediaPlayer();
                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mp.setDataSource(ms.getUrl());
                    mp.prepare();
                    player.setNextMediaPlayer(mp);


                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        });

    }


    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            // 指定访问的服务器地址是电脑本机
                            .url("http://192.168.2.139:8888/music/allMusic")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithJSONObject(responseData);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void parseJSONWithJSONObject(String jsonData) {

        try {
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Integer id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String singer = jsonObject.getString("singer");
                String url = jsonObject.getString("url");
                Music music=new Music(id,name,singer+"-",url);
                musicList.add(music);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
