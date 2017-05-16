package com.remembook.kimryoji.remembook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.remembook.kimryoji.remembook.Adapter.BookDataAdapter;
import com.remembook.kimryoji.remembook.Adapter.MainPagerAdapter;
import com.remembook.kimryoji.remembook.Fragment.MainWriteFragment;
import com.remembook.kimryoji.remembook.Interface.BookDataContract;
import com.remembook.kimryoji.remembook.Model.BookDataModel;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;
import com.remembook.kimryoji.remembook.Presenter.BookInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity implements BookDataContract.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.etBookTitle)
    EditText etBookTitle;
    @BindView(R.id.btnRequestApi)
    Button btnRequestApi;
    @BindView(R.id.rvBookInfo)
    RecyclerView rvBookInfo;
    @BindView(R.id.ivToolbar)
    ImageView ivToolbar;
    @BindView(R.id.vpMain)
    ViewPager vpMain;
//    @BindView(R.id.tbMain)
//    NavigationTabBar tbMain;

    //BookData
    private BookInfoPresenter presenter;
    private BookDataAdapter dataAdapter;
    private GridLayoutManager gridManager;
    //Menu
    private MainPagerAdapter pagerAdapter;

    //Menu


    /**Test**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //RecyclerView
        presenter = new BookInfoPresenter();
        presenter.attachView(this);

        dataAdapter = new BookDataAdapter(this);
        rvBookInfo.setAdapter(dataAdapter);

        presenter.setBookDataAdapterModel(dataAdapter);
        presenter.setBookDataAdapterView(dataAdapter);
        presenter.setBookDataModel(BookDataModel.getInstance());

        gridManager = new GridLayoutManager(this,2);
        rvBookInfo.setLayoutManager(gridManager);

        //ViewPager
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(pagerAdapter);


//        tbMain.setViewPager(vpMain);

//        //Navigation Tab
//        tbMain.setBehaviorEnabled(true);


        //Button Event
        btnRequestApi.setOnClickListener(view ->
            presenter.loadItems(this,etBookTitle.getText().toString(),"date",1,false)
        );

        //Fab Event
        fab.setOnClickListener(view -> {
            presenter.loadItems(this,etBookTitle.getText().toString(),"accu",1,true);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void addFragment(BookRepo.Channel.BookItems items) {
        setFragmentManager(new MainWriteFragment().newInstance(items));
    }

    private void setFragmentManager(Fragment fragment){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.add(R.id.content_main,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

}
