package com.example.elusta.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPojoModel {

    @Expose
    @SerializedName("data")
    private Data data;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("msg")
    private String msg;
    @Expose
    @SerializedName("status")
    private boolean status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getStatus(String mohamed, String ahmed) {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("InspectFee")
        private int InspectFee;
        @Expose
        @SerializedName("photo")
        private String photo;
        @Expose
        @SerializedName("mobile")
        private String mobile;
        @Expose
        @SerializedName("isactive")
        private boolean isactive;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("last_logindate")
        private String last_logindate;
        @Expose
        @SerializedName("last_name")
        private String last_name;
        @Expose
        @SerializedName("first_name")
        private String first_name;
        @Expose
        @SerializedName("access_token")
        private String access_token;

        public int getInspectFee() {
            return InspectFee;
        }

        public void setInspectFee(int InspectFee) {
            this.InspectFee = InspectFee;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public boolean getIsactive() {
            return isactive;
        }

        public void setIsactive(boolean isactive) {
            this.isactive = isactive;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLast_logindate() {
            return last_logindate;
        }

        public void setLast_logindate(String last_logindate) {
            this.last_logindate = last_logindate;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }
}
