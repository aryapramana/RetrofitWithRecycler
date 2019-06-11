package com.software.tempe.retrofitwithrecycler.service;

import com.software.tempe.retrofitwithrecycler.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    public final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getPost();
}
