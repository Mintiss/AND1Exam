package AND1.TheRasmussen.ui.lecture_eight;

public class DadJoke {

    private String id;
    private String joke;
    private String status;

    public DadJoke(String id, String joke, String status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    public DadJoke getDadJoke() {
        return new DadJoke(id,joke,status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
