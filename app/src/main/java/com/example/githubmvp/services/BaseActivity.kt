package com.example.githubmvp.services

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.githubmvp.GithubApplication
import com.example.githubmvp.R

/**
 * Created by Federico Torres on 19/6/2017.
 */


import com.example.githubmvp.dagger.ApplicationComponent


open class BaseActivity : AppCompatActivity() {

    private val TAG = "BaseActivity"

    private var progressDialog: ProgressDialog? = null
    lateinit  var component : ApplicationComponent


    public override fun onResume() {
        super.onResume()
    }

    public override fun onStop() {
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component =  (application as GithubApplication).component
    }



    fun showProgressDialog(message: String) {
        progressDialog = ProgressDialog.show(this, getString(R.string.app_name), message)
    }


    open fun showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this,
                    getString(R.string.app_name), "Cargando")
        }
        progressDialog?.show()
    }

    fun dismissProgressDialog() {
            progressDialog?.dismiss()

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }



    open fun showAlert(heading: String, body: String) {
        // Instantiate an AlertDialog.Builder with its constructor
        val builder = AlertDialog.Builder(this)

        // Chain together various setter methods to set the dialog characteristics
        builder.setMessage(body)
                .setTitle(heading)

        // Get the AlertDialog from create() and then show() it
        val dialog = builder.create()
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok") { dialog, _ -> dialog.dismiss() }

        dialog.show()
    }


    protected fun showDialogMessage(stringMessage: Int, context: Context?,
                                    clickListener: View.OnClickListener?) {
        if (context == null) {
            return
        }
        val builder = AlertDialog.Builder(context)
        builder.setMessage(stringMessage)
                .setTitle(R.string.app_name)
                .setCancelable(false)
                .setNeutralButton("Ok"
                ) { dialog, id ->
                    if (clickListener != null) {
                        clickListener.onClick(null)

                    } else {
                        dialog.cancel()
                    }
                }
        val alert = builder.create()
        alert.show()
    }


    fun showDialog(message: String, context: Context?,
                   clickListener: DialogInterface.OnClickListener?) {
        if (context == null) {
            return
        }
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
                .setTitle(R.string.app_name)
                .setCancelable(false)
                .setNeutralButton("Ok"
                ) { dialog, id ->
                    if (clickListener != null) {
                        clickListener.onClick(dialog, id)

                    } else {
                        dialog.cancel()
                    }
                }
        val alert = builder.create()
        alert.show()
    }

    fun showDialog(message: String, context: Context?,
                   okListener: DialogInterface.OnClickListener, negativeListener: DialogInterface.OnClickListener) {
        if (context == null) {
            return
        }
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
                .setTitle(R.string.app_name)
                .setCancelable(false)
                .setNeutralButton("Ok"
                ) { dialog, id -> okListener.onClick(dialog, id) }
                .setNegativeButton("No", negativeListener)

        val alert = builder.create()
        alert.show()
    }




}



