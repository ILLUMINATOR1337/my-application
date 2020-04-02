package daniil.zagirov.top100currencies.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import daniil.zagirov.top100currencies.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //Устанавливаем стрелку возврата в тулбаре
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Кнопка для рейтинга приложения(Открывает страницу приложения в маркете)
        buttonRateApp.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${applicationContext.packageName}")))
        }

        //Инициализируем баннер
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
}
