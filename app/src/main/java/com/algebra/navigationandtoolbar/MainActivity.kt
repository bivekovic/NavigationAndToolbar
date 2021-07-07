package com.algebra.navigationandtoolbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        setSupportActionBar( findViewById( R.id.toolbar ) )
        supportActionBar?.setDisplayHomeAsUpEnabled( true )
    }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.main_menu, menu )
        return super.onCreateOptionsMenu( menu )
    }

    override fun onOptionsItemSelected( item: MenuItem ) = when ( item.itemId ) {
        R.id.acDevices -> {
            displayDialog( )
            Toast.makeText( this, "Devices", Toast.LENGTH_LONG ).show( )
            true
        }
        R.id.acLauncher -> {
            Toast.makeText( this, "Launcher", Toast.LENGTH_LONG ).show( )
            true
        }
        R.id.acLocation -> {
            Toast.makeText( this, "Location", Toast.LENGTH_LONG ).show( )
            true
        }
        R.id.acRowing -> {
            Toast.makeText( this, "Rowing", Toast.LENGTH_LONG ).show( )
            true
        }
        android.R.id.home -> {
            Toast.makeText( this, "Home action", Toast.LENGTH_LONG ).show( )
            true
        }
        else -> {
            super.onOptionsItemSelected( item )
        }
    }

    private fun displayDialog( ) {
        val builder = AlertDialog.Builder( this@MainActivity )
        builder.setTitle( "Set background color" )
        builder.setMessage( "Are you want to set the app background color to RED?" )
        builder.setPositiveButton( "YES" ) { dialog, which ->
            Toast.makeText( applicationContext, "Background changed", Toast.LENGTH_SHORT ).show( )
            findViewById< ConstraintLayout >( R.id.root )
                .setBackgroundColor( Color.RED )
        }

        builder.setNegativeButton( "No" ) { dialog, which ->
            Toast.makeText( applicationContext, "Declining action", Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton( "Cancel" ) { dialog, which ->
            Toast.makeText( applicationContext, "You cancelled the dialog.", Toast.LENGTH_SHORT ).show( )
        }

        val dialog: AlertDialog = builder.create( )
        dialog.show( )
    }

}
