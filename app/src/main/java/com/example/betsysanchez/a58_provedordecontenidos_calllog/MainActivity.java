package com.example.betsysanchez.a58_provedordecontenidos_calllog;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String [][] logs;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        guardar = findViewById(R.id.btnGuardar);
        // Calls Log
        Calls();
            //Recycler
        adapter = new RecyclerAdapter(logs);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuardarLista();
            }
        });
    }

    public void Calls(){
        Uri allCalls = Uri.parse("content://call_log/calls");
        Cursor c = managedQuery(allCalls,null,null,null,null);
        logs = new String[c.getCount()][4];
        int counter =0;
        c.moveToLast();
        for(int i=c.getCount();i>0;i--){
            logs[counter][0]= c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
            logs[counter][1]= c.getString(c.getColumnIndex(CallLog.Calls.CACHED_NAME));
            logs[counter][2]= c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
            logs[counter][3]= c.getString(c.getColumnIndex(CallLog.Calls.TYPE));
            c.moveToPrevious();
            counter++;
        }
    }

    private void GuardarLista(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CallLogs");
        myRef.setValue("");
        int counter=0;
        String type="";
        while(counter<logs.length){
            Call call = new Call(logs[counter][0],logs[counter][1],logs[counter][2],logs[counter][3]);
            myRef.push().setValue(call);
            counter++;
        }
    }

}
