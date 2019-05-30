package animeWatchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private  UserRepository userRepository;

    @GetMapping("/anime/list/{id}")
    public HashMap<String, Object> findUser(@PathVariable("id") Long id)throws Exception{
        Optional<User> response = userRepository.findById(id);
        if(response.isPresent()){
            User user = response.get();
            Iterable<Anime> anime = animeRepository.findByUser(user);
            HashMap<String, Object> result = new HashMap<>();
            result.put("user", user);
            result.put("anime", anime);
            return result;
        }
        throw new Exception("Could not find your anime");
    }
    @GetMapping("/anime/{id}")
    public Anime show(@PathVariable("id") Long id) throws Exception {
        Optional<Anime> response = animeRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        throw new Exception("that anime does not");
    }

    @PostMapping("/anime")
    public Anime createPost(@RequestBody Anime req, HttpSession session) throws Exception{
        User user = userRepository.findByUsername(session.getAttribute("username").toString());
        if (user == null){
            throw new Exception("you must be logged in");
        }
        req.setUser(user);
        Anime newAnime = animeRepository.save(req);
        return newAnime;
    }

    @DeleteMapping("/anime/{id}")
    public String[] delete(@PathVariable("id") Long id){
        animeRepository.deleteById(id);
        return(new String[]{"deleted route hit, deleted"});
    }

    @PutMapping("/anime/{id}")
    public Anime edit(@PathVariable("id") Long id, @RequestBody Anime formData) throws Exception{
        Optional<Anime> response = animeRepository.findById(id);
        if (response.isPresent()){
            Anime anime = response.get();
            anime.setEpisode(formData.getEpisode());
            return animeRepository.save(anime);
        }
        throw new Exception("no Post");
    }

}
