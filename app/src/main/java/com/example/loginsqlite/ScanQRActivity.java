package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/*public class ScanQRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_q_r);
    }
}

package com.example.loginsqlite;
*/
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.nio.channels.AsynchronousChannelGroup;

public class ScanQRActivity extends AppCompatActivity {

    EditText e1;
    private static Socket s;
    private static PrintWriter pw;
    String message = "";
    private static String ip = "192.168.56.1";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientreceiveivingtickets);
        e1 = (EditText)findViewById(R.id.editText);


    }

    public void send_text(View v)
    {
        message = e1.getText().toString();
        myTask mt = new myTask();
        mt.execute();

        Toast.makeText(getApplicationContext(),"Data sent",Toast.LENGTH_LONG).show();
    }

    class myTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                s = new Socket(ip, 5000);
                pw = new PrintWriter((s.getOutputStream()));
                pw.write(message);
                pw.flush();
                pw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
