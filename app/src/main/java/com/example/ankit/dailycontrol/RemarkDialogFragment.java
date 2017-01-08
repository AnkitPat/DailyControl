package com.example.ankit.dailycontrol;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by ANKIT on 06/01/2017.
 */

public class RemarkDialogFragment extends DialogFragment {


    NewListAdapterTest newTst;
    private SendResult sendResult;
    ArrayList<String> list;

    public RemarkDialogFragment(NewListAdapterTest context,ArrayList<String> list) {
        this.newTst = context;
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remark_layout, container, false);

        final Spinner spinner = (Spinner) view.findViewById(R.id.preCommentSpinner);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        spinner.setAdapter(new SpinnerAdapterPreComment(getActivity(), arrayList));

        final EditText remarkEditText = (EditText) view.findViewById(R.id.editText);
        Button save = (Button) view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendResult.onFinishTyping(arrayList.get(spinner.getSelectedItemPosition()) + " " + remarkEditText.getText(),list);

                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        sendResult = (SendResult) newTst;
    }

    public interface SendResult {
        void onFinishTyping(String text,ArrayList<String> list);
    }
}
