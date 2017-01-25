package com.mac.musicwiki.favorites.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mac.musicwiki.App;
import com.mac.musicwiki.R;
import com.mac.musicwiki.album.model.FavoriteVO;
import com.mac.musicwiki.database.DatabaseHandler;
import com.mac.musicwiki.favorites.presenter.FavoritesPresenter;
import com.mac.musicwiki.search.view.SearchActivity;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeleteFavActivity extends AppCompatActivity implements DeleteFavView{
    @Inject FavoritesPresenter favoritesPresenter;
    @BindView(R.id.imageAlbum) ImageView imgCover;
    @BindView(R.id.artis) TextView artist;
    @BindView(R.id.album) TextView album;
    @BindView(R.id.rating) RatingBar ratingBar;
    @BindView(R.id.btnDelete) Button btnDelete;
    DatabaseHandler db = new DatabaseHandler(this);
    private FavoriteVO item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_fav);
        App.getAppComponent(this).inject(this);
        ButterKnife.bind(this);
        Intent i = getIntent();
        item =  (FavoriteVO) i.getSerializableExtra("favorite");
        artist.setText(item.getName());
        album.setText(item.getAlbum());
        ratingBar.setRating(item.getRating());
        Glide.with(DeleteFavActivity.this).load(item.getPicture()).into(imgCover);
    }

    public void deleteFav(View view) {
        if(deleteFavorite(item)){
            Intent i = new Intent(DeleteFavActivity.this, FavoritesActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean deleteFavorite(FavoriteVO fav) {
        favoritesPresenter.attachDB(db);
        return  favoritesPresenter.deleteFavorite(fav);
    }
}