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

import java.util.ArrayList;
import java.util.List;


public class AvailabilityActivity extends AppCompatActivity {

    private SessionActivity session = SessionActivity.getSession();
    List<Pair< Pair<Integer,Integer>, Integer>> courseAvailabilities =  session.getAvailabilities();
    private final Integer INDEX_MONDAY = 0;
    private final Integer INDEX_TUESDAY = 1;
    private final Integer INDEX_WEDNESDAY = 2;
    private final Integer INDEX_THURSDAY = 3;
    private final Integer INDEX_FRIDAY = 4;
    private final Integer INDEX_SATURDAY = 5;
    List<ToggleButton> TOGGLES_MONDAY = new ArrayList<>();
    List<ToggleButton> TOGGLES_TUESDAY = new ArrayList<>();
    List<ToggleButton> TOGGLES_WEDNESDAY = new ArrayList<>();
    List<ToggleButton> TOGGLES_THURSDAY = new ArrayList<>();
    List<ToggleButton> TOGGLES_FRIDAY = new ArrayList<>();
    List<ToggleButton> TOGGLES_SATURDAY = new ArrayList<>();


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
        ToggleButton togglel700 = findViewById(R.id.l_700);
        ToggleButton togglel800 = findViewById(R.id.l_800);
        ToggleButton togglel900 = findViewById(R.id.l_900);
        ToggleButton togglel1000 = findViewById(R.id.l_1000);
        ToggleButton togglel1100 = findViewById(R.id.l_1100);
        ToggleButton togglel1200 = findViewById(R.id.l_1200);
        ToggleButton togglel1300 = findViewById(R.id.l_1300);
        ToggleButton togglel1400 = findViewById(R.id.l_1400);
        ToggleButton togglel1500 = findViewById(R.id.l_1500);
        ToggleButton togglel1600 = findViewById(R.id.l_1600);
        ToggleButton togglel1700 = findViewById(R.id.l_1700);
        ToggleButton togglel1800 = findViewById(R.id.l_1800);
        ToggleButton togglel1900 = findViewById(R.id.l_1900);
        ToggleButton togglel2000 = findViewById(R.id.l_2000);
        ToggleButton togglel2100 = findViewById(R.id.l_2100);

        TOGGLES_MONDAY.add(togglel700);
        TOGGLES_MONDAY.add(togglel800);
        TOGGLES_MONDAY.add(togglel900);
        TOGGLES_MONDAY.add(togglel1000);
        TOGGLES_MONDAY.add(togglel1100);
        TOGGLES_MONDAY.add(togglel1200);
        TOGGLES_MONDAY.add(togglel1300);
        TOGGLES_MONDAY.add(togglel1400);
        TOGGLES_MONDAY.add(togglel1500);
        TOGGLES_MONDAY.add(togglel1600);
        TOGGLES_MONDAY.add(togglel1700);
        TOGGLES_MONDAY.add(togglel1800);
        TOGGLES_MONDAY.add(togglel1900);
        TOGGLES_MONDAY.add(togglel2000);
        TOGGLES_MONDAY.add(togglel2100);


        // Martes toggles
        ToggleButton togglek700 = findViewById(R.id.k_700);
        ToggleButton togglek800 = findViewById(R.id.k_800);
        ToggleButton togglek900 = findViewById(R.id.k_900);
        ToggleButton togglek1000 = findViewById(R.id.k_1000);
        ToggleButton togglek1100 = findViewById(R.id.k_1100);
        ToggleButton togglek1200 = findViewById(R.id.k_1200);
        ToggleButton togglek1300 = findViewById(R.id.k_1300);
        ToggleButton togglek1400 = findViewById(R.id.k_1400);
        ToggleButton togglek1500 = findViewById(R.id.k_1500);
        ToggleButton togglek1600 = findViewById(R.id.k_1600);
        ToggleButton togglek1700 = findViewById(R.id.k_1700);
        ToggleButton togglek1800 = findViewById(R.id.k_1800);
        ToggleButton togglek1900 = findViewById(R.id.k_1900);
        ToggleButton togglek2000 = findViewById(R.id.k_2000);
        ToggleButton togglek2100 = findViewById(R.id.k_2100);

        TOGGLES_TUESDAY.add(togglek700);
        TOGGLES_TUESDAY.add(togglek800);
        TOGGLES_TUESDAY.add(togglek900);
        TOGGLES_TUESDAY.add(togglek1000);
        TOGGLES_TUESDAY.add(togglek1100);
        TOGGLES_TUESDAY.add(togglek1200);
        TOGGLES_TUESDAY.add(togglek1300);
        TOGGLES_TUESDAY.add(togglek1400);
        TOGGLES_TUESDAY.add(togglek1500);
        TOGGLES_TUESDAY.add(togglek1600);
        TOGGLES_TUESDAY.add(togglek1700);
        TOGGLES_TUESDAY.add(togglek1800);
        TOGGLES_TUESDAY.add(togglek1900);
        TOGGLES_TUESDAY.add(togglek2000);
        TOGGLES_TUESDAY.add(togglek2100);

        // Miércoles toggles
        ToggleButton togglem700 = findViewById(R.id.m_700);
        ToggleButton togglem800 = findViewById(R.id.m_800);
        ToggleButton togglem900 = findViewById(R.id.m_900);
        ToggleButton togglem1000 = findViewById(R.id.m_1000);
        ToggleButton togglem1100 = findViewById(R.id.m_1100);
        ToggleButton togglem1200 = findViewById(R.id.m_1200);
        ToggleButton togglem1300 = findViewById(R.id.m_1300);
        ToggleButton togglem1400 = findViewById(R.id.m_1400);
        ToggleButton togglem1500 = findViewById(R.id.m_1500);
        ToggleButton togglem1600 = findViewById(R.id.m_1600);
        ToggleButton togglem1700 = findViewById(R.id.m_1700);
        ToggleButton togglem1800 = findViewById(R.id.m_1800);
        ToggleButton togglem1900 = findViewById(R.id.m_1900);
        ToggleButton togglem2000 = findViewById(R.id.m_2000);
        ToggleButton togglem2100 = findViewById(R.id.m_2100);

        TOGGLES_WEDNESDAY.add(togglem700);
        TOGGLES_WEDNESDAY.add(togglem800);
        TOGGLES_WEDNESDAY.add(togglem900);
        TOGGLES_WEDNESDAY.add(togglem1000);
        TOGGLES_WEDNESDAY.add(togglem1100);
        TOGGLES_WEDNESDAY.add(togglem1200);
        TOGGLES_WEDNESDAY.add(togglem1300);
        TOGGLES_WEDNESDAY.add(togglem1400);
        TOGGLES_WEDNESDAY.add(togglem1500);
        TOGGLES_WEDNESDAY.add(togglem1600);
        TOGGLES_WEDNESDAY.add(togglem1700);
        TOGGLES_WEDNESDAY.add(togglem1800);
        TOGGLES_WEDNESDAY.add(togglem1900);
        TOGGLES_WEDNESDAY.add(togglem2000);
        TOGGLES_WEDNESDAY.add(togglem2100);

        // Jueves toggles
        ToggleButton togglej700 = findViewById(R.id.j_700);
        ToggleButton togglej800 = findViewById(R.id.j_800);
        ToggleButton togglej900 = findViewById(R.id.j_900);
        ToggleButton togglej1000 = findViewById(R.id.j_1000);
        ToggleButton togglej1100 = findViewById(R.id.j_1100);
        ToggleButton togglej1200 = findViewById(R.id.j_1200);
        ToggleButton togglej1300 = findViewById(R.id.j_1300);
        ToggleButton togglej1400 = findViewById(R.id.j_1400);
        ToggleButton togglej1500 = findViewById(R.id.j_1500);
        ToggleButton togglej1600 = findViewById(R.id.j_1600);
        ToggleButton togglej1700 = findViewById(R.id.j_1700);
        ToggleButton togglej1800 = findViewById(R.id.j_1800);
        ToggleButton togglej1900 = findViewById(R.id.j_1900);
        ToggleButton togglej2000 = findViewById(R.id.j_2000);
        ToggleButton togglej2100 = findViewById(R.id.j_2100);

        TOGGLES_THURSDAY.add(togglej700);
        TOGGLES_THURSDAY.add(togglej800);
        TOGGLES_THURSDAY.add(togglej900);
        TOGGLES_THURSDAY.add(togglej1000);
        TOGGLES_THURSDAY.add(togglej1100);
        TOGGLES_THURSDAY.add(togglej1200);
        TOGGLES_THURSDAY.add(togglej1300);
        TOGGLES_THURSDAY.add(togglej1400);
        TOGGLES_THURSDAY.add(togglej1500);
        TOGGLES_THURSDAY.add(togglej1600);
        TOGGLES_THURSDAY.add(togglej1700);
        TOGGLES_THURSDAY.add(togglej1800);
        TOGGLES_THURSDAY.add(togglej1900);
        TOGGLES_THURSDAY.add(togglej2000);
        TOGGLES_THURSDAY.add(togglej2100);

        // Viernes toggles
        ToggleButton togglev700 = findViewById(R.id.v_700);
        ToggleButton togglev800 = findViewById(R.id.v_800);
        ToggleButton togglev900 = findViewById(R.id.v_900);
        ToggleButton togglev1000 = findViewById(R.id.v_1000);
        ToggleButton togglev1100 = findViewById(R.id.v_1100);
        ToggleButton togglev1200 = findViewById(R.id.v_1200);
        ToggleButton togglev1300 = findViewById(R.id.v_1300);
        ToggleButton togglev1400 = findViewById(R.id.v_1400);
        ToggleButton togglev1500 = findViewById(R.id.v_1500);
        ToggleButton togglev1600 = findViewById(R.id.v_1600);
        ToggleButton togglev1700 = findViewById(R.id.v_1700);
        ToggleButton togglev1800 = findViewById(R.id.v_1800);
        ToggleButton togglev1900 = findViewById(R.id.v_1900);
        ToggleButton togglev2000 = findViewById(R.id.v_2000);
        ToggleButton togglev2100 = findViewById(R.id.v_2100);

        TOGGLES_FRIDAY.add(togglev700);
        TOGGLES_FRIDAY.add(togglev800);
        TOGGLES_FRIDAY.add(togglev900);
        TOGGLES_FRIDAY.add(togglev1000);
        TOGGLES_FRIDAY.add(togglev1100);
        TOGGLES_FRIDAY.add(togglev1200);
        TOGGLES_FRIDAY.add(togglev1300);
        TOGGLES_FRIDAY.add(togglev1400);
        TOGGLES_FRIDAY.add(togglev1500);
        TOGGLES_FRIDAY.add(togglev1600);
        TOGGLES_FRIDAY.add(togglev1700);
        TOGGLES_FRIDAY.add(togglev1800);
        TOGGLES_FRIDAY.add(togglev1900);
        TOGGLES_FRIDAY.add(togglev2000);
        TOGGLES_FRIDAY.add(togglev2100);

        // Sábado toggles
        ToggleButton toggles700 = findViewById(R.id.s_700);
        ToggleButton toggles800 = findViewById(R.id.s_800);
        ToggleButton toggles900 = findViewById(R.id.s_900);
        ToggleButton toggles1000 = findViewById(R.id.s_1000);
        ToggleButton toggles1100 = findViewById(R.id.s_1100);
        ToggleButton toggles1200 = findViewById(R.id.s_1200);
        ToggleButton toggles1300 = findViewById(R.id.s_1300);
        ToggleButton toggles1400 = findViewById(R.id.s_1400);
        ToggleButton toggles1500 = findViewById(R.id.s_1500);
        ToggleButton toggles1600 = findViewById(R.id.s_1600);
        ToggleButton toggles1700 = findViewById(R.id.s_1700);
        ToggleButton toggles1800 = findViewById(R.id.s_1800);
        ToggleButton toggles1900 = findViewById(R.id.s_1900);
        ToggleButton toggles2000 = findViewById(R.id.s_2000);
        ToggleButton toggles2100 = findViewById(R.id.s_2100);

        TOGGLES_SATURDAY.add(toggles700);
        TOGGLES_SATURDAY.add(toggles800);
        TOGGLES_SATURDAY.add(toggles900);
        TOGGLES_SATURDAY.add(toggles1000);
        TOGGLES_SATURDAY.add(toggles1100);
        TOGGLES_SATURDAY.add(toggles1200);
        TOGGLES_SATURDAY.add(toggles1300);
        TOGGLES_SATURDAY.add(toggles1400);
        TOGGLES_SATURDAY.add(toggles1500);
        TOGGLES_SATURDAY.add(toggles1600);
        TOGGLES_SATURDAY.add(toggles1700);
        TOGGLES_SATURDAY.add(toggles1800);
        TOGGLES_SATURDAY.add(toggles1900);
        TOGGLES_SATURDAY.add(toggles2000);
        TOGGLES_SATURDAY.add(toggles2100);

        setAvailabilities();

        /* OnClick Listener de Select all toggles */
        l_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllMonday(l_all.isChecked());
            }
        });

        k_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllTuesday(k_all.isChecked());
            }
        });

        m_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllWednesday(m_all.isChecked());
            }
        });

        j_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllThursday(j_all.isChecked());
            }
        });
        v_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllFriday(v_all.isChecked());
            }
        });

        s_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectAllSaturday(s_all.isChecked());
            }
        });

        /* OnClick Listener individual de toggles */

        // lunes
        for (int i = 0; i < TOGGLES_MONDAY.size(); i++) {
            ToggleButton temp = TOGGLES_MONDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_MONDAY);
                }
            });
        }

        // martes
        for (int i = 0; i < TOGGLES_TUESDAY.size(); i++) {
            ToggleButton temp = TOGGLES_TUESDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_TUESDAY);
                }
            });
        }

        // miércoles
        for (int i = 0; i < TOGGLES_WEDNESDAY.size(); i++) {
            ToggleButton temp = TOGGLES_WEDNESDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_WEDNESDAY);
                }
            });
        }

        // jueves
        for (int i = 0; i < TOGGLES_THURSDAY.size(); i++) {
            ToggleButton temp = TOGGLES_THURSDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_THURSDAY);
                }
            });
        }

        // viernes
        for (int i = 0; i < TOGGLES_FRIDAY.size(); i++) {
            ToggleButton temp = TOGGLES_FRIDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_FRIDAY);
                }
            });
        }

        // sábado
        for (int i = 0; i < TOGGLES_SATURDAY.size(); i++) {
            ToggleButton temp = TOGGLES_SATURDAY.get(i);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateAvailabilities(INDEX_SATURDAY);
                }
            });
        }



    }

    public void selectAllMonday(Boolean state) {
        for (int i = 0; i < TOGGLES_MONDAY.size(); i++) {
            ToggleButton temp = TOGGLES_MONDAY.get(i);
            temp.setChecked(state);
        }
    }

    public void selectAllTuesday(Boolean state) {
        for (int i = 0; i < TOGGLES_TUESDAY.size(); i++) {
            ToggleButton temp = TOGGLES_TUESDAY.get(i);
            temp.setChecked(state);
        }
    }

    public void selectAllWednesday(Boolean state) {
        for (int i = 0; i < TOGGLES_WEDNESDAY.size(); i++) {
            ToggleButton temp = TOGGLES_WEDNESDAY.get(i);
            temp.setChecked(state);
        }
    }

    public void selectAllThursday(Boolean state) {
        for (int i = 0; i < TOGGLES_THURSDAY.size(); i++) {
            ToggleButton temp = TOGGLES_THURSDAY.get(i);
            temp.setChecked(state);
        }
    }

    public void selectAllFriday(Boolean state) {
        for (int i = 0; i < TOGGLES_FRIDAY.size(); i++) {
            ToggleButton temp = TOGGLES_FRIDAY.get(i);
            temp.setChecked(state);
        }
    }

    public void selectAllSaturday(Boolean state) {
        for (int i = 0; i < TOGGLES_SATURDAY.size(); i++) {
            ToggleButton temp = TOGGLES_SATURDAY.get(i);
            temp.setChecked(state);
        }

    }

    public void setAvailabilities() {
        // Pair < Pair <inicio , fin> , día >
        for (int i = 0; i < courseAvailabilities.size(); i++) {
            Integer tempStart = courseAvailabilities.get(i).first.first;
            Integer tempEnd = courseAvailabilities.get(i).first.second;

            // Si es lunes
            if (courseAvailabilities.get(i).second == INDEX_MONDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_MONDAY.get(j - 7).setChecked(true);
                }
            }
            // Si es martes
            if (courseAvailabilities.get(i).second == INDEX_TUESDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_TUESDAY.get(j - 7).setChecked(true);
                }
            }
            // Si es miércoles
            if (courseAvailabilities.get(i).second == INDEX_WEDNESDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_WEDNESDAY.get(j - 7).setChecked(true);
                }
            }
            // Si es jueves
            if (courseAvailabilities.get(i).second == INDEX_THURSDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_THURSDAY.get(j - 7).setChecked(true);
                }
            }
            // Si es viernes
            if (courseAvailabilities.get(i).second == INDEX_FRIDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_FRIDAY.get(j - 7).setChecked(true);
                }
            }
            // Si es sábado
            if (courseAvailabilities.get(i).second == INDEX_SATURDAY) {
                for (int j = tempStart; j <= tempEnd; j++) {
                    TOGGLES_SATURDAY.get(j - 7).setChecked(true);
                }
            }
        }
    }

    public void updateAvailabilities(Integer day) {
        Integer start = 0, end = 0;
        ToggleButton temp;
        Boolean flag = false;

        if (day == INDEX_MONDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_MONDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_MONDAY.size(); i++) {
                    temp = TOGGLES_MONDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_MONDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_MONDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_MONDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        } else if (day == INDEX_TUESDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_TUESDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_TUESDAY.size(); i++) {
                    temp = TOGGLES_TUESDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_TUESDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_TUESDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_TUESDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        } else if (day == INDEX_WEDNESDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_WEDNESDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_WEDNESDAY.size(); i++) {
                    temp = TOGGLES_WEDNESDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_WEDNESDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_WEDNESDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_WEDNESDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        } else if (day == INDEX_THURSDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_THURSDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_THURSDAY.size(); i++) {
                    temp = TOGGLES_THURSDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_THURSDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_THURSDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_THURSDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        } else if (day == INDEX_FRIDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_FRIDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_FRIDAY.size(); i++) {
                    temp = TOGGLES_FRIDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_FRIDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_FRIDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_FRIDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        } else if (day == INDEX_SATURDAY) {
            if (l_all.isChecked()) {
                session.updateAvailability(INDEX_SATURDAY, 7, 21);
            } else {
                for (int i = 0; i < TOGGLES_SATURDAY.size(); i++) {
                    temp = TOGGLES_SATURDAY.get(i);

                    if (temp.isChecked()) {
                        if (!flag) {
                            start = i + 7;
                            flag = true;
                        }

                        end = i + 7;

                        if (i == TOGGLES_SATURDAY.size() - 1) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_SATURDAY, start, end);
                        }

                    } else {
                        if (flag) {
                            //System.out.println("Start: " + start + " End: " + end );
                            session.updateAvailability(INDEX_SATURDAY, start, end);
                            flag = false;
                        }
                    }
                }
            }
        }

    }

}
