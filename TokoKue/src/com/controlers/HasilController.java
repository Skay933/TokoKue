package com.controlers;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Transaksi;

public class HasilController {
    private List<Transaksi> listTransaksi;
    static Scanner scan = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

    public HasilController(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
        showHistory();
    }

    void showHistory() {
        System.out.println(
                "__________________________________________________________________________________________________________________________");
        System.out.println(
                "| NO |           TANGGAL           |        Nama KUE     |   JUMLAH    |          Harga          |          Total        |");
        System.out.println(
                "==========================================================================================================================");
        int i = 1;
        for (Transaksi transaksi : listTransaksi) {
            System.out.printf("|%-4s|%-10s|%-21s|%-13s|%-25s|%-23s| %n",
                    i++,
                    transaksi.getNow(),
                    transaksi.getNamaKue(),
                    transaksi.getJumlah(),
                    Utility.toRupiah(transaksi.getHarga()),
                    Utility.toRupiah(transaksi.getJumlah() * transaksi.getHarga()));
            System.out.println(" ");
        }
    }
}
