package BankAccountApis;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class BankAccount {
    private long currentBalance;
    private List<Transaction> transactionList;
    private Comparator<Transaction> timeComparator;
    private Integer accountId;

    public BankAccount(Integer accountId, long openingBalance){
        this.accountId=accountId;
        this.transactionList = new ArrayList<>();
        this.timeComparator = Comparator.comparing(Transaction::getTimestamp);
        this.currentBalance = openingBalance;

        this.addTransaction(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHoursMinutes(0,0)),0);
    }

    public void addTransaction(long timestamp, long amount){
        long previousTransactionBal = this.transactionList.get(transactionList.size()-1).getAmount();
        String uuid = UUID.randomUUID().toString();
        Transaction t = new Transaction(timestamp,previousTransactionBal+amount,uuid);

        this.transactionList.add(t);
        this.transactionList.sort(timeComparator);

        this.currentBalance = previousTransactionBal+amount;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public int findLastLessOrEqual(long timestamp){
        int len = this.transactionList.size();
        int left = 0;
        int right = len-1;
        int mid = -1;
        int ans =-1;

        while (left<=right){
            mid = left + (right - left)/2;
            if (this.transactionList.get(mid).getTimestamp()<=timestamp){
                ans = mid ;
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }

}
