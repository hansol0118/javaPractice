package com.ll.wiseSaying.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class WiseSaying {

    private int id;
    private String content;
    private String author;


    private LocalDateTime createDate;
    private LocalDateTime modifyDate;


    WiseSaying(){
        this.id = 0;
        this.content = "NULL";
        this.author = "NULL";
    }

    public WiseSaying(int id, String content, String author){
        this.id=id;
        this.content=content;
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
