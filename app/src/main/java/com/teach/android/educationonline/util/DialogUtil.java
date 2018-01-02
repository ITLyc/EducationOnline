package com.teach.android.educationonline.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class DialogUtil {
    public  static void chooseItems(final Context context, String item[], final PassInt passInt)

    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setItems(item,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        passInt.pass(which);
                    }
                });
        builder.create().show();

    }
    public static ProgressDialog getProgressDialog(Context context, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static AlertDialog getAlertDialog(Context context, boolean cancelable, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setTitle(title);
        builder.setMessage(msg);
        return builder.create();
    }

    public static AlertDialog getAlertDialog(Context context, boolean cancelable, String title, String msg, int ok , DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(ok, listener);
        builder.setNegativeButton(android.R.string.cancel, null);
        return builder.create();
    }
    public static AlertDialog getAlertDialogNoTitle(Context context, boolean cancelable, String msg , DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setMessage(msg);
        builder.setPositiveButton("确定",listener);
        builder.setNegativeButton(android.R.string.cancel, null);

        return builder.create();
    }

}
