package com.senac.games.dto.response;

public class ParticipanteDTOUpdateResponse {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int id;

    private int status;
}
