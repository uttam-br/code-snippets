import org.apache.log4j.Logger;

public abstract class TransferService {

    private static final Logger logger = Logger.getLogger(TransferService.class);

    public boolean transfer(long amount) {
        logger.info("Transfer started");
        return true;
    }

    abstract protected void beforeTransfer(long amount);

    abstract protected void afterTransfer(long amount, boolean outcome);

}
