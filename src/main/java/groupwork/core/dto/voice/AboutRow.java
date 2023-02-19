package groupwork.core.dto.voice;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AboutRow {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;
    private String message;

    public AboutRow(String about, LocalDateTime creationTime ) {
        this.message = about;
        this.creationTime = creationTime;
    }

    public AboutRow() {
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getMessage() {
        return message;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AboutRow aboutRow = (AboutRow) o;

        if (creationTime != null ? !creationTime.equals(aboutRow.creationTime) : aboutRow.creationTime != null)
            return false;
        return message != null ? message.equals(aboutRow.message) : aboutRow.message == null;
    }

    @Override
    public int hashCode() {
        int result = creationTime != null ? creationTime.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return   "creationTime=" + creationTime +
                ", message=" + message ;
    }
}
