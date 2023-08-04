package hw30server;

import java.util.concurrent.ExecutorService;

public class ExecutorServiceWrapper implements AutoCloseable {
    private ExecutorService executorService;

    public ExecutorServiceWrapper(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void close() {
        executorService.shutdown();
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}
