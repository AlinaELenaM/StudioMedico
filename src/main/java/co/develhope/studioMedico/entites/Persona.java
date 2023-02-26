package co.develhope.studioMedico.entites;


import javax.persistence.*;

@MappedSuperclass
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "email", nullable = false , unique = true)
    private String email;
    @Column(name = "contatto_telefonico", nullable = false, unique = true)
    private String numeroTelefonico;

    public Persona() {
    }

    public Persona(long id, String nome, String cognome, String email, String numeroTelefonico) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
}
