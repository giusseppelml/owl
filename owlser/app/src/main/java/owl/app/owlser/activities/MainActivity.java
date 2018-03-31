package owl.app.owlser.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import owl.app.owlser.R;
import owl.app.owlser.fragments.PrincipalFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawableLayout;
    private NavigationView navigationView;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaciones();
        setToolbar();
        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTramsaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.menu_mail:
                        Toast.makeText(MainActivity.this, "contactanos", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_alert:
                        Toast.makeText(MainActivity.this, "alerta", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_info:
                        Toast.makeText(MainActivity.this, "información", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_opcion_1:
                        Toast.makeText(MainActivity.this, "opción 1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_opcion_2:
                        Toast.makeText(MainActivity.this, "opción 2", Toast.LENGTH_LONG).show();
                        break;
                }

                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                if (fragmentTramsaction) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            //la linea de abajo es para poder volver al fragment
                            .addToBackStack(null)
                            .commit();
                    //item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawableLayout.closeDrawers();
                }

                return true;
            }
        });
    }

    private void inicializaciones(){
        drawableLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar() {
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_grid);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new PrincipalFragment())
                .commit();

        MenuItem item = navigationView.getMenu().getItem(0);
        getSupportActionBar().setTitle("OWL");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawableLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}