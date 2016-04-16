package com.fatfat.homepage2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private List<Message> messageList;
    private EditText etMessage;
    private MyListView listView;
    private MessageAdapter ma;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setText("前一陣子 美食達人瑪格在臉書推薦了這一間日式料理\n" +
                "我立馬放進我的最愛裡\n" +
                "這天剛好住高雄的妹妹要來台北找我吃飯\n" +
                "我立刻想到這間日式料理\n" +
                "這間餐廳名字取做[還在想] \n" +
                "據瑪格說是老闆有人再問他店名時\n" +
                "老闆說還在想 後來[還在想]就成為這間店的名稱啦");
        TextView tv2 =(TextView)findViewById(R.id.tv2);
        tv2.setText("消費時間：2014年12月、2015年1月、2015年4月，晚餐\n" +
                "\n" +
                "營業時間：18:00- 24:00\n" +
                "\n" +
                "店家地址：新竹市大同路62號2樓\n" +
                "\n" +
                "訂位電話：03-525-5303\n" +
                "\n" +
                "說明：平日用餐時間2小時；五六日用餐時間1.5小時\n" +
                "\n" +
                " \n" +
                "\n" +
                "我對於日式料理的喜好及想像，來自於從小看的日本節目吧?\n" +
                "\n" +
                "無論是料理東西軍、大胃王比賽、偶像劇或是各式各樣的美食節目，就好想吃！\n" +
                "\n" +
                "吃過不少家日本料理，包含台南、新竹、台北，但怎樣算道地?\n" +
                "\n" +
                "說實在，不是日本人也沒去過日本的我，無法回答。\n" +
                "\n" +
                " \n" +
                "\n" +
                "這天想吃日本料理的念頭很強烈\n" +
                "\n" +
                "想到歌摩但食記資訊不多，遲遲猶豫不決……\n" +
                "\n" +
                "考量到需避開百貨公司周年慶車潮，到市區是最安全的選擇\n" +
                "\n" +
                "心動不如馬上行動，GO！\n" +
                "\n" +
                " \n" +
                "\n" +
                "咦，就是這家嗎？散步路過都會多看幾眼，卻沒多加琢磨\n" +
                "\n" +
                "(心想：之前聽過同學說有家二樓日本料理好吃，難道是這家?)");
        messageList = new ArrayList<>();
        messageList.add(new Message(R.drawable.crown,"fffff"));
        listView = (MyListView)findViewById(R.id.lvMessage);
        ma = new MessageAdapter(this,messageList);
        listView.setAdapter(ma);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        etMessage = (EditText)findViewById(R.id.etMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etMessage.getText().length() != 0){
                    //messageList.add(new Message(R.drawable.crown,String.valueOf(etMessage.getText())));

                    Log.e("etMessage",String.valueOf(etMessage.getText()));
                    messageList.add(new Message(R.drawable.crown,String.valueOf(etMessage.getText())));
                    messages = new ArrayList<Message>();
                    for(Iterator<Message> it = messageList.iterator();it.hasNext();) {
                        Message message = it.next();
                        Message messagebuf = new Message(message.getImageId(),message.getText());
                        messages.add(messagebuf);
                    }
                    ma.refMessage(messages);
                    etMessage.setText("");
                    //ma.notifyDataSetChanged();
                    Log.e("message",messages.toString());
                    Log.e("count",String.valueOf(ma.getCount()));

                }
            }
        });
    }

    private class MessageAdapter extends BaseAdapter {
        private List<Message> messageList;
        private Context context;
        private LayoutInflater layoutInflater;
        public MessageAdapter(Context context, List<Message> messageList) {
            this.context=context;
            this.messageList=messageList;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return messageList.size();
        }

        @Override
        public Object getItem(int position) {
            return messageList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return messageList.get(position).getImageId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Message message = messageList.get(position);
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.message,parent,false);
            }
            ImageView imageView = (ImageView)convertView.findViewById(R.id.ivMessage);
            imageView.setImageResource(message.getImageId());
            TextView tvMessage = (TextView) convertView.findViewById(R.id.tvMessage);
            tvMessage.setText(message.getText());
            return convertView;
        }

        public void refMessage(List<Message> messageList){
            this.messageList.clear();
            for(Iterator<Message> it = messageList.iterator();it.hasNext();) {
                this.messageList.add(it.next());
                Log.e("apmessage",String.valueOf(this.messageList.size()));
            }
            notifyDataSetChanged();
        }

    }
}
