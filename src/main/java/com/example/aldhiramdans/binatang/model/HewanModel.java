package com.example.aldhiramdans.binatang.model;

import org.json.JSONException;
import org.json.JSONObject;

public class HewanModel {
    private String nama;
    private String jenis;
    private String gambar;
    private String textEn;
    private String suara;

    public HewanModel() {
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSuara() {
        return suara;
    }

    public void setSuara(String suara) {
        this.suara = suara;
    }

    public static HewanModel parse(JSONObject object) throws JSONException {
        if (object == null) throw new JSONException("null");
        HewanModel model = new HewanModel();
        model.setNama(object.getString("nama"));
        model.setJenis(object.getString("jenis"));
        model.setGambar(object.getString("gambar"));
        model.setTextEn(object.getString("txten"));
        model.setSuara(object.getString("suara"));
        return model;
    }
}
