package com.controlers;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Barang;

public class KueController {
    private List<Barang> listKue;
    static Scanner scan = new Scanner(System.in);

    public KueController(List<Barang> listKue) {
        this.listKue = listKue;
        menuKue();
    }

    void menuKue() {
        int pilih = 0;
        do {
            show();

            System.out.println("[1] Input Kue");
            System.out.println("[2] Update Kue");
            System.out.println("[3] Hapus Kue");
            System.out.println("[0] Halaman Utama");
            System.out.println("Pilih Menu \n ============");
            pilih = Utility.inputInt(scan.nextLine());

            switch (pilih) {
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    store();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    destroy();
                    break;
                default:
                    break;
            }
        } while (pilih != 0);
    }

    void show() {
        System.out.println(
                "===========================================================================");
        System.out.println(
                "| NO |     Nama Kue     |          Harga          |          Stok         |");
        System.out.println(
                "===========================================================================");
        int i = 1;
        for (Barang barang : listKue) {
            System.out.printf("|%-4s|%-18s|%-25s|%-23s| %n", i++, barang.getNamaKue(),
                    Utility.toRupiah(barang.getHarga()),
                    barang.getStok());
        }
    }

    void store() {

        Barang b = new Barang();
        System.out.println("Masukkan Nama Kue");
        b.setNamaKue(scan.nextLine());
        System.out.println("Masukkan Harga");
        b.setHarga(Utility.inputInt(scan.nextLine()));
        System.out.println("Masukkan Stok Barang");
        b.setStok(Utility.inputInt(scan.nextLine()));
        listKue.add(b);
    }

    void update() {
        System.out.println("======Ubah Data Kue======");
        System.out.println("~Kosongkan Data Jika Tidak Ingin Dirubah~");
        System.out.println("~Ketik 0 kembali ke menu utama-");
        System.out.println("Pilih NO :");
        int inputan = Utility.inputInt(scan.nextLine());
        if (inputan > 0 && --inputan < listKue.size()) {
            System.out.println("Masukkan nama");
            String nama = scan.nextLine();

            if (!nama.equals("")) {
                listKue.get(inputan).setNamaKue(nama);
            }
            System.out.println("Masukkan Harga");
            int harga = Utility.inputInt(scan.nextLine());

            if (harga >= 0) {
                listKue.get(inputan).setHarga(harga);
            }

            System.out.println("Masukkan Stok");
            int stok = Utility.inputInt(scan.nextLine());
            if (stok >= 0) {
                listKue.get(inputan).setStok(stok);
            }
        }
    }

    void destroy() {
        System.out.println("Masukkan No");
        int inputan = Utility.inputInt(scan.nextLine());

        if (inputan > 0 && --inputan < listKue.size()) {
            listKue.remove(inputan);
            System.out.println("\n Data Berhasil Dihapus \n");
        }
    }
}
