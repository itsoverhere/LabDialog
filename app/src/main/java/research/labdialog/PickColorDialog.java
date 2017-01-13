package research.labdialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by courtneyngo on 1/13/16.
 */
public class PickColorDialog extends DialogFragment {

    /*
    * This dialog contains a list.
    * The list items are written in the String[] colors.
    * */

    private OnUserApprovesListener mOnUserApprovesListener;

    public OnUserApprovesListener getOnUserApprovesListener() {
        return mOnUserApprovesListener;
    }

    public void setOnUserApprovesListener(OnUserApprovesListener mOnUserApprovesListener) {
        this.mOnUserApprovesListener = mOnUserApprovesListener;
    }

    public interface OnUserApprovesListener{
        public void onUserApproves(DialogInterface dialog, int which, String color);
    }

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
                        mOnUserApprovesListener.onUserApproves(dialog, which, colors[which]);
//                        ((MainActivity)getActivity()).onColorChosen(colors[which]);
                    }
                });

        return  alertDialogBuilder.create();
    }
}
