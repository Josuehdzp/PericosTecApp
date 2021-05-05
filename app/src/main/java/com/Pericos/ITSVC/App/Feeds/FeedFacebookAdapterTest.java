package com.Pericos.ITSVC.App.Feeds;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.Pericos.ITSVC.App.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class FeedFacebookAdapterTest extends RecyclerView.Adapter<FeedFacebookAdapterTest.ViewHolder> {


    public static final String CREATED_TIME = "created";
    public static final String FULL_PICTURE = "full";
    public static final String STATUS_TYPE = "status";
    public static final String STORY = "story";
    public static final String PERMALINK_URL = "permalink";
    public static final String MESSAGE = "message";
    public static final String DESCRIPTION = "description";


    private List<FeedFacebookListTest> facebookListTests;

    private Context context;

    public FeedFacebookAdapterTest(
            List<FeedFacebookListTest> developersLists,
            Context context) {


        this.facebookListTests = developersLists;
        this.context = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_avisos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final FeedFacebookListTest feedItem = facebookListTests.get(position);



        holder.cardFeedPrincipal.setAnimation(AnimationUtils.loadAnimation(context,R.anim.activity_open_enter));
        holder.tv_full_picture.setAnimation(AnimationUtils.loadAnimation(context,R.anim.slide_left_in));

        holder.getTv_created_time().setText(feedItem.getCreated_time());
        holder.getTv_permalink_url().setText(feedItem.getPermalink_url());
        holder.getTv_status_type().setText(feedItem.getStatus_type());
        //holder.getTv_message().setText(feedItem.getMessage());

        if (feedItem.getStory()!=null){
            holder.getTv_story().setVisibility(View.VISIBLE);
            holder.getTv_story().setText(feedItem.getStory());
        } else {
            holder.getTv_story().setVisibility(View.GONE);
        }

        if (feedItem.getMessage()!=null){
            holder.getTv_message().setVisibility(View.VISIBLE);
            holder.getTv_message().setText(feedItem.getMessage());

        } else {
            holder.getTv_message().setVisibility(View.GONE);

        }

        if (feedItem.getDescription()!=null){
            holder.getTv_description().setVisibility(View.VISIBLE);
            holder.getTv_description().setText(feedItem.getDescription());

        } else {
            holder.getTv_description().setVisibility(View.GONE);

        }


        if (feedItem.getFull_picture()!=null){
            holder.getTv_full_picture().setVisibility(View.VISIBLE);
            Glide.with(holder.getTv_full_picture().getContext())
                    .load(feedItem.getFull_picture())
                    .apply(new RequestOptions().fitCenter()) //Arregla el out of memory
                    .into(holder.getTv_full_picture());
        }else{
            Glide.with(holder.getTv_full_picture().getContext())
                    .load(feedItem.getFull_picture())
                    .apply(new RequestOptions().fitCenter())//Arregla el out of memory
                    .into(holder.getTv_full_picture());
        }


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedFacebookListTest facebookList = facebookListTests.get(position);
                Intent skipIntent = new Intent(v.getContext(), FeedClickActivity.class);

                skipIntent.putExtra(CREATED_TIME, facebookList.getCreated_time());
                skipIntent.putExtra(PERMALINK_URL, facebookList.getPermalink_url());
                skipIntent.putExtra(STATUS_TYPE, facebookList.getStatus_type());
                skipIntent.putExtra(STORY, facebookList.getStory());
                skipIntent.putExtra(MESSAGE,facebookList.getMessage());
                skipIntent.putExtra(DESCRIPTION,facebookList.getDescription());
                skipIntent.putExtra(FULL_PICTURE, facebookList.getFull_picture());

                v.getContext().startActivity(skipIntent);
            }
        });

        holder.tv_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedFacebookListTest facebookList = facebookListTests.get(position);
                Intent skipIntent = new Intent(v.getContext(), FeedClickActivity.class);

                skipIntent.putExtra(CREATED_TIME, facebookList.getCreated_time());
                skipIntent.putExtra(PERMALINK_URL, facebookList.getPermalink_url());
                skipIntent.putExtra(STATUS_TYPE, facebookList.getStatus_type());
                skipIntent.putExtra(STORY, facebookList.getStory());
                skipIntent.putExtra(MESSAGE,facebookList.getMessage());
                skipIntent.putExtra(DESCRIPTION,facebookList.getDescription());
                skipIntent.putExtra(FULL_PICTURE, facebookList.getFull_picture());

                v.getContext().startActivity(skipIntent);
            }
        });

        holder.tv_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedFacebookListTest facebookList = facebookListTests.get(position);
                Intent skipIntent = new Intent(v.getContext(), FeedClickActivity.class);

                skipIntent.putExtra(CREATED_TIME, facebookList.getCreated_time());
                skipIntent.putExtra(PERMALINK_URL, facebookList.getPermalink_url());
                skipIntent.putExtra(STATUS_TYPE, facebookList.getStatus_type());
                skipIntent.putExtra(STORY, facebookList.getStory());
                skipIntent.putExtra(MESSAGE,facebookList.getMessage());
                skipIntent.putExtra(DESCRIPTION,facebookList.getDescription());
                skipIntent.putExtra(FULL_PICTURE, facebookList.getFull_picture());

                v.getContext().startActivity(skipIntent);
            }
        });

/*
        holder.verEnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = feedItem.getPermalink_url();
                Intent verEnFacebook = new Intent(Intent.ACTION_VIEW);
                verEnFacebook.setData(Uri.parse(url));
                v.getContext().startActivity(verEnFacebook);
            }
        });
*/
    }

    @Override

    public int getItemCount() {
        return facebookListTests.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {


        public TextView tv_created_time;
        public ImageView tv_full_picture;
        public TextView tv_permalink_url;
        public TextView tv_status_type;
        public TextView tv_message;
        public TextView tv_description;
        public TextView tv_story;
        public LinearLayout linearLayout;
        public RelativeLayout cardFeedPrincipal;
        public CardView verEnFacebook;

        public ViewHolder(View itemView) {
            super(itemView);

            // inicializar los View objects

            tv_created_time =  itemView.findViewById(R.id.idAvisosFecha);
            tv_full_picture =  itemView.findViewById(R.id.idAvisosImagenFull);
            tv_permalink_url =  itemView.findViewById(R.id.idAvisosLink);
            tv_status_type =  itemView.findViewById(R.id.idAvisosEstado);
            tv_message =  itemView.findViewById(R.id.idAvisosMensaje);
            tv_description = itemView.findViewById(R.id.idAvisosDescription);
            tv_story =  itemView.findViewById(R.id.idAvisosHistoria);
            cardFeedPrincipal = itemView.findViewById(R.id.idAvisosCardContenedor);
            //verEnFacebook = itemView.findViewById(R.id.idFeedVerFacebook);

            linearLayout =  itemView.findViewById(R.id.idAvisosLinearPrincipal);


            cardFeedPrincipal.setBackgroundColor(itemView.getResources().getColor(R.color.trans));
            tv_message.setMovementMethod(LinkMovementMethod.getInstance());
            tv_description.setMovementMethod(LinkMovementMethod.getInstance());
        }

        public TextView getTv_created_time() {
            return tv_created_time;
        }

        public void setTv_created_time(TextView tv_created_time) {
            this.tv_created_time = tv_created_time;
        }

        public ImageView getTv_full_picture() {
            return tv_full_picture;
        }

        public void setTv_full_picture(ImageView tv_full_picture) {
            this.tv_full_picture = tv_full_picture;
        }

        public TextView getTv_permalink_url() {
            return tv_permalink_url;
        }

        public void setTv_permalink_url(TextView tv_permalink_url) {
            this.tv_permalink_url = tv_permalink_url;
        }

        public TextView getTv_status_type() {
            return tv_status_type;
        }

        public void setTv_status_type(TextView tv_status_type) {
            this.tv_status_type = tv_status_type;
        }

        public TextView getTv_message() {
            return tv_message;
        }

        public void setTv_message(TextView tv_message) {
            this.tv_message = tv_message;
        }

        public TextView getTv_description() {
            return tv_description;
        }

        public void setTv_description(TextView tv_description) {
            this.tv_description = tv_description;
        }

        public TextView getTv_story() {
            return tv_story;
        }

        public void setTv_story(TextView tv_story) {
            this.tv_story = tv_story;
        }
    }
}
