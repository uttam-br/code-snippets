package adapter;

import adapter.adapters.BankAPI;
import adapter.adapters.YesBankAdapaterAPI;

public class Client {

    // just need to change api object.
    static BankAPI bankAPI = new YesBankAdapaterAPI();

    public static void main(String[] args) {

        System.out.println("bank balance " + bankAPI.getBalance());

    }

}
