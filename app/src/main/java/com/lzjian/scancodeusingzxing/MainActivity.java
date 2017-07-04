package com.lzjian.scancodeusingzxing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzjian.scancodeusingzxing.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SCAN_CODE_REQUEST = 1;
    private Button btn_scan;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_scan = (Button) findViewById(R.id.btn_scan);
        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, SCAN_CODE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case SCAN_CODE_REQUEST:
                    if (data != null){
                        String scanResult = data.getStringExtra(CaptureActivity.KEY_SCAN_RESULT);
                        if (!TextUtils.isEmpty(scanResult)){
                            tv_result.setText(scanResult);
                        }
                    }
                    break;
            }
        }
    }
}
