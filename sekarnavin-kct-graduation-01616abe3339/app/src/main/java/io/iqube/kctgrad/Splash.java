package io.iqube.kctgrad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by sanjaypradeep on 09-09-2016.
 */
public class Splash extends Activity {

    ImageView img;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashh);

        img = (ImageView)findViewById(R.id.ani);
        //img1 = (ImageView)findViewById(R.id.ani1);
        //img2 = (ImageView)findViewById(R.id.anime);
        //img3 = (ImageView)findViewById(R.id.anima);
        animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);

        img.startAnimation(animation);
      //  img1.startAnimation(animation);
      //  img2.startAnimation(animation);
       // img3.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    finish();
                Intent i =new Intent(Splash.this,DrawerActivity.class);
                startActivity(i);

                }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }


        });
}
    }
