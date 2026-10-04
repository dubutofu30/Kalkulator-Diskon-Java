package com.mycompany.tb2baru;

import java.util.ArrayList;
import java.util.Scanner;

public class Tb2Baru {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        System.out.println("Selamat Datang di Kalkulator Diskon!");
        System.out.println("=== Masukkan Data Pembeli ===");

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();

        Pelanggan pelanggan = new Pelanggan(nama, id);
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n=== Masukkan Data Barang ===");
            System.out.print("Nama Barang: ");
            String namaBarang = input.nextLine();

            System.out.print("Jumlah Barang: ");
            int jumlah = input.nextInt();

            System.out.print("Harga Barang: ");
            double harga = input.nextDouble();

            System.out.print("Persentase Diskon (%): ");
            int diskon = input.nextInt();
            input.nextLine(); 

            Barang barang = new Barang(namaBarang, jumlah, harga, diskon);
            daftarBarang.add(barang);

            System.out.print("Tambah barang lagi? (ya/tidak): ");
            String jawab = input.nextLine();
            if (!jawab.equalsIgnoreCase("ya")) {
                lanjut = false;
            }
        }

        // Hitung dan tampilkan struk
        double totalHarga = 0;
        double totalDiskon = 0;

        System.out.println("\n===== STRUK PEMBELIAN =====");
        System.out.println("Nama: " + pelanggan.getNama());
        System.out.println("ID  : " + pelanggan.getId());
        System.out.println("----------------------------");

        for (Barang barang : daftarBarang) {
            double sub = barang.getSubTotal();
            double potongan = barang.getDiskonAmount();
            totalHarga += sub;
            totalDiskon += potongan;

            System.out.println(barang.getJumlah() + " x " + barang.getNama() + " @Rp" + barang.getHarga());
            System.out.println("  Subtotal: Rp" + sub + ", Diskon: Rp" + potongan);
        }

        double hargaSetelahDiskon = totalHarga - totalDiskon;
        double diskonTambahan = 0;

        if (totalHarga > 500000) {
            diskonTambahan = hargaSetelahDiskon * 0.05;
            hargaSetelahDiskon -= diskonTambahan;
            System.out.println("Diskon Tambahan 5%: Rp" + diskonTambahan);
        }

        System.out.println("----------------------------");
        System.out.println("Total Harga  : Rp" + totalHarga);
        System.out.println("Total Diskon : Rp" + totalDiskon);
        System.out.println("Total Bayar  : Rp" + hargaSetelahDiskon);

        System.out.print("Masukkan Uang Dibayarkan: ");
        double bayar = input.nextDouble();

        if (bayar < hargaSetelahDiskon) {
            System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
        } else {
            double kembalian = bayar - hargaSetelahDiskon;
            System.out.println("Uang Kembalian: Rp" + kembalian);
            System.out.println("Terima kasih telah berbelanja!");
        }

        input.close();
    }
}
