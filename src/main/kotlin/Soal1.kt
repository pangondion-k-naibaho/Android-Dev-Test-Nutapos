package com.saucedemo.pangondionkn

//Soal 1
//Dengan menggunakan bahasa kotlin, buatlah fungsi untuk menghitung Total
//Harga Sebelum Pajak (Dasar Pengenaan Pajak / Net Sales) dan Rupiah Pajak.
//Input :
//- total : number (misal 22000)
//- persen_pajak : number (misal 10)
//Output object :
//- net_sales
//- pajak_rp
//Hint : Lihat struk McDonald


//Untuk pengerjaan soal ini, kita bisa membuat data class terlebih dahulu untuk
//memuat kedua variabel jawaban yang dibutuhkan. kita beri nama TaxCalculationResult

data class TaxCalculationResult(
//    kita tentukan tipe data Double pada kedua variabel untuk memudahkan
//    perhitungan desimal
    val net_sales: Double,
    val pajak_rp : Double
)

//Lalu kita mendefinisikan fungsi perhitungan yang diminta sesuai soal.
//Fungsi menerima harga total, dan juga persen pajak (dalam rentang 1-99)
//dengan nilai kembalian adalah object data class TaxCalculationResult
fun calculateTax(total: Double, persen_pajak: Int): TaxCalculationResult{
//    Kita hitung net_sales
    val net_sales = total / (1 + persen_pajak / 100.0)

//    Kita hitung nilai pajak dalam rupiah
    val pajak_rp = total - net_sales

//    Kita kembalikan object TaxCalculationResult
    return TaxCalculationResult(net_sales, pajak_rp)
}

fun main() {
//    Kita bisa melakukan simulasi perhitungan di fungsi main
    val total = 22000.0
    val persenPajak = 10

    val result = calculateTax(total, persenPajak)
    println("Net Sales: Rp ${result.net_sales}")
    println("Pajak Rp ($persenPajak%): Rp ${result.pajak_rp}")
}