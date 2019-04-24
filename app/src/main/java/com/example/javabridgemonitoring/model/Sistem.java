package com.example.javabridgemonitoring.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Sistem {

        @SerializedName("sistem_id")
        @Expose
        private Integer sistemId;
        @SerializedName("sistem_name")
        @Expose
        private String sistemName;

        public Integer getSistemId() {
            return sistemId;
        }

        public void setSistemId(Integer sistemId) {
            this.sistemId = sistemId;
        }

        public String getSistemName() {
            return sistemName;
        }

        public void setSistemName(String sistemName) {
            this.sistemName = sistemName;
        }


}
