package com.models;

import java.time.LocalDateTime;

public class Barang {
    private String NamaKue;
    private int stok, harga;
    private LocalDateTime now = LocalDateTime.now();

    public String getNamaKue() {
        return NamaKue;
    }

    public void setNamaKue(String namaKue) {
        NamaKue = namaKue;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Barang() {

    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

}
