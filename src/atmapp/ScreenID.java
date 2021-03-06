package atmapp;
import java.util.*;
public class ScreenID extends Screen {
   String ID = "ID";
   
   @Override
   public void displayAmount(String currency,double amount){
       System.out.printf(currency+"%,.2f", amount);
   }
   @Override
   public void displayWelcome(){
       displayMessageLine("\nSelamat Datang!");
   }
   @Override
   public void displayThanksYou(){
       displayMessageLine("\nTerimakasih ! Selamat Tinggal!");
   }
   @Override
   public void displayInputAccount(){
       displayMessage("\nMasukan nomor akun anda : ");
   }
   @Override
   public void displayInputPIN(){
       displayMessage("\nMasukan PIN anda : ");
   }
   @Override
   public void displayInvalidAccountPIN(){
       displayMessageLine("Nomor akun atau PIN salah");
   }
   @Override
   public void displayExitSystem(){
       displayMessageLine("\nKeluar dari sistem...");
   }
   @Override
   public void displayInvalidSelection(){
       displayMessageLine("\nInput tidak valid. Coba lagi.");
   }
   @Override
   public void displayMenu(){
        displayMessageLine("\nMain menu:");
        displayMessageLine("1 - Info Saldo");
        displayMessageLine("2 - Tarik Tunai");
        displayMessageLine("3 - Setor Tunai");
        displayMessageLine("4 - Transfer");
        displayMessageLine("5 - Mutasi Rekening");
        displayMessageLine("6 - Pembayaran");
        displayMessageLine("7 - Ubah PIN");
        displayMessageLine("0 - Keluar\n");
        displayMessage("Pilihan : ");
   }
   @Override
   public void displayRecordBankStatement(){
       displayMessage("");
       displayMessage("No\tTanggal\t\tWaktu\t\tCredit\tDebit\tSaldo");
   }
   @Override
   public void displayBalanceInformation(double available, double total){
        displayMessageLine("\nInformasi Saldo:");
        displayMessage(" - Saldo yang tersedia: "); 
        displayAmount("$",available);
        displayMessage("\n - Total saldo:     ");
        displayAmount("$",total);
        displayMessageLine("");
   }
   @Override
   public void displayInsertAmount(String message){
        displayMessage("\nHarap masukan jumlah dana untuk "+message+ 
         "\ndalam satuan CENTS (atau 0 untuk cancel): ");
   }
   @Override
   public void displayInsertEnvelopeDeposit(double amount){
        displayMessage("Silakan masukkan amplop deposit yang berisi ");
        displayAmount("$",amount);
        displayMessageLine("");
   }
   @Override
   public void displayReceivedEnvelopeDeposit(){
       displayMessageLine("Amplop Anda telah diterima.\n" +
        "CATATAN: Uang yang baru saja disetorkan tidak akan tersedia\n" +
        "sampai kami memverifikasi\n" +
        "jumlah uang tunai terlampir dan\n" +
        "cek Anda bersih.");
   }
   @Override
   public void displayCancel(){
       displayMessageLine("Membatalkan transaksi...");
   }
   @Override
   public void displayTransferSuccess(double availableBalance){
        displayMessageLine("Transfer Berhasil...");
        displayMessageLine("Saldo anda sekarang : ");
        displayAmount("$",availableBalance);
   }
   @Override
   public void displayBalanceInsfulence(String message,double available,double amount){
        displayMessageLine("Saldo tidak mencukupi "
            + "untuk melakukan "+ message);
        displayMessage("Saldo : ");
        displayDollarAmount(available);
        displayMessageLine("");
        displayMessage("Jumlah "+message+" : ");
        displayDollarAmount(amount);
   }
   @Override
   public void displayInvalidAccount(){
       displayMessageLine("Nomor akun tidak ditemukan");
   }
   @Override
   public void displayDestinationTransfer(){
       displayMessage("Masukan nomor tujuan transfer : ");
   }
   @Override
   public void displayTakeCash(){
       displayMessageLine("Uang tunai Anda telah ditarik. Silakan ambil uang tunai Anda sekarang.");
   }
   @Override
   public void displayInvalidWithdrawal(){
       displayMessageLine("jumlah penarikan Anda tidak valid.");
       displayMessageLine("hanya berlaku untuk kelipatan 20 dolar");
   }
   @Override
   public void displayBillsInsfulence(){
       displayMessageLine("Lembaran uang tidak cukup");
   }
   @Override
   public void displayMenuWithdrawal(){
        displayMessageLine("\nMenu Penarikan :");
        displayMessageLine("1 - $20");
        displayMessageLine("2 - $40");
        displayMessageLine("3 - $60");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Lainnya");
        displayMessageLine("7 - Batalkan transaksi");
        displayMessage("\nPilihan : ");
   }
   
   @Override
   public void displayMenuPayment(){
        displayMessageLine("\nMenu Pembayaran:");
        displayMessageLine("1 - Voucher Game");
        displayMessageLine("2 - Pulsa");
        displayMessageLine("3 - Internet Kabel");
        displayMessageLine("4 - TV Satelit");
        displayMessageLine("5 - TopUp");
        displayMessageLine("6 - UKT");
        displayMessageLine("7 - PLN");
        displayMessageLine("8 - Tokopedia");
        displayMessageLine("0 - Kembali");
        displayMessage("\nInput: ");
   }
   
   @Override
   public void displayMenuInternetCable(){
        displayMessageLine("\nMenu Internet Kabel Indihome:");
        displayMessageLine("1 - 10MbPS/Bulan ($75)");
        displayMessageLine("2 - 15MbPS/Bulan ($100)");
        displayMessageLine("3 - 25MbPS/Bulan ($150)");
        displayMessageLine("4 - 50MbPS/Bulan ($250)");
        displayMessageLine("0 - Kembali");
        displayMessage("\nInput : ");
   }
   
   @Override
   public void displayMenuTvSatelite(){
        displayMessageLine("\nMenu TV Satelite Indovision:");
        displayMessageLine("1 - 10MbPS/Bulan ($75)");
        displayMessageLine("2 - 15MbPS/Bulan ($100)");
        displayMessageLine("3 - 25MbPS/Bulan ($150)");
        displayMessageLine("4 - 50MbPS/Bulan ($250)");
        displayMessageLine("0 - Kembali");
        displayMessage("\nInput : ");
   }
   
   @Override
   public void displayPaymentSuccess(String Payment){
       displayMessageLine(Payment + " Berhasil");
   }
   
    @Override
    public String getID() {
        return this.ID;
    }
    
    @Override
    public void displayTopUpSuccess(){
       displayMessageLine("TopUp Berhasil...");
   }
   
    @Override
    public void displayBalanceisInsfluence(){
        displayMessageLine("Saldo anda tidak mencukupi");
    }
    
    @Override
    public void displayCancelingTransaction(){
        displayMessageLine("Transaksi dibatalkan");
    }
    
    @Override
    public void displayTopUpMenu(){
        displayMessageLine("Topup Menu");
        displayMessageLine("- 1 OVO");
        displayMessageLine("- 0 Kembali");
         displayMessage("pilih Menu : ");
    }
    
   @Override
    public void displayOVOMenu(){
        displayMessageLine("\nTopUp Menu:");
        displayMessageLine("1 - $20");
        displayMessageLine("2 - $40");
        displayMessageLine("3 - $60");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Transaksi dibatalkan");
        displayMessage("\nMasukan pilihan anda: ");

         
    }
    
    @Override
    public void displayAmountTopUp(){
        displayMessage("\nSilahkan masukkan jumlah TopUp  " + 
         "Dollar (atau 0 untuk Membatalkan): ");
    }
    
    @Override
    public void displayinfo(){
            displayMessage("silahkan masukan 0159 sebelum memasukan nomor telepon anda");
    }
    
    @Override
    public void displayInputNumber(){
        displayMessage("\nSilahkan masukkan nomor rekening tujuan anda : ");
    }
    
    @Override 
    public void displayTransfer(){
        displayMessage("\nSilahkan masukkan jumlah " + "CENTS : ");
    }
    
    
    @Override 
    public void displaySaldo(){
        displayMessageLine("Saldo Tidak mencukupi");
    }
    
    @Override 
    public void displayInvalid(){
        displayMessageLine("Nomor telepon tujuan salah");
    }
    
    @Override 
    public void displayInformation(){
        displayMessage("masukkan 0159 sebelum nomor telepon");
    }
    
    @Override
    public void displayQuetion(){ 
        displayMessage("\nApakah yakin dengan transaksi ini  (1 Ya or 0 Batalakan) : ");
    }
    
    @Override
    public void displayTryAgain(){ 
        displayMessageLine("\nPemilihan tidak valid, Coba Lagi.");
    }
    
    @Override

    public void displayPaymentTokopedia(){
        displayMessageLine ("==== Pembayaran Tokopedia ====");
        displayMessage ("Input Kode Order : ");
    }
    
     @Override
    public void displaySucccessPaymentTokopedia(){
        displayMessageLine ("Pembayaran Tokopediamu Berhasil");
    }
 

    public void displayListrik(){
        displayMessage("\n=== Pembayaran PLN ===\n");
        displayMessageLine("1 - $10");
        displayMessageLine("2 - $20");
        displayMessageLine("3 - $50");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Transaksi dibatalkan");
        displayMessage("\nMasukan pilihan anda: ");
    }
    
    @Override
    public void displayInputError(){
        displayMessage("\nNomor PLN yang dimasukan salah. Silahkan coba lagi.\n");
    }
    
    @Override
    public void displayNotEnoughBalance(){
        displayMessageLine("Saldo Anda tidak cukup "
        + "untuk melakukan penarikan");
        displayMessage("Saldo : ");
    }
    
    @Override
    public void displayPLNBill(int amount){
        displayMessageLine("");
        displayMessage("Jumlah tagihan listrik : " + amount + "$");
    }
    
    @Override
    public void displayNegative(){
        displayMessageLine("Angka tidak boleh negative");
    }
} 