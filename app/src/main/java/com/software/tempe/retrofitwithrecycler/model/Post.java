package com.software.tempe.retrofitwithrecycler.model;

public class Post {
    private int userId;
    private Integer id;
    private String title;
    private String body;

    public Post(int userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


}
