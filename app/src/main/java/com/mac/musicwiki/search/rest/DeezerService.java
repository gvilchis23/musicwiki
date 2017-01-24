package com.mac.musicwiki.search.rest;


import java.util.List;
import com.mac.musicwiki.search.model.SearchVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


/**
 * Created by memoPilgrim on 13/12/16.
 */

public interface DeezerService {

    @Headers({
            "X-Mashape-Key:XyEFiwr6KLmshHAps1Q3ctaSWsD4p1QgDygjsnuzHifnblPAXn",
            "Accept:text/plain"
    })
    @GET("search")
    Call<SearchVO> getInformationBySearch(@Query("q") String artist);

}
