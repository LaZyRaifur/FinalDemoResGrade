package com.example.raifur.foodgradingsystem.CircleMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.raifur.foodgradingsystem.R;

public class LocationCatagory extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ListView myList;
    ArrayAdapter<String>DistrictArray,AreaArray;
    Spinner DistrictSpinner,AreaSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_catagory);

        initial();
    }

    private void initial() {
        DistrictSpinner = findViewById(R.id.spinnerDistrict);
        DistrictSpinner.setOnItemSelectedListener(this);

        DistrictArray = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        DistrictArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DistrictSpinner.setAdapter(DistrictArray);

        //parent Spinner
        DistrictArray.add("Dhaka");
        DistrictArray.add("Gazipur");
        DistrictArray.add("Manikganj");
        DistrictArray.add("Munshiganj");
        DistrictArray.add("Narsingdi");
        DistrictArray.add("Tangail");
        DistrictArray.add("Kishoreganj");
        DistrictArray.add("Faridpur");
        DistrictArray.add("Gopalganj");
        DistrictArray.add("Rajbari");
        DistrictArray.add("Shariatpur");
        DistrictArray.setNotifyOnChange(true);

        DistrictSpinner.setSelection(0);

        AreaSpinner = findViewById(R.id.spinnerArea);
        AreaSpinner.setOnItemSelectedListener(this);

        AreaArray = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        AreaArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AreaSpinner.setAdapter(AreaArray);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int DistrictPosition = DistrictSpinner.getSelectedItemPosition();
        switch (DistrictPosition){
            case 0 :
                fillDhaka();
                break;
            case 1:
                fillGazipur();
                break;
            case 2:
                fillManikganj();
                break;
            case 3:
                fillMunshiganj();
                break;
            case 4:
                fillNarsingdi();
                break;
            case 5:
                fillTangail();
                break;
            case 6: 
                fillKishorganj();
                break;
            case 7:
                fillFraidpur();
                break;
            case 8:
                fillGopalganj();
                break;
            case 9:
                fillRajbari();
                break;
            case 10:
                fillShariatpur();
                break;


        }
    }

    private void fillKishorganj() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillGopalganj() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillRajbari() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillShariatpur() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillFraidpur() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillTangail() {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillNarsingdi()
    {
        AreaArray.clear();

        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillMunshiganj() {
        AreaArray.clear();
        AreaArray.add("Demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.add("demo");
        AreaArray.notifyDataSetChanged();
    }

    private void fillManikganj() {
        AreaArray.clear();
        AreaArray.add("Rajibpur");
        AreaArray.add("Krishnapur");
        AreaArray.add("Mokimpur");
        AreaArray.add("Gazipara");
        AreaArray.add("Barahirchar");
        AreaArray.add("Barai vikora");
        AreaArray.add("Guzuri");
        AreaArray.add("Motto");
        AreaArray.add("Diyara vabanipur");
        AreaArray.add("katikgram");
        AreaArray.add("Terodona");
        AreaArray.notifyDataSetChanged();
    }

    private void fillGazipur() {
        AreaArray.clear();
        AreaArray.add("Gazipur Sadar");
        AreaArray.add("Kaliakar");
        AreaArray.add("Kapasia");
        AreaArray.add("Sreepur");
        AreaArray.add("Kaliganj");
        AreaArray.add("Gazipur City Corporation");

        AreaArray.notifyDataSetChanged();
    }

    private void fillDhaka() {
        AreaArray.clear();
        AreaArray.add("Dhanmondi");
        AreaArray.add("Motijheel");
        AreaArray.add("Gulshan");
        AreaArray.add("Banani");
        AreaArray.add("Wari");
        AreaArray.add("Bongshal");
        AreaArray.add("Shahbagh");
        AreaArray.add("Samoli");
        AreaArray.add("Mirpur");
        AreaArray.add("Savar");
        AreaArray.add("Keranigonj");
        AreaArray.add("Narayangonj");
        AreaArray.add("Jatrabari");

        AreaArray.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
