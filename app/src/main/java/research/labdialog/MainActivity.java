package research.labdialog;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonSave;
    Button buttonColor;
    Button buttonGroupName;

    TextView tvName;
    TextView ivColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSave = (Button) findViewById(R.id.button_save);
        buttonColor = (Button) findViewById(R.id.button_color);
        buttonGroupName = (Button) findViewById(R.id.button_group_name);

        tvName = (TextView) findViewById(R.id.tv_name);
        ivColor = (TextView) findViewById(R.id.iv_color);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new ConfirmSaveDialog();
                dialogFragment.show(getFragmentManager(), "");
            }
        });

        buttonGroupName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new RenameGroupDialog();
                dialogFragment.show(getFragmentManager(), "");
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new PickColorDialog();
                dialogFragment.show(getFragmentManager(), "");
            }
        });
    }

    public void onPositiveConfirmSave(){
        Log.i("TAG", "On Confirm");
    }

    public void onGroupNameChanged(String name){
        tvName.setText(name);
    }

    public void onColorChosen(String color){
        Log.i("TAG", "color " + color);
        switch(color){
            case "red": ivColor.setBackgroundColor(Color.parseColor("red"));break;
//            case "orange": ivColor.setBackgroundColor(Color.parseColor("red"));break;
            case "yellow": ivColor.setBackgroundColor(Color.parseColor("yellow"));break;
            case "green": ivColor.setBackgroundColor(Color.parseColor("green"));break;
            case "blue": ivColor.setBackgroundColor(Color.parseColor("blue"));break;
            case "violet": ivColor.setBackgroundColor(Color.parseColor("#FF00FF"));break;
        }
    }
}
