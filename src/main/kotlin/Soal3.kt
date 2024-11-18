package com.saucedemo.pangondionkn

//Soal 3
//Dengan menggunakan bahasa pemrograman kotlin, buatlah fungsi untuk
//menghitung share revenue ojek online gofood / grabfood / shopeefood.
//Input :
//- harga_sebelum_markup : number (misal 10000)
//- markup_persen : number (misal 10 / 20 / 25)
//- share_persen : number (misal 20)
//Output object :
//- net_untuk_resto
//- share_untuk_ojol

//Untuk pengerjaan soal ini, kita bisa membuat data class terlebih dahulu untuk
//memuat kedua variabel jawaban yang dibutuhkan. kita beri nama RevenueShareResult

data class RevenueShareResult(
    val net_untuk_resto: Double,
    val share_untuk_ojol: Double
)

//Lalu kita mendefinisikan fungsi perhitungan yang diminta sesuai soal.
//Fungsi menerima harga sebelum Markup, markup persen, dan share persen
//dengan nilai kembalian adalah object data class RevenueShareResult
fun calculateRevenueShare(
    hargaSebelumMarkup: Double,
    markupPersen: Int,
    sharePersen: Int
): RevenueShareResult {
    // Hitung harga setelah markup
    val hargaSetelahMarkup = hargaSebelumMarkup * (1 + markupPersen / 100.0)

    // Hitung share untuk ojol
    val shareOjol = hargaSetelahMarkup * (sharePersen / 100.0)

    // Hitung net untuk restoran
    val netResto = hargaSetelahMarkup - shareOjol

    // Return hasil sebagai objek RevenueShareResult
    return RevenueShareResult(
        net_untuk_resto = netResto,
        share_untuk_ojol = shareOjol
    )
}

fun main() {
//    Kita bisa simulasikan perhitungannya di fungsi main
    val hargaSebelumMarkup = 10000.0
    val markupPersen = 20 // Markup 20%
    val sharePersen = 20 // Share ojol 20%

    val result = calculateRevenueShare(hargaSebelumMarkup, markupPersen, sharePersen)
    println("Net untuk Restoran: Rp ${result.net_untuk_resto}")
    println("Share untuk Ojol: Rp ${result.share_untuk_ojol}")
}
