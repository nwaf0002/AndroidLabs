package com.example.manny.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow extends Activity {

    protected static final String ACTIVITY_NAME = "ChatWindow";
    ListView lv;
    Button sendTextButton;
    EditText textFieldEntry;
    ChatAdapter messageAdapter;
//    List messageList = new ArrayList();

    private class ChatAdapter extends ArrayAdapter<String> {

        private List<String> messageList;

        public ChatAdapter(Context ctx) {
            super(ctx, 0);
            messageList = new ArrayList<String>();

        }
        @Override
        public int getCount() {
            return messageList.size();
        }
        @Override
        public String getItem(int position){
            return (String) messageList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView)result.findViewById(R.id.message_text2);
            message.setText( messageList.get(position) ); // get the string at position
            return result;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void add (String s) {
            messageList.add(s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        lv = findViewById(R.id.listView);
        sendTextButton = findViewById(R.id.sendButton);
        textFieldEntry = findViewById(R.id.editText3);
        ArrayList textArrayList;



        //in this case, “this” is the ChatWindow, which is-A Context object

        messageAdapter = new ChatAdapter( this );
        lv.setAdapter (messageAdapter);

        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                messageAdapter.add(textFieldEntry.getText().toString());
                messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount() & getView()
                textFieldEntry.setText("");
            }
        });

    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
