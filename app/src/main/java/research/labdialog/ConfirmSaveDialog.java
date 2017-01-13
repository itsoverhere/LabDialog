package research.labdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by courtneyngo on 1/13/16.
 */
public class ConfirmSaveDialog extends DialogFragment {

    private OnUserApprovesListener mOnUserApprovesListener;

    public OnUserApprovesListener getOnUserApprovesListener() {
        return mOnUserApprovesListener;
    }

    public void setOnUserApprovesListener(OnUserApprovesListener mOnUserApprovesListener) {
        this.mOnUserApprovesListener = mOnUserApprovesListener;
    }

    public interface OnUserApprovesListener{
        public void onUserApproves(DialogInterface dialog, int which);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Alert")
                .setMessage("Are you sure you want to make these changes?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mOnUserApprovesListener.onUserApproves(dialog, which);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return alertDialogBuilder.create();
    }

}
