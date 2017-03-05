package wuweiprojects.com.bubblelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by cat on 12/11/2016.
 */

public class addTask extends Activity{
    static final int RESULT_OK = 2;
    TextView test;
    //EditText tasktitle; in order to access it from inside other parts of class
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Button saveButton = (Button) findViewById(R.id.save_button);
        final EditText taskTitle = (EditText) findViewById(R.id.new_task_field);
        final SeekBar taskSize = (SeekBar) findViewById(R.id.seekBar2);
        test = (TextView) findViewById(R.id.bubble_size);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bubble newTask = new Bubble(taskTitle.getText().toString(), taskSize.getProgress());
                Intent result = new Intent();
                result.putExtra("Bubble", newTask);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        taskSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                test.setText(String.valueOf(taskSize.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


}