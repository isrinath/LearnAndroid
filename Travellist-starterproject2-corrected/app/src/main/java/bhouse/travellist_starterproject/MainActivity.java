package bhouse.travellist_starterproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class MainActivity extends Activity {

  private Menu menu;
  private boolean isListView;
  private RecyclerView cardRecyclerView;
  private StaggeredGridLayoutManager staggeredGridLayoutManager;
  private ArrayList<Place> placeArrayList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    cardRecyclerView = (RecyclerView) findViewById(R.id.cardRecycleList);
    staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
    cardRecyclerView.setLayoutManager(staggeredGridLayoutManager);
    placeArrayList = PlaceData.placeList();
    TravelListAdaptor travelListAdaptor = new TravelListAdaptor(this,placeArrayList);
    travelListAdaptor.setItemClickListenerRecycler(new ItemClickListenerRecycler(){

      @Override
      public void onClickRecycle(View view, int position) {
        Log.d("SRINATH","onClickRecycle");
        String selectedPlace = placeArrayList.get(position).name;
          Toast.makeText(getApplicationContext(), "You selected --->"+selectedPlace, Toast.LENGTH_LONG).show();

      }
    });
    cardRecyclerView.setAdapter(travelListAdaptor);

    isListView = true;
  }

  private void setUpActionBar() {

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    this.menu = menu;
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_toggle) {
      toggle();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void toggle() {
    MenuItem item = menu.findItem(R.id.action_toggle);
    if (isListView) {
      item.setIcon(R.drawable.ic_action_list);
      item.setTitle("Show as list");
      isListView = false;
      staggeredGridLayoutManager.setSpanCount(2);
    } else {
      item.setIcon(R.drawable.ic_action_grid);
      item.setTitle("Show as grid");
      isListView = true;
         staggeredGridLayoutManager.setSpanCount(1);
    }
  }
}
