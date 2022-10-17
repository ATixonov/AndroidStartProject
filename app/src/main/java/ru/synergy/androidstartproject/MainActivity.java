package ru.synergy.androidstartproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQ_C = 1;
    EditText et;
    private TextView tv;
    ActivityResultLauncher<Intent> mStartActivityForResult = registerForActivityResult (
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    tv.setText(intent.getStringExtra("tv"));
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        Button btn = (Button) findViewById(R.id.button3);
        Button btn2 = (Button) findViewById(R.id.button4);
        Button btn3 = (Button) findViewById(R.id.button5);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button3:
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.button4:
                i = new Intent(this, ToInfActivity.class);
                String eText = et.getText().toString();
                i.putExtra("et", eText);
                startActivity(i);
                break;
            case R.id.button5:
                i = new Intent(this, ComebackActivity.class);
                mStartActivityForResult.launch(i);
        }
    }
}
