package animeWatchlist;

import javax.persistence.*;

@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String title;

    private String img;

    private String synopsis;

    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
