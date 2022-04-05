package com.tma.teamhr.DTO.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ResponseDTO {

    @Setter
    @Getter
    class Header{
        private int status_code;
    }

    @Setter
    @Getter
    class Body{
        private Object data;
    }

    @Setter
    @Getter
    class Message{
        private String messenger;
        private String error;
    }

    private Header header = new Header();
    private Body body = new Body();
    private Message message = new Message();

    public ResponseDTO(){}

    public ResponseDTO(int code, Object obj){
        setHeader(code);
        setData(obj);
    }

    public void setHeader(int code){
        this.header.setStatus_code(code);
    }

    public void setData(Object obj){
        this.body.setData(obj);
    }

    public void setMessage(String mes){
        this.message.setMessenger(mes);
    }

    public void setError(String err){
        this.message.setError(err);
    }
}
