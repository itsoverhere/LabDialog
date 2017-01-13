package research.labdialog;

import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

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
                ConfirmSaveDialog dialogFragment = new ConfirmSaveDialog();
                dialogFragment.setOnUserApprovesListener(new ConfirmSaveDialog.OnUserApprovesListener() {
                    @Override
                    public void onUserApproves(DialogInterface dialog, int which) {
                        Snackbar.make(buttonSave, "User has confirmed.", Snackbar.LENGTH_SHORT).show();
                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "");
            }
        });

        buttonGroupName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RenameGroupDialog dialogFragment = new RenameGroupDialog();
                dialogFragment.setOnUserApprovesListener(new RenameGroupDialog.OnUserApprovesListener() {
                    @Override
                    public void onUserApproves(DialogInterface dialog, int which, String input) {
                        onGroupNameChanged(input);
                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "");
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickColorDialog dialogFragment = new PickColorDialog();
                dialogFragment.setOnUserApprovesListener(new PickColorDialog.OnUserApprovesListener() {
                    @Override
                    public void onUserApproves(DialogInterface dialog, int which, String color) {
                        onColorChosen(color);
                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "");
            }
        });
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
