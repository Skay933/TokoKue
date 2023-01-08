package com.controlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Barang;
import com.models.Transaksi;

public class TransaksiController {
    private List<Transaksi> listTransaksi;
    private List<Barang> listKue;
    Scanner scan = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

    public TransaksiController(List<Transaksi> listTransaksi, List<Barang> listKue) {
        this.listTransaksi = listTransaksi;
        this.listKue = listKue;
        showKue();
        store();
    }

    void showKue() {
        System.out.println(
                "______________________________________________________________________________");
        System.out.println(
                "| NO |     Nama Barang     |          Harga          |          Stok         |");
        System.out.println(
                "==============================================================================");
        int i = 1;
        for (Barang barang : listKue) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s| %n", i++, barang.getNamaKue(),
                    Utility.toRupiah(barang.getHarga()),
                    barang.getStok());
        }
    }

    void store() {
        String inputan = "Y";
        do {

            System.out.println("\n~Ketik 0 kembali ke menu utama-");
            System.out.println("Masukkan Banyak jenis : ");
            int jenis = Utility.inputInt(scan.nextLine());
            for (int i = 1; i <= jenis; i++) {
                System.out.println("Input No :");
                int lokasiKue = Utility.inputInt(scan.nextLine());
                if (lokasiKue > 0 && --lokasiKue < listKue.size()) {

                    System.out.println("Jumlah");
                    int jumlah = Utility.inputInt(scan.nextLine());
                    int stok = listKue.get(lokasiKue).getStok();

                    if (jumlah <= stok) {

                        listKue.get(lokasiKue).setStok(stok -= jumlah);

                        String namaKue = listKue.get(lokasiKue).getNamaKue();
                        int Harga = listKue.get(lokasiKue).getHarga();
                        LocalDateTime sekarang = listKue.get(lokasiKue).getNow();
                        System.out.println("------------------------------------------------------------");
                        System.out.printf("Nama Kue |%-21s|Harga  |%-25s|Stok|%-23s| %n",
                                namaKue,
                                Utility.toRupiah(Harga),
                                listKue.get(lokasiKue).getStok());
                        System.out.println("total : " + Utility.toRupiah(jumlah * Harga));
                        Transaksi transaksi = new Transaksi();
                        transaksi.setNow(sekarang);
                        transaksi.setNamaKue(namaKue);
                        transaksi.setJumlah(jumlah);
                        transaksi.setHarga(Harga);
                        listTransaksi.add(transaksi);
                        System.out.println("Pembelian Berhasil");
                    } else {
                        System.out.println("Jumlah Pembelian Melebihi Stok");
                    }
                }
            }

            System.out.println("apakah ingin melanjutkan transaksi (Y/N) ? ");
            inputan = scan.nextLine();
        } while (inputan.equalsIgnoreCase("y"));
    }
}
