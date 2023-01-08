package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.controlers.HasilController;
import com.controlers.KueController;
import com.controlers.TransaksiController;
import com.models.Barang;
import com.models.Transaksi;

public class App {
    static Scanner scan = new Scanner(System.in);
    public static final Locale locale = new Locale("in", "ID");

    public static void main(String[] args) throws Exception {
        List<Barang> listKue = new ArrayList<Barang>();
        List<Transaksi> listTransaksi = new ArrayList<Transaksi>();

        do {
            System.out.println("=== TOKO KUE LIST APP ===");
            System.out.println("[1] Data Kue");
            System.out.println("[2] Transaksi");
            System.out.println("[3] Laporan Transaksi");
            System.out.println("---------------------");
            System.out.print("Pilih menu> ");
        } while (showMenu(listKue, listTransaksi) != 0);

    }

    public static int showMenu(List<Barang> lkue, List<Transaksi> lTransaksi) {
        int selectedMenu = Utility.inputInt(scan.nextLine());

        switch (selectedMenu) {
            case 1:
                new KueController(lkue);
                break;

            case 2:
                new TransaksiController(lTransaksi, lkue);
                break;
            case 3:
                new HasilController(lTransaksi);
                break;
        }

        return selectedMenu;
    }

}
