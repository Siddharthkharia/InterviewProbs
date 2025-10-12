package Done.BankAccountApis;

public class Transaction {

    public long timestamp;
    public long amount;
    public String uuid;

    public Transaction(long timestamp, long amount, String uuid){
        this.timestamp = timestamp;
        this.amount = amount;
        this.uuid = uuid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
