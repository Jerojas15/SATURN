package tec.proyecto.saturn;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.CompoundButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;


public class AvailabilityActivity extends AppCompatActivity {

    private SessionActivity session = SessionActivity.getSession();
    List<Pair< Pair<Integer,Integer>, Integer>> courseAvailabilities =  session.getAvailabilities();

    // UI
    private android.support.v7.app.ActionBar actionBar;
    TabHost tabHost;


    // Select all toggles
    ToggleButton l_all;
    ToggleButton k_all;
    ToggleButton m_all;
    ToggleButton j_all;
    ToggleButton v_all;
    ToggleButton s_all;

    // Lunes toogles
    ToggleButton togglel700;
    ToggleButton togglel800;
    ToggleButton togglel900;
    ToggleButton togglel1000;
    ToggleButton togglel1100;
    ToggleButton togglel1200;
    ToggleButton togglel1300;
    ToggleButton togglel1400;
    ToggleButton togglel1500;
    ToggleButton togglel1600;
    ToggleButton togglel1700;
    ToggleButton togglel1800;
    ToggleButton togglel1900;
    ToggleButton togglel2000;
    ToggleButton togglel2100;
    // Martes toggles
    ToggleButton togglek700;
    ToggleButton togglek800;
    ToggleButton togglek900;
    ToggleButton togglek1000;
    ToggleButton togglek1100;
    ToggleButton togglek1200;
    ToggleButton togglek1300;
    ToggleButton togglek1400;
    ToggleButton togglek1500;
    ToggleButton togglek1600;
    ToggleButton togglek1700;
    ToggleButton togglek1800;
    ToggleButton togglek1900;
    ToggleButton togglek2000;
    ToggleButton togglek2100;
    // Miércoles toggles
    ToggleButton togglem700;
    ToggleButton togglem800;
    ToggleButton togglem900;
    ToggleButton togglem1000;
    ToggleButton togglem1100;
    ToggleButton togglem1200;
    ToggleButton togglem1300;
    ToggleButton togglem1400;
    ToggleButton togglem1500;
    ToggleButton togglem1600;
    ToggleButton togglem1700;
    ToggleButton togglem1800;
    ToggleButton togglem1900;
    ToggleButton togglem2000;
    ToggleButton togglem2100;
    // Jueves toggles
    ToggleButton togglej700;
    ToggleButton togglej800;
    ToggleButton togglej900;
    ToggleButton togglej1000;
    ToggleButton togglej1100;
    ToggleButton togglej1200;
    ToggleButton togglej1300;
    ToggleButton togglej1400;
    ToggleButton togglej1500;
    ToggleButton togglej1600;
    ToggleButton togglej1700;
    ToggleButton togglej1800;
    ToggleButton togglej1900;
    ToggleButton togglej2000;
    ToggleButton togglej2100;
    // Viernes toggles
    ToggleButton togglev700;
    ToggleButton togglev800;
    ToggleButton togglev900;
    ToggleButton togglev1000;
    ToggleButton togglev1100;
    ToggleButton togglev1200;
    ToggleButton togglev1300;
    ToggleButton togglev1400;
    ToggleButton togglev1500;
    ToggleButton togglev1600;
    ToggleButton togglev1700;
    ToggleButton togglev1800;
    ToggleButton togglev1900;
    ToggleButton togglev2000;
    ToggleButton togglev2100;
    // S'abado toggles
    ToggleButton toggles700;
    ToggleButton toggles800;
    ToggleButton toggles900;
    ToggleButton toggles1000;
    ToggleButton toggles1100;
    ToggleButton toggles1200;
    ToggleButton toggles1300;
    ToggleButton toggles1400;
    ToggleButton toggles1500;
    ToggleButton toggles1600;
    ToggleButton toggles1700;
    ToggleButton toggles1800;
    ToggleButton toggles1900;
    ToggleButton toggles2000;
    ToggleButton toggles2100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#015289")));

        // Nombre del profesor
        TextView professorName = findViewById(R.id.professor_name);
        professorName.setText("Profesor: " + session.getName());

        // Tabs
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        // Tab Lunes
        TabHost.TabSpec spec = tabHost.newTabSpec("L");
        spec.setContent(R.id.l);
        spec.setIndicator("L");
        tabHost.addTab(spec);

        // Tab Martes
        spec = tabHost.newTabSpec("K");
        spec.setContent(R.id.k);
        spec.setIndicator("K");
        tabHost.addTab(spec);

        // Tab Miércoles
        spec = tabHost.newTabSpec("M");
        spec.setContent(R.id.m);
        spec.setIndicator("M");
        tabHost.addTab(spec);

        // Tab Jueves
        spec = tabHost.newTabSpec("J");
        spec.setContent(R.id.j);
        spec.setIndicator("J");
        tabHost.addTab(spec);

        // Tab Viernes
        spec = tabHost.newTabSpec("V");
        spec.setContent(R.id.v);
        spec.setIndicator("V");
        tabHost.addTab(spec);

        // Tab Sábado
        spec = tabHost.newTabSpec("S");
        spec.setContent(R.id.s);
        spec.setIndicator("S");
        tabHost.addTab(spec);

        // Toggles
        l_all = findViewById(R.id.l_all_hours);
        k_all = findViewById(R.id.k_all_hours);
        m_all = findViewById(R.id.m_all_hours);
        j_all = findViewById(R.id.j_all_hours);
        v_all = findViewById(R.id.v_all_hours);
        s_all = findViewById(R.id.s_all_hours);

        // Lunes toogles
        togglel700 = findViewById(R.id.l_700);
        togglel800 = findViewById(R.id.l_800);
        togglel900 = findViewById(R.id.l_900);
        togglel1000 = findViewById(R.id.l_1000);
        togglel1100 = findViewById(R.id.l_1100);
        togglel1200 = findViewById(R.id.l_1200);
        togglel1300 = findViewById(R.id.l_1300);
        togglel1400 = findViewById(R.id.l_1400);
        togglel1500 = findViewById(R.id.l_1500);
        togglel1600 = findViewById(R.id.l_1600);
        togglel1700 = findViewById(R.id.l_1700);
        togglel1800 = findViewById(R.id.l_1800);
        togglel1900 = findViewById(R.id.l_1900);
        togglel2000 = findViewById(R.id.l_2000);
        togglel2100 = findViewById(R.id.l_2100);
        // Martes toggles
        togglek700 = findViewById(R.id.k_700);
        togglek800 = findViewById(R.id.k_800);
        togglek900 = findViewById(R.id.k_900);
        togglek1000 = findViewById(R.id.k_1000);
        togglek1100 = findViewById(R.id.k_1100);
        togglek1200 = findViewById(R.id.k_1200);
        togglek1300 = findViewById(R.id.k_1300);
        togglek1400 = findViewById(R.id.k_1400);
        togglek1500 = findViewById(R.id.k_1500);
        togglek1600 = findViewById(R.id.k_1600);
        togglek1700 = findViewById(R.id.k_1700);
        togglek1800 = findViewById(R.id.k_1800);
        togglek1900 = findViewById(R.id.k_1900);
        togglek2000 = findViewById(R.id.k_2000);
        togglek2100 = findViewById(R.id.k_2100);
        // Miércoles toggles
        togglem700 = findViewById(R.id.m_700);
        togglem800 = findViewById(R.id.m_800);
        togglem900 = findViewById(R.id.m_900);
        togglem1000 = findViewById(R.id.m_1000);
        togglem1100 = findViewById(R.id.m_1100);
        togglem1200 = findViewById(R.id.m_1200);
        togglem1300 = findViewById(R.id.m_1300);
        togglem1400 = findViewById(R.id.m_1400);
        togglem1500 = findViewById(R.id.m_1500);
        togglem1600 = findViewById(R.id.m_1600);
        togglem1700 = findViewById(R.id.m_1700);
        togglem1800 = findViewById(R.id.m_1800);
        togglem1900 = findViewById(R.id.m_1900);
        togglem2000 = findViewById(R.id.m_2000);
        togglem2100 = findViewById(R.id.m_2100);
        // Jueves toggles
        togglej700 = findViewById(R.id.j_700);
        togglej800 = findViewById(R.id.j_800);
        togglej900 = findViewById(R.id.j_900);
        togglej1000 = findViewById(R.id.j_1000);
        togglej1100 = findViewById(R.id.j_1100);
        togglej1200 = findViewById(R.id.j_1200);
        togglej1300 = findViewById(R.id.j_1300);
        togglej1400 = findViewById(R.id.j_1400);
        togglej1500 = findViewById(R.id.j_1500);
        togglej1600 = findViewById(R.id.j_1600);
        togglej1700 = findViewById(R.id.j_1700);
        togglej1800 = findViewById(R.id.j_1800);
        togglej1900 = findViewById(R.id.j_1900);
        togglej2000 = findViewById(R.id.j_2000);
        togglej2100 = findViewById(R.id.j_2100);
        // Viernes toggles
        togglev700 = findViewById(R.id.v_700);
        togglev800 = findViewById(R.id.v_800);
        togglev900 = findViewById(R.id.v_900);
        togglev1000 = findViewById(R.id.v_1000);
        togglev1100 = findViewById(R.id.v_1100);
        togglev1200 = findViewById(R.id.v_1200);
        togglev1300 = findViewById(R.id.v_1300);
        togglev1400 = findViewById(R.id.v_1400);
        togglev1500 = findViewById(R.id.v_1500);
        togglev1600 = findViewById(R.id.v_1600);
        togglev1700 = findViewById(R.id.v_1700);
        togglev1800 = findViewById(R.id.v_1800);
        togglev1900 = findViewById(R.id.v_1900);
        togglev2000 = findViewById(R.id.v_2000);
        togglev2100 = findViewById(R.id.v_2100);
        // Sábado toggles
        toggles700 = findViewById(R.id.s_700);
        toggles800 = findViewById(R.id.s_800);
        toggles900 = findViewById(R.id.s_900);
        toggles1000 = findViewById(R.id.s_1000);
        toggles1100 = findViewById(R.id.s_1100);
        toggles1200 = findViewById(R.id.s_1200);
        toggles1300 = findViewById(R.id.s_1300);
        toggles1400 = findViewById(R.id.s_1400);
        toggles1500 = findViewById(R.id.s_1500);
        toggles1600 = findViewById(R.id.s_1600);
        toggles1700 = findViewById(R.id.s_1700);
        toggles1800 = findViewById(R.id.s_1800);
        toggles1900 = findViewById(R.id.s_1900);
        toggles2000 = findViewById(R.id.s_2000);
        toggles2100 = findViewById(R.id.s_2100);

        /* OnClick Listener de Select all toggles */
        l_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                l_selectAll(l_all.isChecked());
            }
        });

        k_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                k_selectAll(k_all.isChecked());
            }
        });

        m_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                m_selectAll(m_all.isChecked());
            }
        });

        j_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                j_selectAll(j_all.isChecked());
            }
        });
        v_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                v_selectAll(v_all.isChecked());
            }
        });

        s_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                s_selectAll(s_all.isChecked());
            }
        });

        /* OnClick Listener individual de toggles */

        // lunes
        togglel700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        togglel800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        togglel900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        togglel1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        togglel1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        togglel1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        togglel1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        togglel1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        togglel1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        togglel1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        togglel1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        togglel1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        togglel1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        togglel2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        togglel2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        // martes
        togglek700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        togglek800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        togglek900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        togglek1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        togglek1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        togglek1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        togglek1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        togglek1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        togglek1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        togglek1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        togglek1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        togglek1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        togglek1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        togglek2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        togglek2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        // miércoles
        togglem700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        togglem800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        togglem900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        togglem1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        togglem1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        togglem1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        togglem1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        togglem1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        togglem1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        togglem1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        togglem1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        togglem1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        togglem1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        togglem2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        togglem2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        // jueves
        togglej700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        togglej800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        togglej900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        togglej1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        togglej1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        togglej1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        togglej1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        togglej1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        togglej1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        togglej1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        togglej1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        togglej1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        togglej1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        togglej2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        togglej2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        // viernes
        togglev700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        togglev800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        togglev900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        togglev1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        togglev1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        togglev1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        togglev1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        togglev1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        togglev1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        togglev1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        togglev1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        togglev1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        togglev1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        togglev2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        togglev2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        // sábado
        toggles700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 7);
            }
        });
        toggles800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 8);
            }
        });
        toggles900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 9);
            }
        });
        toggles1000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 10);
            }
        });
        toggles1100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 11);
            }
        });
        toggles1200.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 12);
            }
        });
        toggles1300.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 13);
            }
        });
        toggles1400.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 14);
            }
        });
        toggles1500.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 15);
            }
        });
        toggles1600.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 16);
            }
        });
        toggles1700.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 17);
            }
        });
        toggles1800.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 18);
            }
        });
        toggles1900.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 19);
            }
        });
        toggles2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 20);
            }
        });
        toggles2100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAvailabilities(0, 21);
            }
        });

        setAvailabilities();

    }

    public void l_selectAll(Boolean state) {
        togglel700.setChecked(state);
        togglel800.setChecked(state);
        togglel900.setChecked(state);
        togglel1000.setChecked(state);
        togglel1100.setChecked(state);
        togglel1200.setChecked(state);
        togglel1300.setChecked(state);
        togglel1400.setChecked(state);
        togglel1500.setChecked(state);
        togglel1600.setChecked(state);
        togglel1700.setChecked(state);
        togglel1800.setChecked(state);
        togglel1900.setChecked(state);
        togglel2000.setChecked(state);
        togglel2100.setChecked(state);
    }

    public void k_selectAll(Boolean state) {
        togglek700.setChecked(state);
        togglek800.setChecked(state);
        togglek900.setChecked(state);
        togglek1000.setChecked(state);
        togglek1100.setChecked(state);
        togglek1200.setChecked(state);
        togglek1300.setChecked(state);
        togglek1400.setChecked(state);
        togglek1500.setChecked(state);
        togglek1600.setChecked(state);
        togglek1700.setChecked(state);
        togglek1800.setChecked(state);
        togglek1900.setChecked(state);
        togglek2000.setChecked(state);
        togglek2100.setChecked(state);
    }

    public void m_selectAll(Boolean state) {
        togglem700.setChecked(state);
        togglem800.setChecked(state);
        togglem900.setChecked(state);
        togglem1000.setChecked(state);
        togglem1100.setChecked(state);
        togglem1200.setChecked(state);
        togglem1300.setChecked(state);
        togglem1400.setChecked(state);
        togglem1500.setChecked(state);
        togglem1600.setChecked(state);
        togglem1700.setChecked(state);
        togglem1800.setChecked(state);
        togglem1900.setChecked(state);
        togglem2000.setChecked(state);
        togglem2100.setChecked(state);
    }

    public void j_selectAll(Boolean state) {
        togglej700.setChecked(state);
        togglej800.setChecked(state);
        togglej900.setChecked(state);
        togglej1000.setChecked(state);
        togglej1100.setChecked(state);
        togglej1200.setChecked(state);
        togglej1300.setChecked(state);
        togglej1400.setChecked(state);
        togglej1500.setChecked(state);
        togglej1600.setChecked(state);
        togglej1700.setChecked(state);
        togglej1800.setChecked(state);
        togglej1900.setChecked(state);
        togglej2000.setChecked(state);
        togglej2100.setChecked(state);
    }

    public void v_selectAll(Boolean state) {
        togglev700.setChecked(state);
        togglev800.setChecked(state);
        togglev900.setChecked(state);
        togglev1000.setChecked(state);
        togglev1100.setChecked(state);
        togglev1200.setChecked(state);
        togglev1300.setChecked(state);
        togglev1400.setChecked(state);
        togglev1500.setChecked(state);
        togglev1600.setChecked(state);
        togglev1700.setChecked(state);
        togglev1800.setChecked(state);
        togglev1900.setChecked(state);
        togglev2000.setChecked(state);
        togglev2100.setChecked(state);
    }

    public void s_selectAll(Boolean state) {
        toggles700.setChecked(state);
        toggles700.setChecked(state);
        toggles800.setChecked(state);
        toggles900.setChecked(state);
        toggles1000.setChecked(state);
        toggles1100.setChecked(state);
        toggles1200.setChecked(state);
        toggles1300.setChecked(state);
        toggles1400.setChecked(state);
        toggles1500.setChecked(state);
        toggles1600.setChecked(state);
        toggles1700.setChecked(state);
        toggles1800.setChecked(state);
        toggles1900.setChecked(state);
        toggles2000.setChecked(state);
        toggles2100.setChecked(state);

    }

    public void setAvailabilities() {
        // Pair < Pair <inicio , fin> , día >
        for (int i = 0; i < courseAvailabilities.size(); i++) {
            Integer tempInicio = courseAvailabilities.get(i).first.first;
            Integer tempFin = courseAvailabilities.get(i).first.second;

            // Si es lunes
            if (courseAvailabilities.get(i).second == 0) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        togglel700.setChecked(true);
                    } else if (j == 8) {
                        togglel800.setChecked(true);
                    } else if (j == 9) {
                        togglel900.setChecked(true);
                    } else if (j == 10) {
                        togglel1000.setChecked(true);
                    } else if (j == 11) {
                        togglel1100.setChecked(true);
                    } else if (j == 12) {
                        togglel1200.setChecked(true);
                    } else if (j == 13) {
                        togglel1300.setChecked(true);
                    } else if (j == 14) {
                        togglel1400.setChecked(true);
                    } else if (j == 15) {
                        togglel1500.setChecked(true);
                    } else if (j == 16) {
                        togglel1600.setChecked(true);
                    } else if (j == 17) {
                        togglel1700.setChecked(true);
                    } else if (j == 18) {
                        togglel1800.setChecked(true);
                    } else if (j == 19) {
                        togglel1900.setChecked(true);
                    } else if (j == 20) {
                        togglel2000.setChecked(true);
                    } else if (j == 21) {
                        togglel2100.setChecked(true);
                    }
                }
            }
            // Si es martes
            if (courseAvailabilities.get(i).second == 1) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        togglek700.setChecked(true);
                    } else if (j == 8) {
                        togglek800.setChecked(true);
                    } else if (j == 9) {
                        togglek900.setChecked(true);
                    } else if (j == 10) {
                        togglek1000.setChecked(true);
                    } else if (j == 11) {
                        togglek1100.setChecked(true);
                    } else if (j == 12) {
                        togglek1200.setChecked(true);
                    } else if (j == 13) {
                        togglek1300.setChecked(true);
                    } else if (j == 14) {
                        togglek1400.setChecked(true);
                    } else if (j == 15) {
                        togglek1500.setChecked(true);
                    } else if (j == 16) {
                        togglek1600.setChecked(true);
                    } else if (j == 17) {
                        togglek1700.setChecked(true);
                    } else if (j == 18) {
                        togglek1800.setChecked(true);
                    } else if (j == 19) {
                        togglek1900.setChecked(true);
                    } else if (j == 20) {
                        togglek2000.setChecked(true);
                    } else if (j == 21) {
                        togglek2100.setChecked(true);
                    }
                }
            }
            // Si es miércoles
            if (courseAvailabilities.get(i).second == 2) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        togglem700.setChecked(true);
                    } else if (j == 8) {
                        togglem800.setChecked(true);
                    } else if (j == 9) {
                        togglem900.setChecked(true);
                    } else if (j == 10) {
                        togglem1000.setChecked(true);
                    } else if (j == 11) {
                        togglem1100.setChecked(true);
                    } else if (j == 12) {
                        togglem1200.setChecked(true);
                    } else if (j == 13) {
                        togglem1300.setChecked(true);
                    } else if (j == 14) {
                        togglem1400.setChecked(true);
                    } else if (j == 15) {
                        togglem1500.setChecked(true);
                    } else if (j == 16) {
                        togglem1600.setChecked(true);
                    } else if (j == 17) {
                        togglem1700.setChecked(true);
                    } else if (j == 18) {
                        togglem1800.setChecked(true);
                    } else if (j == 19) {
                        togglem1900.setChecked(true);
                    } else if (j == 20) {
                        togglem2000.setChecked(true);
                    } else if (j == 21) {
                        togglem2100.setChecked(true);
                    }
                }
            }
            // Si es jueves
            if (courseAvailabilities.get(i).second == 3) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        togglej700.setChecked(true);
                    } else if (j == 8) {
                        togglej800.setChecked(true);
                    } else if (j == 9) {
                        togglej900.setChecked(true);
                    } else if (j == 10) {
                        togglej1000.setChecked(true);
                    } else if (j == 11) {
                        togglej1100.setChecked(true);
                    } else if (j == 12) {
                        togglej1200.setChecked(true);
                    } else if (j == 13) {
                        togglej1300.setChecked(true);
                    } else if (j == 14) {
                        togglej1400.setChecked(true);
                    } else if (j == 15) {
                        togglej1500.setChecked(true);
                    } else if (j == 16) {
                        togglej1600.setChecked(true);
                    } else if (j == 17) {
                        togglej1700.setChecked(true);
                    } else if (j == 18) {
                        togglej1800.setChecked(true);
                    } else if (j == 19) {
                        togglej1900.setChecked(true);
                    } else if (j == 20) {
                        togglej2000.setChecked(true);
                    } else if (j == 21) {
                        togglej2100.setChecked(true);
                    }
                }
            }
            // Si es viernes
            if (courseAvailabilities.get(i).second == 4) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        togglev700.setChecked(true);
                    } else if (j == 8) {
                        togglev800.setChecked(true);
                    } else if (j == 9) {
                        togglev900.setChecked(true);
                    } else if (j == 10) {
                        togglev1000.setChecked(true);
                    } else if (j == 11) {
                        togglev1100.setChecked(true);
                    } else if (j == 12) {
                        togglev1200.setChecked(true);
                    } else if (j == 13) {
                        togglev1300.setChecked(true);
                    } else if (j == 14) {
                        togglev1400.setChecked(true);
                    } else if (j == 15) {
                        togglev1500.setChecked(true);
                    } else if (j == 16) {
                        togglev1600.setChecked(true);
                    } else if (j == 17) {
                        togglev1700.setChecked(true);
                    } else if (j == 18) {
                        togglev1800.setChecked(true);
                    } else if (j == 19) {
                        togglev1900.setChecked(true);
                    } else if (j == 20) {
                        togglev2000.setChecked(true);
                    } else if (j == 21) {
                        togglev2100.setChecked(true);
                    }
                }
            }
            // Si es sábado
            if (courseAvailabilities.get(i).second == 5) {
                for (int j = tempInicio; j <= tempFin; j++) {
                    if (j == 7) {
                        toggles700.setChecked(true);
                    } else if (j == 8) {
                        toggles800.setChecked(true);
                    } else if (j == 9) {
                        toggles900.setChecked(true);
                    } else if (j == 10) {
                        toggles1000.setChecked(true);
                    } else if (j == 11) {
                        toggles1100.setChecked(true);
                    } else if (j == 12) {
                        toggles1200.setChecked(true);
                    } else if (j == 13) {
                        toggles1300.setChecked(true);
                    } else if (j == 14) {
                        toggles1400.setChecked(true);
                    } else if (j == 15) {
                        toggles1500.setChecked(true);
                    } else if (j == 16) {
                        toggles1600.setChecked(true);
                    } else if (j == 17) {
                        toggles1700.setChecked(true);
                    } else if (j == 18) {
                        toggles1800.setChecked(true);
                    } else if (j == 19) {
                        toggles1900.setChecked(true);
                    } else if (j == 20) {
                        toggles2000.setChecked(true);
                    } else if (j == 21) {
                        toggles2100.setChecked(true);
                    }
                }
            }
        }
    }

    public void updateAvailabilities(Integer day, Integer hour) {
        //session.updateAvailability(day, hour);
    }

}
