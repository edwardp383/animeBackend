package animeWatchlist;

import javax.persistence.*;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="anime_id")
    private Anime anime;

    private Integer episode;

    private Boolean episode_watched;

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime){
        this.anime = anime;
    }
    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer intInput){
        this.episode = intInput;
    }

    public Boolean getEpisode_watched() {
        return episode_watched;
    }

    public void setEpisode_watched(Boolean episode_watched) {
        this.episode_watched = episode_watched;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
