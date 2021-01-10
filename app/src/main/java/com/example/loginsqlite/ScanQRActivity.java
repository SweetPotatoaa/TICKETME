package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//receive the ticket (PNG)
import android.graphics.Picture;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;





public class ScanQRActivity extends AppCompatActivity {

    EditText e1;
    private static Socket s;
    private static ServerSocket ss;
    private static PrintWriter pw;
    String message="" ;
    private static String ip = "192.168.43.40";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientreceiveivingtickets);
        e1 = findViewById(R.id.editTextMessage);

        Thread myThread = new Thread(new MyServerThread());
        myThread.start();
    }

    public void send_text(View v)
    {
        message = e1.getText().toString();
        myTask mt = new myTask();
        mt.execute();
        Toast.makeText(getApplicationContext(),"Data sent",Toast.LENGTH_LONG).show();
    }

    class MyServerThread implements Runnable{
        Socket s;
        ServerSocket ss;
       InputStreamReader isr;
       BufferedReader br;
       Handler h = new Handler();
       String message;
        @Override
        public void run() {
            try {
                ss = new ServerSocket(5001);
                while (true) {
                    s = ss.accept();
                    System.out.println("server socket accepted\n");
                    isr = new InputStreamReader(s.getInputStream());
                    System.out.println("message retrieved");
                    br = new BufferedReader(isr);
                    System.out.println("message stacked");
                    message = br.readLine();
                    h.post(() -> Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class myTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... params) {
            //String message = voids[0];
            try {
                s = new Socket(ip, 5000);

                //send a message
                pw = new PrintWriter((s.getOutputStream()));
                pw.write(message);
                pw.flush();
                pw.close();
                s.close();

                //send a ticket (PNG)
                //BufferedImage

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
