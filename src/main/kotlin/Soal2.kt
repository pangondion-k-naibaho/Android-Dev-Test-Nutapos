package com.saucedemo.pangondionkn

//Soal 2
//Dengan menggunakan bahasa pemrograman kotlin, buatlah fungsi untuk
//menghitung total rupiah diskon dan total harga setelah diskon dengan inputan
//diskon persen bertingkat.
//Input :
//- discounts : IntArray
//misal : intArrayOf(20, 10)
//- total_sebelum_diskon : Int
//misal : 100000
//Output object :
//- total_diskon
//- total_harga_setelah_diskon

//Untuk pengerjaan soal ini, kita bisa membuat data class terlebih dahulu untuk
//memuat kedua variabel jawaban yang dibutuhkan. kita beri nama DiscountCalculationResult

data class DiscountCalculationResult(
//  kita tentukan tipe data Double pada kedua variabel untuk memudahkan
//  perhitungan desimal
    val total_discount: Double,
    val total_price_after_discount: Double
)

//Lalu kita mendefinisikan fungsi perhitungan yang diminta sesuai soal.
//Fungsi menerima array tax, dan harga total (sebelum dihitung dengan diskon)
//dengan nilai kembalian adalah object data class DiscountCalculationResult

fun calculateDiscount(taxes_percent: Array<Int>, totalPrice: Double): DiscountCalculationResult{
//    Kita langsung tentukan nilai total harga setelah diskon dengan nilai yang
//    sama dengan total harga sebelum di diskon.
//    Kita menentukannya demikian untuk mempermudah operasi perhitungan yang terjadi
//    secara berulang (loop)

    var total_price_after_discount = totalPrice

//    Kita lakukan operasi perhitungan secara berulang (loop)

    for(i in taxes_percent.indices){
        total_price_after_discount *=(1 - taxes_percent[i]/100.0)
    }

//    Untuk mengetahui harga total diskon, kita tinggal selisihkan harga total
//    dengan harga setelah dihitung dengan semua diskon

    val total_discount = totalPrice - total_price_after_discount

//    Kita kembalikan objek DiscountCalculationResult sebagai output dari fungsi
    return DiscountCalculationResult(total_discount, total_price_after_discount)
}

fun main(){
//    Kita dapat melakukan simulasi perhitungannya di fungsi main ini

    val discounts = arrayOf(20, 10)
    val total_price = 100000.0

    val result = calculateDiscount(discounts, total_price)

    println("Total Discount: Rp ${result.total_discount}")
    println("Total Price after Discounts: Rp ${result.total_price_after_discount}")
}