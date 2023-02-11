package groupwork.core.dto;

import java.time.LocalDateTime;

public class AboutRow {
    private LocalDateTime creationTime;
    private String message;

    public AboutRow(LocalDateTime creationTime, String about) {
        this.creationTime = creationTime;
        this.message = about;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getMessage() {
        return message;
    }
}
