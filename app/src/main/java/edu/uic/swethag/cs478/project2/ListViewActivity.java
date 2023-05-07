package edu.uic.swethag.cs478.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        String[][] carDealerNames = {
                {"McGrath City Mazda", "The Autobarn Mazda of Evanston"},
                {"Metro Ford Sales & Service, Inc", "Fox Ford of Chicago"},
                {"Zeigler Ford of North Riverside", "Midway Incorporated II - Dodge"},
                {"Napleton Downtown Chevrolet", "Mike Anderson Chevrolet of Chicago, LLC"},
                {"Marino Chrysler Jeep Dodge Ram", "South Chicago Dodge Chrysler Jeep"},
                {"Napleton Downtown Buick GMC", "Napleton Downtown Chicago"},
                {"Zeigler Cadillac of Lincolnwood", "Ettleson Cadillac"},
                {"Tesla", "Tesla"}
        };
        String[][] carDealerAddresses = {
                {"6722 W Grand Ave, Chicago, IL 60707", "1015 Chicago Ave, Evanston, IL 60202"},
                {"6455 S Western Ave, Chicago, IL 60636", "2501 N Elston Ave, Chicago, IL 60647"},
                {"2100 S Harlem Ave, North Riverside, IL 60546", "4747 S Pulaski Rd, Chicago, IL 60632"},
                {"2720 S Michigan Ave, Chicago, IL 60616", "5333 IL-19, Chicago, IL 60641"},
                {"5133 W Irving Park Rd, Chicago, IL 60641", "7340 S Western Ave, Chicago, IL 60636"},
                {"2720 S Michigan Ave, Chicago, IL 60616", "2720 S Michigan Ave, Chicago, IL 60616"},
                {"7373 N Cicero Ave, Lincolnwood, IL 60712", "6201 South La Grange Road, Hodgkins, IL 60525"},
                {"1053 W Grand Ave, Chicago, IL 60642", "901 N Rush St, Chicago, IL 60611"}
        };

        // Create a new Adapter containing car dealer's names and their address
        // Set the adapter on this ListView
        Intent intent = getIntent();
        final int pos = intent.getIntExtra(MainActivity.IMAGE_POS, 0);

        ListView lv = (ListView) findViewById(R.id.dealer_list);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, carDealerNames[pos], carDealerAddresses[pos]);
        lv.setAdapter(listViewAdapter);
    }
}