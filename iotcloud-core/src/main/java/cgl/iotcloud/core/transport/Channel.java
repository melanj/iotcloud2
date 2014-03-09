package cgl.iotcloud.core.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Channel <I, O> {
    private static Logger LOG = LoggerFactory.getLogger(Channel.class);

    private BlockingQueue<I> inQueue;

    private BlockingQueue<O> outQueue;

    private MessageConverter<I, O> converter = null;

    private Map transportProperties;

    public enum Direction {
        OUT,
        IN
    }

    private Direction direction;

    public Channel(Direction direction, Map transportProperties,
                   BlockingQueue<I> inQueue, BlockingQueue<O> outQueue) {
        this.inQueue = inQueue;
        this.outQueue = outQueue;

        this.direction = direction;
    }

    public BlockingQueue<I> getInQueue() {
        return inQueue;
    }

    public BlockingQueue<O> getOutQueue() {
        return outQueue;
    }

    public Direction getDirection() {
        return direction;
    }

    public void open() {
        Thread t = new Thread(new Worker());
        t.start();
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            boolean run = true;
            int errorCount = 0;
            while (run) {
                try {
                    try {
                        I input = inQueue.take();
                        O out = converter.convert(input);
                        outQueue.put(out);
                    } catch (InterruptedException e) {
                        LOG.error("Exception occurred in the worker listening for consumer changes", e);
                    }
                } catch (Throwable t) {
                    errorCount++;
                    if (errorCount <= 3) {
                        LOG.error("Error occurred " + errorCount + " times.. trying to continue the worker");
                    } else {
                        LOG.error("Error occurred " + errorCount + " times.. terminating the worker");
                        run = false;
                    }
                }
            }
            String message = "Unexpected notification type";
            LOG.error(message);
            throw new RuntimeException(message);
        }
    }
}