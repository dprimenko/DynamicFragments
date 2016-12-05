package es.dpinfo.dynamicfragments.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.dpinfo.dynamicfragments.R;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentB extends Fragment {

    private TextView txvFragmentB;
    public static final String TEXT_KEY = "text";
    public static final String SIZE_KEY = "size";
    public static final String TAG_FRAGMENTB  = "fragmentb";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this fragment
        setRetainInstance(true);
    }

    public static FragmentB newInstance(Bundle arguments) {
        FragmentB fragmentB = new FragmentB();
        if (arguments != null) {
            fragmentB.setArguments(arguments);
        }

        return fragmentB;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        if (rootView != null) {
            txvFragmentB = (TextView) rootView.findViewById(R.id.txv_fragment_b);
            Bundle bundle = getArguments();

            if (bundle != null) {
                txvFragmentB.setText(bundle.getString(TEXT_KEY));
                txvFragmentB.setTextSize(bundle.getInt(SIZE_KEY));
            }
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txvFragment", txvFragmentB.getText().toString());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
