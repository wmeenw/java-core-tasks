package task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts){
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        ConnectionException lastException = null;
        for (int i = 0; i < maxAttempts; ++i){
            try (Connection connection = manager.getConnection()){
                connection.execute(command);
                return;
            }
            catch (ConnectionException e){
                lastException = e;
            }
            catch (Exception e){
                throw new ConnectionException("Error closing connection", e);
            }
        }
        throw new ConnectionException("Failed after " + maxAttempts + " attempts", lastException);
    }
}
