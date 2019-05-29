package animeWatchlist;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String textInput){
        this.username = textInput;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String textInput){
        this.password = textInput;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String textInput){
        this.email = textInput;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
