package com.tma.teamhr.DTO.ResponseDTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ResponseDTO {

    @Setter
    @Getter
    class Header{
        private HttpStatus statusCode;
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
        private Throwable error;
        private ZonedDateTime timestamp;
    }

    private Header header = new Header();
    private Body body = new Body();
    private Message message = new Message();

    public ResponseDTO(){}

    public ResponseDTO(HttpStatus code, Object obj){
        setHeader(code);
        setData(obj);
    }

    public void setHeader(HttpStatus code){
        this.header.setStatusCode(code);
    }

    public void setData(Object obj){
        this.body.setData(obj);
    }

    public void setMessage(String mes){
        this.message.setMessenger(mes);
    }

    public void setError(Throwable err){
        this.message.setError(err);
    }

    public void setTime(ZonedDateTime zonedDateTime){
        this.message.setTimestamp(zonedDateTime);
    }
}
