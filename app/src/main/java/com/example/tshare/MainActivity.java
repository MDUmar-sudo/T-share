package com.example.tshare;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    androidx.appcompat.widget.Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transparentStatusBarAndNavigation();

        drawerLayout=findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setLogo(R.drawable.t_share_logo_2);



        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
//        navigationView.setItemIconTintList(null);



//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                item.setChecked(true);
//                switch(id){
//                    case R.id.nav_about:
//                        replaceFragments(new AboutFragment());
////                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.nav_help:
//                        replaceFragments(new Help_feedback_Fragment());
////                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.nav_policy:
//                        replaceFragments(new PrivacyPolicyFragment());
////                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                }
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //getMenuInflater().inflate(R.menu.nav_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
//        item.setChecked(true);

        if(id== R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
//                drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        else
        if(id==R.id.nav_help) {
            Intent intent_1 = new Intent(MainActivity.this, Help_Feedback.class);
            startActivity(intent_1);
//                drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        else
        if(id== R.id.nav_policy) {
            Intent intent_2 = new Intent(MainActivity.this, Privacy_Policy.class);
            startActivity(intent_2);
//                drawerLayout.closeDrawer(GravityCompat.START);
        }
        else return true;


        return super.onOptionsItemSelected(item);
    }
// Method to replace different fragment when anyone of the menu item's are clicked
//    private void replaceFragments(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.framelayout,fragment);
//        fragmentTransaction.commit();
//    }
    // Function to make status bar transparent
    private void transparentStatusBarAndNavigation(){
        if(Build.VERSION.SDK_INT>=19 || Build.VERSION.SDK_INT<21) {

            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
        }
        if(Build.VERSION.SDK_INT>=19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View. SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }
        //make fully transparent status bar
        if(Build.VERSION.SDK_INT>=21){
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);


        }

    }
    private  void setWindowFlag(int i, boolean b){
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (b){
            winParams.flags |= i;
        }else{
            winParams.flags &= ~i;
        }
        win.setAttributes(winParams);
    }
}