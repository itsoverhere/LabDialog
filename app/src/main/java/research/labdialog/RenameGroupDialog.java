package research.labdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by courtneyngo on 1/13/16.
 */
public class RenameGroupDialog extends DialogFragment{

    /*
    * This dialog contains a custom view.
    * Benefits of having a custom view is that you have full control over the UI of the dialog.
    * In this dialog, the view contains an EditText where the user can type in some input.
    * */

    View view;

    private OnUserApprovesListener mOnUserApprovesListener;

    public OnUserApprovesListener getOnUserApprovesListener() {
        return mOnUserApprovesListener;
    }

    public void setOnUserApprovesListener(OnUserApprovesListener mOnUserApprovesListener) {
        this.mOnUserApprovesListener = mOnUserApprovesListener;
    }

    public interface OnUserApprovesListener{
        public void onUserApproves(DialogInterface dialog, int which, String input);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_group_rename, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Rename your group")
                .setView(view)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etName = (EditText) view.findViewById(R.id.et_name);
                        // etName.getText().toString() gets the input of the user in the EditText
                        mOnUserApprovesListener.onUserApproves(dialog, which, etName.getText().toString());
//                        ((MainActivity)getActivity()).onGroupNameChanged(etName.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return  alertDialogBuilder.create();
    }

}
