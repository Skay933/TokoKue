package com.models;

import java.time.LocalDateTime;

public class Transaksi {
    private String NamaKue;
    private int jumlah, harga;
    private LocalDateTime now = LocalDateTime.now();

    public String getNamaKue() {
        return NamaKue;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public void setNamaKue(String namaKue) {
        NamaKue = namaKue;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Transaksi() {

    }
}
