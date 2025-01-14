package adapter;

import adapter.adapters.BankAPI;
import adapter.adapters.ICICIBankAdapterAPI;
import adapter.adapters.YesBankAdapaterAPI;

public class Client {

    public static void main(String[] args) {

        BankAPI iciciAPI = new ICICIBankAdapterAPI();
        iciciAPI.getBalance();
        System.out.println("icici balance " + iciciAPI.getBalance());

        BankAPI yesBankAPI = new YesBankAdapaterAPI();
        yesBankAPI.getBalance();
        System.out.println("yes bank balance " + yesBankAPI.getBalance());

    }

}
