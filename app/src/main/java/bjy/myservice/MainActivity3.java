package bjy.myservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

/**
 * Created by 1229 on 2016/5/4.
 */
public class MainActivity3 extends Activity {
    private TestService3.ThisBinder binder;
    private ServiceConnection coon = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("------Service Connected-------");
            binder = (TestService3.ThisBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("------Service DisConnected-------");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Intent it1 = new Intent(this,TestService3.class);
        Bundle b1 = new Bundle();
        b1.putString("param", "s1");
        it1.putExtras(b1);

        final Intent it2 = new Intent(this,TestService3.class);
        Bundle b2 = new Bundle();
        b2.putString("param", "s2");
        it2.putExtras(b2);

        final Intent it3 = new Intent(this,TestService3.class);
        Bundle b3 = new Bundle();
        b3.putString("param", "s3");
        it3.putExtras(b3);

        //接着启动多次IntentService,每次启动,都会新建一个工作线程
        //但始终只有一个IntentService实例

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bindService(it1,coon,BIND_AUTO_CREATE);
//                bindService(it2,coon,BIND_AUTO_CREATE);
//                bindService(it3,coon,BIND_AUTO_CREATE);
                startService(it1);
                startService(it2);
                startService(it3);
            }
        });
    }
}
