package animeWatchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  EpisodeRepository episodeRepository;

    @GetMapping("/anime")
    public String hello(){
        return "hello out there";
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
}
