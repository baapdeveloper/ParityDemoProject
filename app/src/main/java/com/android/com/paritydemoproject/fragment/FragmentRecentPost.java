package com.android.com.paritydemoproject.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.com.paritydemoproject.AppController;
import com.android.com.paritydemoproject.DetailActivity;
import com.android.com.paritydemoproject.R;
import com.android.com.paritydemoproject.ScreenActivity;
import com.android.com.paritydemoproject.Util.ApiRepository;
import com.android.com.paritydemoproject.jsonrequest.SimpleStringRequest;
import com.android.com.paritydemoproject.model.Data;
import com.android.com.paritydemoproject.model.RecentPostModel;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecentPost extends Fragment {
    View view;
    RecyclerView rvScreen;
    RecentPostModel modelPost;
    ImageLoader imgLoader;
    Context mContext;
    ScreenPagerAdapter screenAdapter;
    Gson gson;
    DisplayImageOptions mImageOptions;
    ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public FragmentRecentPost() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            // Inflate the layout for this fragment
            view = inflater.inflate(R.layout.fragment_fragment_recent_post, container, false);
            initView();
            downloadData();

        }
        return view;

    }

    private void downloadData() {
        if (AppController.flagNetworkStatus) {
            SimpleStringRequest request = new SimpleStringRequest(ApiRepository.FETCH_RECENT_POST_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    if (!TextUtils.isEmpty(s)) {
                        try {
                            modelPost = gson.fromJson(s, RecentPostModel.class);
                            screenAdapter.setData();
                            screenAdapter.notifyDataSetChanged();
                        } catch (JsonParseException e) {
                            return;
                        }

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(mContext, "Something went through", Toast.LENGTH_SHORT).show();
                }
            }, mContext);
            AppController.getInstance().getRequestQueue().add(request);

        } else {
            Snackbar snackbar = Snackbar
                    .make(((ScreenActivity) mContext).clMain, "Internet Connection Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("TRY AGAIN", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            downloadData();
                        }
                    });

            snackbar.show();
        }
    }

    private void initView() {
        rvScreen = (RecyclerView) view.findViewById(R.id.rv_screen);
        modelPost = new RecentPostModel();
        gson = new Gson();
        mImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.placeholder)
                .showImageForEmptyUri(R.drawable.placeholder)
                .showImageOnFail(R.drawable.placeholder)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .displayer(new SimpleBitmapDisplayer())
                .build();
        //
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(mContext));
        screenAdapter = new ScreenPagerAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvScreen.setLayoutManager(mLayoutManager);
        rvScreen.setAdapter(screenAdapter);

    }

    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }


    class ScreenPagerAdapter extends RecyclerView.Adapter<ScreenPagerAdapter.MyViewHolder> {
        private Data[] data;

        ScreenPagerAdapter() {
            data = modelPost.getData();
        }

        private void setData() {
            data = modelPost.getData();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_screen_list, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.tvUserName.setText(data[position].getUser().getName());
            holder.tvKarmaCount.setText(data[position].getUser().getKarma() + " Karma");
            holder.tvTitle1.setText(data[position].getTopic().getTitle());
            holder.tvDesription.setText(Html.fromHtml(data[position].getForum().getDescription()));
            holder.tvDimerLiked.setText(data[position].getUser().getCurrent_dimes() + " Dimer Liked");
            imgLoader.displayImage(data[position].getUser().getImage(), holder.civImage, mImageOptions, animateFirstListener);
            holder.tvTitle2.setText(data[position].getTopic().getForum_name());
            holder.tvTitle2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (data == null) return 0;
            return data.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle1, tvTitle2, tvDesription, tvUserName, tvKarmaCount, tvDimerLiked;
            CircleImageView civImage;

            public MyViewHolder(View itemView) {
                super(itemView);
                tvTitle1 = (TextView) itemView.findViewById(R.id.tv_title1);
                tvTitle2 = (TextView) itemView.findViewById(R.id.tv_title2);
                tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name);
                tvKarmaCount = (TextView) itemView.findViewById(R.id.tv_karma_count);
                tvDesription = (TextView) itemView.findViewById(R.id.tv_description);
                tvDimerLiked = (TextView) itemView.findViewById(R.id.tv_dimer_liked);
                civImage = (CircleImageView) itemView.findViewById(R.id.civ_image);
            }
        }
    }

}
