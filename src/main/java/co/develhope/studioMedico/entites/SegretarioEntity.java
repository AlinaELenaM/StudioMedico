package co.develhope.studioMedico.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "segretario")
public class SegretarioEntity extends PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_segretario", nullable = false)
    private Long id;
    @Column(name = "sede_lavoro", nullable = false)
    private String sedeLavoro;

    @ManyToMany
    @JoinTable(name = "medico_segretario",
            joinColumns =
            @JoinColumn(name = "id_segretario", referencedColumnName = "id_segretario"),
            inverseJoinColumns =
            @JoinColumn(name = "id_medico", referencedColumnName = "id_medico"))
    private List<MedicoEntity> listaMedici;


    public SegretarioEntity(String nome, String cognome, String email, String contattoTelefonico, String sedeLavoro, String creatoDa) {
        super(nome, cognome, email, contattoTelefonico, creatoDa);
        this.sedeLavoro = sedeLavoro;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSedeLavoro() {
        return sedeLavoro;
    }

    public void setSedeLavoro(String sedeLavoro) {
        this.sedeLavoro = sedeLavoro;
    }

    public List<MedicoEntity> getListaMedici() {
        return listaMedici;
    }

    public void setListaMedici(List<MedicoEntity> listaMedici) {
        this.listaMedici = listaMedici;
    }
}
