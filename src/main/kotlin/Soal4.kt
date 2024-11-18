package com.saucedemo.pangondionkn

//Berdasarkan soal ke-4, kita definisikan terlebih dahulu data class yang dibutuhkan

data class FinanceIn(
    val id: Int,
    val date: String,
    val amount: Int
)
data class FinanceOut(
    val id: Int,
    val date: String,
    val amount: Int
)
data class FinanceStatement(
    val date: String,
    val amount_in: Int,
    val amount_out: Int,
    val balance: Int
)

// Fungsi untuk membuat laporan mutasi kas
fun generateFinanceStatement(
    uangMasuk: ArrayList<FinanceIn>,
    uangKeluar: ArrayList<FinanceOut>,
    startDate: String,
    endDate: String,
    initialBalance: Int
): ArrayList<FinanceStatement> {

    // Step 1: Kita filter data sesuai dengan periode nya
    val filteredIn = uangMasuk.filter { it.date in startDate..endDate }
    val filteredOut = uangKeluar.filter { it.date in startDate..endDate }

    // Step 2: Kita gabungkan data berdasarkan tanggal nya
    val dates = (filteredIn.map { it.date } + filteredOut.map { it.date }).toSet().sorted()
    val financeMapIn = filteredIn.associateBy { it.date }
    val financeMapOut = filteredOut.associateBy { it.date }

    // Step 3: Kita lakukan penghitungan saldo secara bertahap
    var currentBalance = initialBalance
    val result = ArrayList<FinanceStatement>()

    for (date in dates) {
        val amountIn = financeMapIn[date]?.amount ?: 0
        val amountOut = financeMapOut[date]?.amount ?: 0
        currentBalance += amountIn - amountOut
        result.add(FinanceStatement(date, amountIn, amountOut, currentBalance))
    }

    return result
}

fun main() {
//    Kita dapat simulasikan perhitungan di fungsi main
    val uangMasuk = arrayListOf(
        FinanceIn(1, "2021-09-29", 350000),
        FinanceIn(2, "2021-10-01", 200000),
        FinanceIn(3, "2021-10-03", 300000),
        FinanceIn(4, "2021-10-05", 150000),
    )

    val uangKeluar = arrayListOf(
        FinanceOut(1, "2021-09-30", 250000),
        FinanceOut(2, "2021-10-02", 100000),
        FinanceOut(3, "2021-10-04", 150000),
        FinanceOut(4, "2021-10-06", 50000),
    )

    // Generate laporan mutasi kas
    val startDate = "2021-10-01"
    val endDate = "2021-10-06"
    val initialBalance = 100000 // Saldo awal pada tanggal 2021-10-01

    val laporan = generateFinanceStatement(uangMasuk, uangKeluar, startDate, endDate, initialBalance)

    // Print hasil laporan
    laporan.forEach {
        println("Tanggal: ${it.date}, Masuk: ${it.amount_in}, Keluar: ${it.amount_out}, Saldo: ${it.balance}")
    }
}