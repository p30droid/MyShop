package com.androidlearn.digishop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.androidlearn.digishop.config.AppConfig
import com.androidlearn.digishop.databinding.ActivityMainBinding
import com.androidlearn.digishop.di.*
import com.androidlearn.digishop.ui.login.LoginActivity
import com.androidlearn.digishop.ui.main.adapter.TabsAdapter
import com.androidlearn.digishop.ui.main.category.CategoryFragment
import com.androidlearn.digishop.ui.main.home.HomeFragment
import com.androidlearn.digishop.ui.main.userProfile.UserProfileFragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var  binding : ActivityMainBinding


    lateinit var auth: FirebaseAuth

    private var mInterstitialAd: InterstitialAd? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth


        val fragments: MutableList<Fragment> = ArrayList()
        fragments.add(HomeFragment())
        fragments.add(CategoryFragment())
        fragments.add(UserProfileFragment())

        binding.pager.adapter = TabsAdapter(this@MainActivity, fragments)


        binding.imgLogin.setOnClickListener {

        //    throw RuntimeException("Test Crash") // Force a crash

            val intent = Intent(applicationContext , LoginActivity::class.java)
         //   startActivity(intent)


            auth.createUserWithEmailAndPassword("hi@android-learn.ir","123@65#5!awsx00")
                .addOnCompleteListener(this){
                    Log.e("","");
                }

            auth.signInWithEmailAndPassword("hi@android-learn.ir","123@65#5!awsx00")
                .addOnCompleteListener(this) {

                }


        }

/*

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        binding.adView.adListener = object  : AdListener() {

            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }


        }
*/


        var adRequestInterstial = AdRequest.Builder().build()


        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequestInterstial, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("TAG", adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("TAG", "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })


        val contact : Contact = SimpleContact()
        val user = User(contact)

        val contact2 = ExtendedContact()
        val user2 = User(contact2)

        val component : UserComponent = DaggerUserComponent.builder()
            .userModule(UserModule()).build();

        component.provideUser().addContact("ALi Pirvand")
        Log.e("Name", component.provideUser().contact)





    }
}