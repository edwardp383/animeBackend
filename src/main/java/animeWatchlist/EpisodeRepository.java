package animeWatchlist;

import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    Iterable<Episode> findByAnime(Anime anime);
}

