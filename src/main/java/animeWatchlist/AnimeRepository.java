package animeWatchlist;

import org.springframework.data.repository.CrudRepository;

public interface AnimeRepository extends CrudRepository<Anime, Long> {
    Iterable<Anime> findByUser(User user);
}
