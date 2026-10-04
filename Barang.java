/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.tb2baru;
/**
 *
 * @author Lisa Damayanti
 */

public class Barang {
    private String nama;
    private int jumlah;
    private double harga;
    private int diskon; // dalam persen

    public Barang(String nama, int jumlah, double harga, int diskon) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.diskon = diskon;
    }

    public double getSubTotal() {
        return jumlah * harga;
    }

    public double getDiskonAmount() {
        return getSubTotal() * diskon / 100;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHarga() {
        return harga;
    }
}
