public class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(){
        this.id = 0;
        this.content = "NULL";
        this.author = "NULL";
    }

    WiseSaying(int id, String content, String author){
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
}