package research.labdialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by courtneyngo on 1/13/16.
 */
public class PickColorDialog extends DialogFragment {

    String[] colors = new String[]{
            "red", /*"Orange",*/ "yellow", "green", "blue", "violet"
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Choose a color")
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).onColorChosen(colors[which]);
                    }
                });

        return  alertDialogBuilder.create();
    }
}
