package es.dpinfo.dynamicfragments.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import es.dpinfo.dynamicfragments.R;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentA extends Fragment {

    private static int seekvalue = 10;
    private SeekBar sbFragments;
    private EditText edtFragments;
    private Button btnFragments;
    private FragmentIterationListener mCallback;
    public static final String TAG_FRAGMENTA  = "fragmenta";

    public interface FragmentIterationListener {
        void onFragmentIterationListener(String text, int size);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (FragmentIterationListener)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement FragmentIterationListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        if (rootView != null) {
            edtFragments = (EditText) rootView.findViewById(R.id.edt_fragment_a);
            sbFragments = (SeekBar) rootView.findViewById(R.id.sb_fragment_a);
            btnFragments = (Button) rootView.findViewById(R.id.btn_fragment_a);

            btnFragments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onFragmentIterationListener(edtFragments.getText().toString(), sbFragments.getProgress());
                }
            });
        }

        return rootView;
    }
}
