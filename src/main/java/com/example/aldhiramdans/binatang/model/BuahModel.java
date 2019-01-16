package com.example.aldhiramdans.binatang.model;

import org.json.JSONException;
import org.json.JSONObject;

public class BuahModel {
    private int type;
    private String name;
    private String vitamin;
    private String gambar;
    private String manfaat;
    private String bahaya;

    public BuahModel() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVitamin() {
        return vitamin;
    }

    public void setVitamin(String vitamin) {
        this.vitamin = vitamin;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public String getBahaya() {
        return bahaya;
    }

    public void setBahaya(String bahaya) {
        this.bahaya = bahaya;
    }

    public static BuahModel parse(JSONObject object) throws JSONException {
        if (object == null) throw new JSONException("null");
        BuahModel model = new BuahModel();
        model.setName(object.getString("nama"));
        model.setType(object.getInt("type"));
        model.setManfaat(object.getString("manfaat"));
        model.setGambar(object.getString("gambar"));
        model.setBahaya(object.getString("bahaya"));
        return model;
    }
}
