public class Transfer {
    private String transactionId;
    private String sender;
    private Long amount;

    public Transfer(String transactionId, String sender, Long amount) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getSender() {
        return sender;
    }

    public Long getAmount() {
        return amount;
    }
}
