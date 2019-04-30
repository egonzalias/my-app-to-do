package com.gozalias.demo.user;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("data")
    public DataUser data;

    public class DataUser{
        @SerializedName("id")
        public String id;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;
    }


}
