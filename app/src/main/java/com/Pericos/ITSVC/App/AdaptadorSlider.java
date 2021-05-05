package com.Pericos.ITSVC.App;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Pericos.ITSVC.App.Feeds.DialogoFeeds;
import com.Pericos.ITSVC.App.Notas.DialogoNotas;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class AdaptadorSlider extends SliderViewAdapter<AdaptadorSlider.AdaptadorSliderVH> {

    private Context gContexto;
    public int gCuenta;

    public AdaptadorSlider(Context context){
        this.gContexto = context;
    }

    public void setCuenta(int cuenta){
        this.gCuenta= cuenta;
    }

    @Override
    public AdaptadorSliderVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_items, null);
        return new AdaptadorSliderVH(inflate);
    }

    @Override
    public void onBindViewHolder(AdaptadorSliderVH viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //La posicion la cambie a final int OJO
                //Toast.makeText(gContexto, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });


        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText("");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sliderregresoaclasesfiltro)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                viewHolder.textViewDescription.setText("Tecnologicos de México ");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.tecnologicosdemexico)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            /*case 2:
                viewHolder.textViewDescription.setText(R.string.titulo_sistemas);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.slidersistemas)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;*/
            case 2:
                viewHolder.textViewDescription.setText(R.string.titulo_sistemas);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.promo_isic)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            /*case 4:
                viewHolder.textViewDescription.setText(R.string.titulo_alimentarias);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.slideralimentarias)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;*/
            case 3:
                viewHolder.textViewDescription.setText(R.string.titulo_alimentarias);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.promo_iial)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            /*case 6:
                viewHolder.textViewDescription.setText(R.string.titulo_forestal);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sliderforestal)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;*/
            case 4:
                viewHolder.textViewDescription.setText(R.string.titulo_forestal);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.promo_ifor)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            /*case 8:
                viewHolder.textViewDescription.setText(R.string.titulo_geociencias);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.slidergeociencias)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;*/
            case 5:
                viewHolder.textViewDescription.setText(R.string.titulo_geociencias);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.promo_igeo)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            /*case 10:
                viewHolder.textViewDescription.setText(R.string.titulo_gestion);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.slidergestion)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;*/
            case 6:
                viewHolder.textViewDescription.setText(R.string.titulo_gestion);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.promo_igem)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;

            default:
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setText(R.string.titulo_gestion);
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.pericocontituloyfondo2sombra)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.pericocontituloyfondo2sombra)
                        .into(viewHolder.imageGifContainer);
                break;

        }
    }

    @Override
    public int getCount() {
        return gCuenta;
    }

    public class AdaptadorSliderVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public AdaptadorSliderVH(View itemView) {
            super(itemView);

            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }

    }
}
