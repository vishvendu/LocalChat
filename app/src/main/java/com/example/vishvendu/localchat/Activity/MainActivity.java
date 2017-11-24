package com.example.vishvendu.localchat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vishvendu.localchat.Utils.ChatApplication;
import com.example.vishvendu.localchat.Adapter.ChatListAdapter;
import com.example.vishvendu.localchat.Callbacks.IDaoViewInsert;
import com.example.vishvendu.localchat.R;
import com.example.vishvendu.localchat.database.Chats;
import com.example.vishvendu.localchat.database.DaoSession;
import com.example.vishvendu.localchat.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements IDaoViewInsert {

    private RecyclerView recyclerView;
    private Button sendButton;
    private EditText editText;
    private String chatdataString;
    private ArrayList<String> userOneList,DaoUserOneList;
    private ArrayList<Integer> userTwoList,DaoUserTwoList;
    private ChatListAdapter chatListAdapter;
    private Random random;
    private String mRandomData;
    private User user1, user2;
    private long userOne, userTwo;
    private List<Chats> chatList;
    private Chats chatsforUsers, chatsforRandomUser;
    private IDaoViewInsert iDaoViewInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        iDaoViewInsert = (IDaoViewInsert)this;

        initApp();
        iDaoViewInsert.showDataDao();
    }

    private void initApp() {

        userOneList = new ArrayList<>();
        userTwoList = new ArrayList<>();
        DaoUserOneList = new ArrayList<>();
        DaoUserTwoList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.chat_recyclerview);
        sendButton = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.chatbox_edittext);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                chatdataString = editText.getText().toString();
                DaoUserOneList.add(chatdataString);
                mRandomData = String.valueOf(random.nextInt(100));
                DaoUserTwoList.add(Integer.valueOf(mRandomData));
                editText.getText().clear();

                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new ChatListAdapter(DaoUserOneList, DaoUserTwoList, getApplication()));
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());


                iDaoViewInsert.insertDataDao();

            }
        });

    }

    public DaoSession getAppDaoSession() {
        return ((ChatApplication) getApplication()).getDaoSession();
    }

    @Override
    public void insertDataDao() {

        user1 = new User(null, "firstUser");
        user2 = new User(null, "randomUser");
        userOne = getAppDaoSession().getUserDao().insert(user1);
        userTwo = getAppDaoSession().getUserDao().insert(user2);


        chatList = new ArrayList<>();
        chatsforUsers = new Chats(null, chatdataString, mRandomData,null);
        chatList.add(chatsforUsers);
        getAppDaoSession().getChatsDao().insertInTx(chatList);

    }

    @Override
    public boolean showDataDao() {


        String TableName = getAppDaoSession().getUserDao().getTablename();

        if(TableName.equals("USER")){


            List<Chats> chat = ((ChatApplication)getApplication()).getDaoSession().getChatsDao().loadAll();
            List<User> users = ((ChatApplication)getApplication()).getDaoSession().getUserDao().loadAll();
            for (Chats a :chat){

                DaoUserOneList.add(a.getChatDataUserOne());
                DaoUserTwoList.add(Integer.valueOf(a.getChatDataRandomeUser()));

            }
            recyclerView.setAdapter(new ChatListAdapter(DaoUserOneList, DaoUserTwoList, getApplication()));
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            return true;

        }

        return false;

    }
}
