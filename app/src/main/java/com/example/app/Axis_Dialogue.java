package com.example.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Axis_Dialogue extends AppCompatDialogFragment {
    private EditText axis_power;
    private AxisDialogueListener axisDialogueListener;
    private View view;
    private TextView type;
    private String meye,mside;
    public Axis_Dialogue(String eye,String side) {
        meye=eye;mside=side;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable  Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.axis_dialogue,null);
        builder.setView(view).setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String axis=axis_power.getText().toString();
                axisDialogueListener.applyAxis(axis,mside);
            }
        });
        axis_power=view.findViewById(R.id.axis_edit_text);
        type=view.findViewById(R.id.eye);
        type.setText(meye);
        return builder.create();
    }

    public interface AxisDialogueListener{
        void applyAxis(String axis,String side);
    }
    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        try {
            axisDialogueListener=(AxisDialogueListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implent AxisDialogueListener");
        }
    }
}
