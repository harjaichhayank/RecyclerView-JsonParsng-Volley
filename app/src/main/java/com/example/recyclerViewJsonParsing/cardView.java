package com.example.recyclerViewJsonParsing;

class cardView {
    private String Url;
    private String CreatorName;
    private int Likes;

    cardView(String url, String creatorName, int likes) {
        setUrl(url);
        setCreatorName(creatorName);
        setLikes(likes);
    }

    String getUrl() { return Url; }
    String getCreatorName() { return CreatorName; }
    int getLikes() { return Likes; }

    private void setUrl(String Url) { this.Url = Url; }
    private void setLikes(int Likes) { this.Likes = Likes; }
    private void setCreatorName(String CreatorName) { this.CreatorName = CreatorName; }
}
