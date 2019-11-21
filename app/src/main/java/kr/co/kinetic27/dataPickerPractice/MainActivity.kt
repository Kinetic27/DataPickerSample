package kr.co.kinetic27.dataPickerPractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener {

            // 데이터 피커 띄우기
            with(Calendar.getInstance()) {
                DatePickerDialog.newInstance(
                    this@MainActivity,
                    get(Calendar.YEAR), // Initial year selection
                    get(Calendar.MONTH), // Initial month selection
                    get(Calendar.DAY_OF_MONTH) // Inital day selection
                ).apply {
                    version = DatePickerDialog.Version.VERSION_2
                    //옵션은 여기에

                    setOnCancelListener {
                        Snackbar.make(findViewById(android.R.id.content), "취소 선택됨!!", Snackbar.LENGTH_LONG).show()
                    }

                    show(supportFragmentManager, "Datepickerdialog")
                }
            }
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    // 얘가 데이터 골랐을 때 작동되는 리스너
    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val date = "$year / ${monthOfYear + 1} / $dayOfMonth"

        Snackbar.make(findViewById(android.R.id.content), "$date 선택됨!!", Snackbar.LENGTH_LONG).show()
    }

    // 이 뒤로 기본 생성 코드

    override fun onBackPressed() = when {
        drawer_layout.isDrawerOpen(GravityCompat.START) -> drawer_layout.closeDrawer(GravityCompat.START)
        else -> super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }
}
