package es.pue.android.listwithadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCountriesData();

        ListView lvCountry = (ListView)findViewById(R.id.country_list);
        CountryListAdapter adapter = new CountryListAdapter(this, R.layout.list_item, countries);
        lvCountry.setAdapter(adapter);
    }

    private void loadCountriesData() {
        countries = Arrays.asList(getResources().getStringArray(R.array.countries));
    }
}
