package BankAccountApis;

import java.util.HashMap;
import java.util.Map;

public class BankingService {

    public Map<Integer,BankAccount> accountsMap = new HashMap<>();

    public BankAccount getAccount(Integer accountId){
        return this.accountsMap.get(accountId);
    }

    public void credit(Integer accountId, long timestamp, long amount){
        this.accountsMap.get(accountId).addTransaction(timestamp,amount);
    }

    public void debit(Integer accountId, long timestamp, long amount) throws Exception {
        if(this.accountsMap.get(accountId).getCurrentBalance() > amount){
            this.accountsMap.get(accountId).addTransaction(timestamp,-amount);
        }else throw new Exception("Insufficient Account Balance");
    }

    public void addAccount(Integer accountId, long openingBalance){
        BankAccount account = new BankAccount(accountId,openingBalance);
    }

    public long balanceChange(int accountId, long start, long end){
        BankAccount acc = this.accountsMap.get(accountId);
        int startIndx = acc.findLastLessOrEqual(start);
        int endIndx =  acc.findLastLessOrEqual(end);

        long startBalance = acc.getTransactionList().get(startIndx).getAmount();
        long endBalance = acc.getTransactionList().get(endIndx).getAmount();
        return endBalance-startBalance;
    }

    public long currentBalance(Integer accountId){
        return this.accountsMap.get(accountId).getCurrentBalance();
    }

}
