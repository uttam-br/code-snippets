import org.apache.log4j.Logger;

public class TransferServiceImpl extends TransferService {
    private final static Logger logger = Logger.getLogger(TransferServiceImpl.class);

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        logger.info("Has transfer of " + amount + "$ completed successfully? : " + outcome);
    }

    @Override
    protected void beforeTransfer(long amount) {
        logger.info("Preparing to transfer " + amount + "$.");
    }
}
