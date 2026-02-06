package edu.narxoz.galactic.dispatcher;

public class Result {

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    @Override
public String toString() {
    return "Result{ok=" + isSuccess() + ", message='" + getMessage() + "'}";
}

}
