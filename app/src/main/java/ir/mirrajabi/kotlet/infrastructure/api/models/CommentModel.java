package ir.mirrajabi.kotlet.infrastructure.api.models;

import com.google.gson.annotations.SerializedName;

// A Java class side by side with a Kotlin class
public class CommentModel {
    @SerializedName("postId")
    private int mPostId;
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("body")
    private String mMessage;

    public int getPostId() {
        return mPostId;
    }

    public CommentModel setPostId(int postId) {
        mPostId = postId;
        return this;
    }

    public int getId() {
        return mId;
    }

    public CommentModel setId(int id) {
        mId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public CommentModel setName(String name) {
        mName = name;
        return this;
    }

    public String getEmail() {
        return mEmail;
    }

    public CommentModel setEmail(String email) {
        mEmail = email;
        return this;
    }

    public String getMessage() {
        return mMessage;
    }

    public CommentModel setMessage(String message) {
        mMessage = message;
        return this;
    }
}
