package by.academy.it.dto;

public class CheckLoginDto {
    private boolean isSuccessful;

    public CheckLoginDto() {
        this.isSuccessful = false;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
