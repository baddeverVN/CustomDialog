package com.example.minhtien.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDialog1, btnDialog2;
    public static final int DIALOG1 = 1;
    public static final int DIALOG2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog1 = (Button) findViewById(R.id.btnDialog1);
        btnDialog2 = (Button) findViewById(R.id.btnDialog2);
        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG1);
            }
        });
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG2);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog alertDialog = null;
        switch (id) {
            case DIALOG1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Đây là dialog!");
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                        // your code
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                        // your code
                    }
                });
                alertDialog = builder.create();
                break;
            case DIALOG2 :
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogview = inflater.inflate(R.layout.cutom_dialog, null);
                AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
                dialogbuilder.setTitle("Title");
                dialogbuilder.setView(dialogview);
                alertDialog = dialogbuilder.create();
                break;
        }
        return alertDialog;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id){
            case DIALOG2 :
                final AlertDialog alertDialog = (AlertDialog) dialog;
                Button btnOK = (Button) alertDialog.findViewById(R.id.btn_OK);
                Button cancelbutton = (Button) alertDialog.findViewById(R.id.btn_cancel);
                final EditText userName = (EditText) alertDialog.findViewById(R.id.dialog_txt_name);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       return ;
                        // your code
                    }
                });

                cancelbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            break;
        }
    }
}
