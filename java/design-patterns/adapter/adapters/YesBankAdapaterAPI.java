package adapter.adapters;

import adapter.banks.YesBankAPI;

public class YesBankAdapaterAPI implements BankAPI {

    YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance() {
        return yesBankAPI.getAccountBalance();
    }

}
