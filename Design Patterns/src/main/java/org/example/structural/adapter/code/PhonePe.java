package org.example.structural.adapter.code;

public class PhonePe {

    BankApiAdapter bankApiAdapter;

    public PhonePe(BankApiAdapter bankApiAdapter){
        this.bankApiAdapter = bankApiAdapter;
    }

    public void doSomething(){
        double bal = bankApiAdapter.getBalance("1234");
        bankApiAdapter.sendMoney( "1234","xyz",bal);
    }


}
