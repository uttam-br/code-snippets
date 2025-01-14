package adapter.adapters;

import adapter.banks.ICICIBankAPI;

public class ICICIBankAdapterAPI implements BankAPI {

    ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public double getBalance() {
        return iciciBankAPI.getBalance();
    }

}
