package bjy.myservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 1229 on 2016/4/29.
 */
public class TestService3 extends IntentService {
    private final String TAG = getClass().getName();

    public TestService3()
    {
        super("TestService3");
    }

    //必须重写的核心方法
    @Override
    protected void onHandleIntent(Intent intent) {
    //Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
        Log.e(TAG,"onHandleIntent");
        String action = intent.getExtras().getString("param");
        if(action.equals("s1"))Log.i(TAG,"启动service1");
        else if(action.equals("s2"))Log.i(TAG,"启动service2");
        else if(action.equals("s3"))Log.i(TAG,"启动service3");

        //让服务休眠2秒
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){e.printStackTrace();}
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return new ThisBinder();
    }

    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Log.e(TAG, "setIntentRedelivery");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    public class ThisBinder extends Binder{

    }
}
