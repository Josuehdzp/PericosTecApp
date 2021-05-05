package com.Pericos.ITSVC.App.Feeds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.Objects;


public class FeedClickActivity extends AppCompatActivity {

    public static final String FULL_PICTURE = "full";


    ImageView FullPictureHead;
    RelativeLayout contenedorCompleto;
    RelativeLayout contenedorHistoria;
    RelativeLayout Compartir;
    RelativeLayout VerFacebook;
    TextView CreatedTime;
    TextView StatusType;
    TextView Story;
    TextView Message;
    TextView Description;
    RoundedImageView FullpicturePrincipal;
    TextView PermalinkUrl;
    TextView TituloFeed;
    Toolbar feedCompletoToolbar;
    TextView textoToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_scrolling);

        feedCompletoToolbar = findViewById(R.id.idFeedScrollCompletoToolbar);
        textoToolbar = findViewById(R.id.idFeedScrollCompletoToolbarTexto);

        contenedorCompleto = findViewById(R.id.idFeedScrollCompletoCard);
        TituloFeed = findViewById(R.id.idFeedScrollCompletoTitulo);
        FullPictureHead =  findViewById(R.id.idFeedScrollCompletoFullpictureHeader);
        CreatedTime =  findViewById(R.id.idFeedScrollCompletoCreacion);
        StatusType = findViewById(R.id.idFeedScrollCompletoStatus);
        Story = findViewById(R.id.idFeedScrollCompletoStory);
        Message = findViewById(R.id.idFeedScrollCompletoMensaje);
        Description = findViewById(R.id.idFeedScrollCompletoDescripcion);
        Compartir =  findViewById(R.id.idFeedScrollCompletoCompartir);
        VerFacebook =  findViewById(R.id.idFeedScrollCompletoVerFacebook);
        PermalinkUrl =  findViewById(R.id.idFeedScrollCompletoPermalink);
        FullpicturePrincipal = findViewById(R.id.idFeedScrollCompletoFullpicture);
        contenedorHistoria = findViewById(R.id.idFeedScrollCompletoStoryContenedor);

        setSupportActionBar(feedCompletoToolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        final String creacion = intent.getStringExtra(FeedFacebookAdapterTest.CREATED_TIME);
        final String estado = intent.getStringExtra(FeedFacebookAdapterTest.STATUS_TYPE);
        final String historia = intent.getStringExtra(FeedFacebookAdapterTest.STORY);
        final String mensaje = intent.getStringExtra(FeedFacebookAdapterTest.MESSAGE);
        final String description = intent.getStringExtra(FeedFacebookAdapterTest.DESCRIPTION);
        final String image = intent.getStringExtra(FeedFacebookAdapterTest.FULL_PICTURE);
        final String link = intent.getStringExtra(FeedFacebookAdapterTest.PERMALINK_URL);

        if (historia.equals("")){
            contenedorHistoria.setVisibility(View.GONE);
        }

        contenedorCompleto.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_transition_animation_up));
        FullpicturePrincipal.setAnimation(AnimationUtils.loadAnimation(this,R.anim.activity_open_enter));
        FullPictureHead.setAnimation(AnimationUtils.loadAnimation(this,R.anim.activity_open_enter));

        if (mensaje!=null && description!=null){
            TituloFeed.setText(mensaje+description);

        }
        if (mensaje.isEmpty() && description!=null){
            TituloFeed.setText(description);
            Message.setVisibility(View.GONE);
        }
        if (description.isEmpty() && mensaje!=null){
            TituloFeed.setText(mensaje);
            Description.setVisibility(View.GONE);
        }
        if (mensaje.isEmpty() && description.isEmpty()){
            Message.setVisibility(View.GONE);
            Description.setVisibility(View.GONE);
        }

        TituloFeed.setSelected(true);
        //TituloFeed.setMovementMethod(new ScrollingMovementMethod());

        Glide.with(getApplicationContext())
                .load(image)
                .apply(new RequestOptions().fitCenter()) //Arregla el out of memory
                .into(FullPictureHead);

        Glide.with(getApplicationContext())
                .load(image)
                .apply(new RequestOptions().fitCenter()) //Arregla el out of memory
                .into(FullpicturePrincipal);

        CreatedTime.setText(creacion);
        StatusType.setText(estado);
        Story.setText(historia);
        Message.setText(mensaje);
        Message.setMovementMethod(LinkMovementMethod.getInstance());
        Description.setText(description);
        Description.setMovementMethod(LinkMovementMethod.getInstance());
        PermalinkUrl.setText(link);


        FullpicturePrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //Bundle cotiene los datos a mandar a el dialog
                bundle.putString("full_picture",image);


                DialogoFeeds dialog = new DialogoFeeds(); //Create a new Dialog
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "MY_DIALOG_TAG"); //Inflar el dialog
            }
        });

        VerFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = link;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        Compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey! dale un viztazo a esta publicacion: " + link);
                Intent chooser = Intent.createChooser(shareIntent, "Compartir via:");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });


    }
}
