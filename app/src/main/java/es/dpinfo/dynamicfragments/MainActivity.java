package es.dpinfo.dynamicfragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import es.dpinfo.dynamicfragments.fragments.FragmentA;
import es.dpinfo.dynamicfragments.fragments.FragmentB;

/**
 * Created by usuario on 5/12/16.
 */

public class MainActivity extends Activity implements FragmentA.FragmentIterationListener{

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        fragmentA = (FragmentA) fm.findFragmentByTag(FragmentA.TAG_FRAGMENTA);

        if (fragmentA == null) {
            fragmentA = new FragmentA();
            fm.beginTransaction().add(R.id.activity_main, fragmentA).commit();
        }
    }


    @Override
    public void onFragmentIterationListener(String text, int size) {

        Bundle bundle = new Bundle();
        bundle.putString(FragmentB.TEXT_KEY, text);
        bundle.putInt(FragmentB.SIZE_KEY, size);
        fragmentB = FragmentB.newInstance(bundle);


        // Se empieza la transacción
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragmentB);
        // Guardar en la pila/stack debe realizarse antes del commit
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
