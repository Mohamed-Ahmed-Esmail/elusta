package com.example.elusta.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServicesPojoModel {


    @Expose
    @SerializedName("data")
    private DataEntity data;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("msg")
    private String msg;
    @Expose
    @SerializedName("status")
    private boolean status;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class DataEntity {
        @Expose
        @SerializedName("AllService")
        private List<AllserviceEntity> allservice;

        public List<AllserviceEntity> getAllservice() {
            return allservice;
        }

        public void setAllservice(List<AllserviceEntity> allservice) {
            this.allservice = allservice;
        }


    }

    public static class AllserviceEntity {
        @Expose
        @SerializedName("HasSub")
        private boolean hassub;
        @Expose
        @SerializedName("InspectFee")
        private int inspectfee;
        @Expose
        @SerializedName("icon")
        private String icon;
        @Expose
        @SerializedName("Description")
        private String description;
        @Expose
        @SerializedName("Name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public boolean getHassub() {
            return hassub;
        }

        public void setHassub(boolean hassub) {
            this.hassub = hassub;
        }

        public int getInspectfee() {
            return inspectfee;
        }

        public void setInspectfee(int inspectfee) {
            this.inspectfee = inspectfee;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
