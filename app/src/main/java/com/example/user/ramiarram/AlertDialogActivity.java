package com.example.user.ramiarram;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==dialog.BUTTON_NEGATIVE){
            Toast.makeText(this, ":(", Toast.LENGTH_SHORT).show();
        }
        if(which==dialog.BUTTON_POSITIVE){
            Toast.makeText(this, "Yohoo!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", this);
        builder.setNegativeButton("NO", this);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
