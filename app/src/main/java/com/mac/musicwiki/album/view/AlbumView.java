package com.mac.musicwiki.album.view;


import com.mac.musicwiki.BaseView;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.model.SearchVO;

import java.util.List;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public interface AlbumView extends BaseView {
    boolean addToFavorite(String artist);
}